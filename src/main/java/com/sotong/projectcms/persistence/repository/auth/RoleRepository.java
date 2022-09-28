package com.sotong.projectcms.persistence.repository.auth;

import com.sotong.projectcms.persistence.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
