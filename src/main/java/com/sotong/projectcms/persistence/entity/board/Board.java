package com.sotong.projectcms.persistence.entity.board;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Board extends BoardBaseEntity {

    @Column(columnDefinition = "TINYTEXT default ''")
    private String boardName;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String enable;
}
