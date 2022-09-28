package com.sotong.projectcms.persistence.entity.auth;

import com.sotong.projectcms.persistence.entity.cmmn.BaseEntity;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class UserBaseEntity extends BaseEntity {
}
