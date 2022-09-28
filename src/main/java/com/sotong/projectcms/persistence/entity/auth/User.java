package com.sotong.projectcms.persistence.entity.auth;

import com.sotong.projectcms.persistence.entity.auth.type.UserState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Samuel Butta
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class User extends UserBaseEntity{

    @Column(columnDefinition = "VARCHAR(255) default ''", unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(255) default ''")
    private String password;

    @Column(columnDefinition = "VARCHAR(255) default ''")
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private UserState state;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}
