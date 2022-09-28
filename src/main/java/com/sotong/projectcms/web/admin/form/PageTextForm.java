package com.sotong.projectcms.web.admin.form;

import com.sotong.projectcms.persistence.entity.examples.cms.PageTextType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Samuel Butta
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageTextForm {

    @NotNull
    private String identity;

    @NotNull
    private String content;

    @NotNull
    private Long pageId;

    @NotNull
    private PageTextType type;

}
