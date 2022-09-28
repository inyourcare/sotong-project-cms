package com.sotong.projectcms.business.service.cms.api;

import com.sotong.projectcms.persistence.entity.examples.cms.Page;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Samuel Butta
 */
public interface StorageService {

    public void store(MultipartFile file, String identity, Page page);


    public Resource loadAsResource(String fileName);
}