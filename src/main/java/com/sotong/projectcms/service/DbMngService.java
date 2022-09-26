package com.sotong.projectcms.service;

import com.sotong.projectcms.repo.DbRepository;
import com.sotong.projectcms.web.request.CreateTableRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbMngService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbMngService.class);

    @Autowired
    DbRepository dbRepository;

    public void testQuery() {
        LOGGER.info("testQuery called");
//        dbRepository.testCreateDatabaseQuery();
    }

    ;

    public void createTable(CreateTableRequest req) throws Exception {
        LOGGER.info("createTable called" + "::Request->" + "," + req.getDatabaseName() + "," + req.getTableName() + "," + req.getColumns());
        dbRepository.createTable(req.getTableName(), req.getDatabaseName(), req.getColumns());
    }

    ;
}
