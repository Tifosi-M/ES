package com.es.ServiceImpl;

/**
 * Created by szp on 15/8/17.
 */

import com.es.IService.UserManager.IUserManagerService;
import com.es.domain.TUsersEntity;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserManagerServiceImplTest extends TestCase{
    @Autowired
    private IUserManagerService service;
    private TUsersEntity user;
    @Test
    public void Test(){
        Map<String,String> map= new HashMap<String,String>();
        map=service.login("张世杰", "123456", "ceshi");
        assertEquals("OK",map.get("status"));
    }


}
