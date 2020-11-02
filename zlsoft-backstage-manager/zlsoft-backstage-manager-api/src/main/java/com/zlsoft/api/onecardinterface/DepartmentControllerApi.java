package com.zlsoft.api.onecardinterface;

import com.zlsoft.framework.entitys.*;
import com.zlsoft.framework.model.response.QueryResponseResult;
import com.zlsoft.framework.model.response.QueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value="一卡通部门层级管理接口",description = "一卡通部门层级管理接口，提供部门关联的增、删、改、查")
public interface DepartmentControllerApi {
    //一卡通部门查询
    @ApiOperation("分页查询部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findList(int page, int size, Department pageRequest);

    //一卡通部门层级查询
    @ApiOperation("分页查询部门层级列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findDeptTierList(int page, int size, DepartmentTier pageRequest);

    //一卡通部门层级关联查询
    @ApiOperation("分页查询部门层级关联列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findDeptTierRelevList(int page, int size, DepartmentTierRelev pageRequest);

    //一卡通部门层级添加
    @ApiOperation("一卡通部门层级添加")
    public QueryResponseResult deptTierInsert(DepartmentTier departmentTier);

    //一卡通部门层级修改
    @ApiOperation("一卡通部门层级修改")
    public QueryResponseResult deptTierUpdate(DepartmentTier departmentTier);

    //一卡通部门层级删除
    @ApiOperation("一卡通部门层级删除")
    public QueryResponseResult deptTierDelete(Integer id);



    //一卡通部门层级关联添加
    @ApiOperation("一卡通部门层级关联添加")
    public QueryResponseResult deptTierRelevInsert(List<DepartmentTierRelev> departmentTierRelev);



    //一卡通部门层级关联删除
    @ApiOperation("一卡通部门层级关联删除")
    public QueryResponseResult deptTierRelevDelete(List<DepartmentTierRelev> departmentTierRelev);




}
