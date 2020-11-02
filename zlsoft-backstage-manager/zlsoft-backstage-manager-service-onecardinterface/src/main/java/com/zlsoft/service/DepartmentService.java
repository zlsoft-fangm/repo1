package com.zlsoft.service;

import com.github.pagehelper.PageHelper;
import com.zlsoft.dao.DepartmentDao;
import com.zlsoft.framework.entitys.*;
import com.zlsoft.framework.exception.ExceptionCast;
import com.zlsoft.framework.model.response.CommonCode;
import com.zlsoft.framework.model.response.DeptCode;
import com.zlsoft.framework.model.response.QueryResponseResult;
import com.zlsoft.framework.model.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 部门查询
     * @param page
     * @param size
     * @param pageRequest
     * @return
     */
    public QueryResponseResult findList(int page, int size, Department pageRequest) {

        PageHelper.startPage(page,size);
        System.out.println("service层pageRequest:"+pageRequest);
        List<Department> all = this.departmentDao.findAll(pageRequest);
        System.out.println("list:"+all);
        QueryResult<Department> queryResult = new QueryResult<>();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }




    //一卡通部门层级查询
    public QueryResponseResult findListTier(int page, int size, DepartmentTier pageRequest){
        PageHelper.startPage(page,size);
        List<DepartmentTier> allTier = this.departmentDao.findAllTier(pageRequest);
        QueryResult<DepartmentTier> queryResult = new QueryResult<>();
        queryResult.setList(allTier);
        queryResult.setTotal(allTier.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    //一卡通部门层级关联查询
    public QueryResponseResult findDeptTierRelevList(int page, int size, DepartmentTierRelev pageRequest) {
        PageHelper.startPage(page,size);
        List<DepartmentTierRelev> allTierRelev = this.departmentDao.findAllTierRelev(pageRequest);
        QueryResult<DepartmentTierRelev> queryResult = new QueryResult<>();
        queryResult.setList(allTierRelev);
        queryResult.setTotal(allTierRelev.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }


    //一卡通部门层级添加
    public QueryResponseResult deptTierInsert(DepartmentTier departmentTier) {
        //检验添加部门层级的唯一性
        List<DepartmentTier> allTier = this.departmentDao.findAllTier(departmentTier);
        for(DepartmentTier tier:allTier){
            if(tier.get上级ID()==departmentTier.get上级ID() && tier.get名称().equals(departmentTier.get名称())){
                ExceptionCast.cast(DeptCode.DEPT_ADDPAGE_EXISTSNAME);
            }
        }
        //新增部门层级信息
        Integer integer = this.departmentDao.deptTierInsert(departmentTier);
        if(integer != 1){
            ExceptionCast.cast(CommonCode.INSET_ERROR);
        }
        return new QueryResponseResult(CommonCode.SUCCESS,null);
    }

    //一卡通部门层级更新
    public QueryResponseResult deptTierUpdate(DepartmentTier departmentTier) {
        //修改部门层级信息
        Integer integer = this.departmentDao.deptTierUpdate(departmentTier);
        if(integer != 1){
            ExceptionCast.cast(CommonCode.INSET_ERROR);
        }
        return new QueryResponseResult(CommonCode.SUCCESS,null);
    }

    //一卡通部门层级删除
    public QueryResponseResult deptTierDelete(Integer id) {
        Integer integer = this.departmentDao.deptTierDelete(id);
        if(integer != 1){
            ExceptionCast.cast(CommonCode.INSET_ERROR);
        }
        return new QueryResponseResult(CommonCode.SUCCESS,null);
    }

    //一卡通部门层级关联添加
    public QueryResponseResult deptTierRelevInsert(List<DepartmentTierRelev> departmentTierRelev) {
        Integer integer = this.departmentDao.deptTierRelevInsert(departmentTierRelev);
        if(integer <=0){
            ExceptionCast.cast(CommonCode.INSET_ERROR);
        }
        return new QueryResponseResult(CommonCode.SUCCESS,null);

    }

    //一卡通部门层级关联删除
    public QueryResponseResult deptTierRelevDelete(List<DepartmentTierRelev> departmentTierRelev) {
        Integer integer = this.departmentDao.deptTierRelevDelete(departmentTierRelev);
        if(integer <=0){
            ExceptionCast.cast(CommonCode.INSET_ERROR);
        }
        return new QueryResponseResult(CommonCode.SUCCESS,null);
    }
}



























