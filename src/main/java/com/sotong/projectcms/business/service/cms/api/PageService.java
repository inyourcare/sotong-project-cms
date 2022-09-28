package com.sotong.projectcms.business.service.cms.api;

import com.sotong.projectcms.persistence.entity.cms.Page;
import com.sotong.projectcms.web.admin.form.PageForm;
import com.sotong.projectcms.web.admin.form.PageTextForm;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Optional;

/**
 * @author Samuel Butta
 * @author Jakub Tucek
 */
public interface PageService {
    void savePage(PageForm pageForm);

    void savePageText(PageTextForm pageTextForm);

    void updatePageText(@NotNull String identity, @NotNull String content);

    /**
     * Map PageTexts of Page to hashmap.
     * Value of PageText object is accessed using get with indentity as a parameter.
     * e.g.: pageTexts.get('wellcome-text')
     *
     * @param pageOptional
     * @return map of identity and pageText
     */
    Map<String, String> createPageTextsMap(Optional<Page> pageOptional);

    Map<String,String> createPageImagesMap(Optional<Page> pageOpt);
}
