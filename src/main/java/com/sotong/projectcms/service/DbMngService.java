package com.sotong.projectcms.service;

import com.sotong.projectcms.repo.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbMngService {
    @Autowired
    DbRepository dbRepository;

    public void testQuery(){
        dbRepository.testQuery();
    };
}
