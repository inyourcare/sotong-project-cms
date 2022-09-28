package com.sotong.projectcms.business.service.cms;

import com.sotong.projectcms.business.service.cms.api.PageService;
import com.sotong.projectcms.persistence.entity.examples.cms.Page;
import com.sotong.projectcms.persistence.entity.examples.cms.PageImage;
import com.sotong.projectcms.persistence.entity.examples.cms.PageText;
import com.sotong.projectcms.persistence.repository.examples.cms.PageImageRepository;
import com.sotong.projectcms.persistence.repository.examples.cms.PageRepository;
import com.sotong.projectcms.persistence.repository.examples.cms.PageTextRepository;
import com.sotong.projectcms.web.admin.form.PageForm;
import com.sotong.projectcms.web.admin.form.PageTextForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
@Service
class PageServiceImpl implements PageService {


    private final PageRepository pageRepository;
    private final PageImageRepository pageImageRepository;
    private final PageTextRepository pageTextRepository;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository, PageImageRepository pageImageRepository, PageTextRepository pageTextRepository) {
        this.pageRepository = pageRepository;
        this.pageImageRepository = pageImageRepository;
        this.pageTextRepository = pageTextRepository;
    }

    // FIXME osetreni
    @Override
    public void savePage(PageForm pageForm) {
        Page page = new Page();
        page.setTitle(pageForm.getTitle());
        page.setUrl(pageForm.getUrl());

        Long parentPageId = pageForm.getParentPageId();

        Page parentPage = null;
        if (parentPageId != null) {
            parentPage = pageRepository.getOne(pageForm.getParentPageId());

            List<Page> subPages = parentPage.getSubPages();
            subPages.add(page);

            parentPage.setSubPages(subPages);
            pageRepository.save(parentPage);
        }
        page.setParentPage(parentPage);

        pageRepository.save(page);
    }

    @Override
    public void savePageText(PageTextForm pageTextForm) {
        PageText pageText = new PageText();

        Page page = pageRepository.getOne(pageTextForm.getPageId());

        pageText.setIdentity(pageTextForm.getIdentity());
        pageText.setContent(pageTextForm.getContent());
        pageText.setType(pageTextForm.getType());
        pageText.setPage(page);

        pageTextRepository.save(pageText);
    }

    @Override
    public void updatePageText(@NotNull String identity, @NotNull String content) {
        PageText pageText = pageTextRepository.findByIdentity(identity).orElse(null);
        pageText.setContent(content);

        pageTextRepository.save(pageText);
    }

    @Override
    public Map<String, String> createPageTextsMap(Optional<Page> pageOptional) {
        Map<String, String> pageTexts = pageOptional
                .map(this::mapPage)
                .orElseGet(Collections::emptyMap);

        return pageTexts;
    }

    @Override
    public Map<String, String> createPageImagesMap(Optional<Page> pageOpt) {
        Map<String, String> pageImages = pageOpt
                .map(this::mapPageImage)
                .orElseGet(Collections::emptyMap);

        return pageImages;
    }

    private Map<String, String> mapPage(Page page) {
        return page.getPageTexts()
                .stream()
                .collect(Collectors.toMap(PageText::getIdentity, PageText::getContent));
    }

    private Map<String, String> mapPageImage(Page page) {
        return page.getPageImages()
                .stream()
                .collect(Collectors.toMap(PageImage::getIdentity, PageImage::getFileName));
    }

}
