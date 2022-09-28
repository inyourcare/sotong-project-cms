package com.sotong.projectcms.persistence.entity.board;

import com.sotong.projectcms.persistence.entity.board.type.BoardSkinType;
import com.sotong.projectcms.persistence.entity.board.type.BoardType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Board extends BoardBaseEntity {

    @Column(columnDefinition = "TINYTEXT default ''")
    private String boardName;

    @Column(columnDefinition = "TINYTEXT default ''")
    private String greetingText;

    @Column(columnDefinition = "TINYTEXT default ''")
    private String postCategories;

    @Column(columnDefinition = "TINYTEXT default ''")
    private String optionalChoices;

//    @Column(columnDefinition = "INT default 3")
//    private Integer replyMaxDepth;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardSkinType boardSkinType;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String onlyAdmin;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String ableToReply;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String allowUnknown;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String allowUnknownReply;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String allowFileAttach;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String commentable;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String enable;
}
