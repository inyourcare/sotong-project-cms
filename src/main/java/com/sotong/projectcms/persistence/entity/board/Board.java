package com.sotong.projectcms.persistence.entity.board;

import com.sotong.projectcms.persistence.entity.board.type.BoardSkinType;
import com.sotong.projectcms.persistence.entity.board.type.BoardType;
import com.sotong.projectcms.persistence.entity.cmmn.type.Yn;
import com.sotong.projectcms.web.admin.form.BoardForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Board extends BoardBaseEntity {

    public Board(BoardForm form) {
        this.boardName = form.getBoardName();
        this.greetingText = form.getGreetingText();
        this.postCategories = form.getPostCategories();
        this.optionalChoices = form.getOptionalChoices();
        this.boardType = form.getBoardType();
        this.boardSkinType = form.getBoardSkinType();
        this.onlyAdmin = form.getOnlyAdmin();
        this.ableToReply = form.getAbleToReply();
        this.allowUnknown = form.getAllowUnknown();
        this.allowUnknownReply = form.getAllowUnknownReply();
        this.allowFileAttach = form.getAllowFileAttach();
        this.commentable = form.getCommentable();
        this.enable = form.getEnable();
    }

    @Column(columnDefinition = "VARCHAR(255) default ''", unique = true)
    private String boardName;

    @Column(columnDefinition = "TINYTEXT default ''")
    private String greetingText;

    @Column(columnDefinition = "VARCHAR(255) default ''")
    private String postCategories;

    @Column(columnDefinition = "VARCHAR(255) default ''")
    private String optionalChoices;

//    @Column(columnDefinition = "INT default 3")
//    private Integer replyMaxDepth;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardSkinType boardSkinType;

//    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn onlyAdmin;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn ableToReply;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn allowUnknown;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn allowUnknownReply;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn allowFileAttach;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn commentable;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private Yn enable;
}
