package com.sotong.projectcms.web.admin.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TableForm {
//    @NotBlank
//    @NotEmpty
//    @NotNull
//    private String datasourceType;
//    @NotBlank
//    @NotEmpty
//    @NotNull
//    private String databaseName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String tableName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String columns;
}
