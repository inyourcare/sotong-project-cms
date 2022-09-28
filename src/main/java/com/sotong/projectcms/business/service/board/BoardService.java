package com.sotong.projectcms.business.service.board;

import com.sotong.projectcms.persistence.entity.board.Board;
import com.sotong.projectcms.persistence.repository.board.BoardRepositoy;
import com.sotong.projectcms.utills.IAuthenticationFacade;
import com.sotong.projectcms.web.admin.form.BoardForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private static final Logger LOG = LoggerFactory.getLogger(BoardService.class);
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private BoardRepositoy boardRepositoy;

    public void createNewBoard(BoardForm form){
        LOG.info("createNewBoard called, " + authenticationFacade.getAuthentication().getName());
        Board newBoard = new Board(form);
        boardRepositoy.save(newBoard);
    }

//    @Value("${upload.work-dir}")
//    private String uploadWorkdir;
//
//    private static final String WORK_IMAGE = "image";
//
//    private Path uploadPath;

//    @Override
//    public void store(MultipartFile file, String identity, Page page) {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // PageImage pageImage = PageImage.builder().name(fileName).page(page).build(); FIXME
//
//        Optional<PageImage> pageImageOpt = pageImageRepository.getByIdentity(identity);
//
//        // update existujiciho obrazku, pripadne vytvoreni noveho
//        PageImage pageImage = pageImageOpt.orElseGet(PageImage::new);
//        pageImage.setFileName(fileName);
//        pageImage.setIdentity(identity);
//        pageImage.setPage(page);
//
//        pageImageRepository.save(pageImage);
//
//        if (file.isEmpty() || fileName.contains("..")) {
//            // TODO invalid file exception
//        }
//
//        try {
//            Files.copy(file.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
//            LOG.info("file with name {} was stored", fileName);
//        } catch (IOException e) {
//            LOG.error("file was not stored", e);
//        }
//
//    }
//
//    // TODO Optional
//    @Override
//    public Resource loadAsResource(String fileName) {
//        try {
//            Path file = uploadPath.resolve(fileName);
//            Resource resource = new UrlResource(file.toUri());
//
//            return resource;
//        } catch (MalformedURLException e) {
//            LOG.error("resource was not loaded", e);
//        }
//        return null;
//    }
}
