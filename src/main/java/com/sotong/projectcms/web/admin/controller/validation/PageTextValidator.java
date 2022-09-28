package com.sotong.projectcms.web.admin.controller.validation;

import com.sotong.projectcms.persistence.repository.examples.cms.PageTextRepository;
import com.sotong.projectcms.web.admin.form.PageTextForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Samuel Butta
 */
@Service
public class PageTextValidator {

    private PageTextRepository pageTextRepository;

    @Autowired
    public PageTextValidator(PageTextRepository pageTextRepository) {
        this.pageTextRepository = pageTextRepository;
    }

    /**
     * @param pageTextForm form object
     * @return true if page text can be added
     */
    public boolean isAddPageTextValid(PageTextForm pageTextForm) {
        boolean isValid = !pageTextRepository.findByIdentity(pageTextForm.getIdentity()).isPresent();

        return isValid;
    }

}
