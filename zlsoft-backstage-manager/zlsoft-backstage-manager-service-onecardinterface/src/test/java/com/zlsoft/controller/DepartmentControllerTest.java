package com.zlsoft.controller;

import com.zlsoft.framework.entitys.Department;
import com.zlsoft.framework.model.response.QueryResponseResult;
import com.zlsoft.framework.model.response.QueryResult;
import com.zlsoft.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentControllerTest {

    @Autowired
    public DepartmentService departmentService;

    @Test
    public void testController(){
        Department pageRequest = new Department();
        pageRequest.set上级ID(166);
        System.out.println(pageRequest);
        QueryResponseResult list = this.departmentService.findList(1, 10, pageRequest);
        QueryResult queryResult = list.getQueryResult();
        System.out.println(queryResult.getTotal());
        System.out.println("-------------");
        System.out.println("congent:"+queryResult.getList());
    }
}
