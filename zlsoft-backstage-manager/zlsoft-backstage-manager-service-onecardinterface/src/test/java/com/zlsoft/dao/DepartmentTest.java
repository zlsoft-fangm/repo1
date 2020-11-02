package com.zlsoft.dao;

import com.zlsoft.framework.entitys.Department;
import com.zlsoft.framework.entitys.DepartmentTier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void testdao(){
        DepartmentTier pageRequest = new DepartmentTier();
        pageRequest.set上级ID(1);
        pageRequest.set名称("呼吸内科");
        pageRequest.set排序(2);
        System.out.println(pageRequest);
        Integer integer = this.departmentDao.deptTierInsert(pageRequest);
        System.out.println("integer="+integer);
    }


}
