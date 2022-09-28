package com.sotong.projectcms.persistence.entity.auth;

import com.sotong.projectcms.persistence.entity.auth.type.UserState;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends UserBaseEntity{

    @Column(columnDefinition = "VARCHAR(255) default ''", unique = true, nullable = false)
    private String signInId;

    @Column(columnDefinition = "VARCHAR(255) default ''", unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(255) default ''", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(255) default ''")
    private String name;

    @Column(columnDefinition = "VARCHAR(255) default ''")
    private String nickName;

    @Column
    @Enumerated(EnumType.STRING)
    private UserState state;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}
