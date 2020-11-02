package com.zlsoft.service;

import com.zlsoft.framework.entitys.Department;
import com.zlsoft.framework.model.response.QueryResponseResult;
import com.zlsoft.framework.model.response.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentServiceTest {

    @Autowired
    public DepartmentService departmentService;

    @Test
    public void testService(){
        Department department = new Department();
        department.set上级ID(166);
        QueryResponseResult list = this.departmentService.findList(1, 10, department);
        QueryResult queryResult = list.getQueryResult();
        System.out.println(queryResult.getTotal());
        System.out.println("-------------");
        System.out.println("congent:"+queryResult.getList());
    }
}
