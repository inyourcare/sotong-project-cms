package com.sotong.projectcms.web.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateTableRequest {
    @NotBlank
    @NotEmpty
    @NotNull
    private String tableName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String databaseName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String columns;
}
