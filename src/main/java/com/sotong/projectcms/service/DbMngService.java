package com.sotong.projectcms.service;

import com.sotong.projectcms.repo.DbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbMngService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbMngService.class);

    @Autowired
    DbRepository dbRepository;

    public void testQuery(){
        LOGGER.info("testQuery called");
//        dbRepository.testCreateDatabaseQuery();
    };
}
