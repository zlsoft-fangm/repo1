package com.zlsoft.dao;

import com.zlsoft.framework.entitys.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentDao {
    //部门查询
    public List<Department> findAll(Department pageRequest);

    //一卡通部门层级查询
    public List<DepartmentTier> findAllTier(DepartmentTier pageRequest);

    //一卡通部门层级关联查询
    public List<DepartmentTierRelev> findAllTierRelev(DepartmentTierRelev pageRequest);


    //一卡通部门层级添加
    public Integer deptTierInsert(DepartmentTier departmentTier);

    //一卡通部门层级修改
    public  Integer deptTierUpdate(DepartmentTier departmentTier);

    //一卡通部门层级删除
    public Integer deptTierDelete(Integer id);



    //一卡通部门层级关联添加
    public Integer deptTierRelevInsert(@Param("list") List<DepartmentTierRelev> departmentTierRelevs);


    //一卡通部门层级关联删除
    public Integer deptTierRelevDelete(List<DepartmentTierRelev> departmentTierRelev);
}
