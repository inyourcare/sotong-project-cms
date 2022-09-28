package com.sotong.projectcms.web.auth.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SignInForm {
    @NotEmpty(message = "로그인 아이디를 입력하세요")
    private String signInId;
    @NotEmpty(message = "비밀번호를 입력하세요")
    private String password;
}
