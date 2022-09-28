package com.sotong.projectcms.persistence.repository.auth;

import com.sotong.projectcms.persistence.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findBySignInId(String signInId);

}
