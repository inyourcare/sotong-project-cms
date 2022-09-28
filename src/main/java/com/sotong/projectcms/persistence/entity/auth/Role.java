package com.sotong.projectcms.persistence.entity.auth;

import com.sotong.projectcms.persistence.entity.auth.type.RoleType;
import com.sotong.projectcms.persistence.entity.cmmn.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Role extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
