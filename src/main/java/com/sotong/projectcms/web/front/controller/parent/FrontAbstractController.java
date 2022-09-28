package com.sotong.projectcms.web.front.controller.parent;

import com.sotong.projectcms.persistence.entity.examples.cms.Page;
import com.sotong.projectcms.persistence.repository.examples.cms.PageRepository;
import com.sotong.projectcms.web.cmmn.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Optional;

/**
 * @author Samuel Butta
 */
public abstract class FrontAbstractController extends AbstractController {


    @Autowired
    protected PageRepository pageRepository;

//    @Autowired
//    protected PageService pageService;


    public void addPageData(Model model, String pageIdentity) {
        Optional<Page> pageOpt = pageRepository.getByUrl(pageIdentity);
//        Map<String, String> pageTexts = pageService.createPageTextsMap(pageOpt);
//        Map<String, String> pageImages = pageService.createPageImagesMap(pageOpt);


//        model.addAttribute("pageTexts", pageTexts);
//        model.addAttribute("pageImages", pageImages);
    }

}
