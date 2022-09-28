package com.sotong.projectcms.config;

import com.sotong.projectcms.persistence.entity.auth.Role;
import com.sotong.projectcms.persistence.entity.auth.User;
import com.sotong.projectcms.persistence.entity.auth.type.RoleType;
import com.sotong.projectcms.persistence.entity.auth.type.UserState;
import com.sotong.projectcms.persistence.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
public class DumDataConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        HashSet<Role> adminRoles = new HashSet<Role>();
        adminRoles.add(Role.builder().role(RoleType.ROLE_ADMIN).build());

        if (userRepository.findByEmail("admin@sotong.co.kr").isEmpty()) {
            User user = userRepository.save(User.builder()
                    .signInId("admin")
                    .email("admin@sotong.co.kr")
                    .password(passwordEncoder.encode("pass12#$"))
                    .name("김소통")
                    .nickName("adminNick").roles(adminRoles).state(UserState.STATE_NORMAL).build());
        }
    }
}