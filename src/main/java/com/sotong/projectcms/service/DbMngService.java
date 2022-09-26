package com.sotong.projectcms.service;

import com.sotong.projectcms.repo.DbRepository;
import com.sotong.projectcms.web.request.CmmnRequest;
import com.sotong.projectcms.web.request.CreateTableRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DbMngService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbMngService.class);

    @Autowired
    DbRepository dbRepository;

    public void testQuery(CmmnRequest req) throws SQLException {
        LOGGER.info("testQuery called");
        dbRepository.testSelectQuery(req.getDatasourceType(),req.getDatabaseName(),req.getTableName());
    }

    ;

    public void createTable(CreateTableRequest req) throws Exception {
        LOGGER.info("createTable called" + "::Request->" + "," + req.getDatabaseName() + "," + req.getTableName() + "," + req.getColumns());
        dbRepository.createTable(req.getDatasourceType(), req.getDatabaseName() , req.getTableName(), req.getColumns());
    }

    ;
}
