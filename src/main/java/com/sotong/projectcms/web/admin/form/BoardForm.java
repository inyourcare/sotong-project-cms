package com.sotong.projectcms.web.admin.form;

import com.sotong.projectcms.config.anotation.ValidEnum;
import com.sotong.projectcms.persistence.entity.board.type.BoardSkinType;
import com.sotong.projectcms.persistence.entity.board.type.BoardType;
import com.sotong.projectcms.persistence.entity.cmmn.type.Yn;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BoardForm {
    @NotEmpty(message = "게시판 이름은 필수입니다.")
    private String boardName;
    @ValidEnum(enumClass = Yn.class)
    private Yn ableToReply;
    @ValidEnum(enumClass = Yn.class)
    private Yn allowFileAttach;
    @ValidEnum(enumClass = Yn.class)
    private Yn allowUnknown;
    @ValidEnum(enumClass = Yn.class)
    private Yn allowUnknownReply;
    @ValidEnum(enumClass = BoardType.class)
    private BoardType boardType;
    @ValidEnum(enumClass = BoardSkinType.class)
    private BoardSkinType boardSkinType;
    @ValidEnum(enumClass = Yn.class)
    private Yn commentable;
    @ValidEnum(enumClass = Yn.class)
    private Yn enable;
    private String greetingText;
    @ValidEnum(enumClass = Yn.class)
    private Yn onlyAdmin;
    private String optionalChoices;
    private String postCategories;

}
