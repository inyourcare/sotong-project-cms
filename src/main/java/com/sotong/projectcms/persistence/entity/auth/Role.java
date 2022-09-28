package com.sotong.projectcms.persistence.entity.auth;

import com.sotong.projectcms.persistence.entity.auth.type.RoleType;
import com.sotong.projectcms.persistence.entity.cmmn.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Samuel Butta
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
