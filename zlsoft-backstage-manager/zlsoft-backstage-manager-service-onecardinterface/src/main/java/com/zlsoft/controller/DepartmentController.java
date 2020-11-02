package com.zlsoft.controller;

import com.zlsoft.api.onecardinterface.DepartmentControllerApi;
import com.zlsoft.framework.entitys.*;
import com.zlsoft.framework.exception.ExceptionCast;
import com.zlsoft.framework.model.response.CommonCode;
import com.zlsoft.framework.model.response.QueryResponseResult;
import com.zlsoft.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController implements DepartmentControllerApi {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/list/{page}/{size}")
    @Override
    public QueryResponseResult findList(@PathVariable("page") int page,
                                        @PathVariable("size") int size,
                                        Department pageRequest) {
        //判断分页参数是否有效
        if(page<=0){
            page = 1;
        }
        //page = page-1;//前端框架vue的下标从0开始
        if(size<=0){
            size = 10;
        }
        return this.departmentService.findList(page,size,pageRequest);
    }

    @PostMapping("/tierList/{page}/{size}")
    @Override
    public QueryResponseResult findDeptTierList(@PathVariable("page") int page,
                                                @PathVariable("size") int size,
                                                DepartmentTier pageRequest) {
        //判断分页参数是否有效
        if(page<=0){
            page = 1;
        }
        //page = page-1;//前端框架vue的下标从0开始
        if(size<=0){
            size = 10;
        }

        return this.departmentService.findListTier(page,size,pageRequest);
    }

    @PostMapping("/tierRelevList/{page}/{size}")
    @Override
    public QueryResponseResult findDeptTierRelevList(@PathVariable("page") int page,
                                                     @PathVariable("size") int size,
                                                     DepartmentTierRelev pageRequest) {
        //判断分页参数是否有效
        if(page<=0){
            page = 1;
        }
        //page = page-1;//前端框架vue的下标从0开始
        if(size<=0){
            size = 10;
        }

        return this.departmentService.findDeptTierRelevList(page,size,pageRequest);
    }

    @PostMapping("/add/deptTier")
    @Override
    public QueryResponseResult deptTierInsert(DepartmentTier departmentTier) {
        if(departmentTier == null){
            //参数非法
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return this.departmentService.deptTierInsert(departmentTier);
    }

    @PostMapping("/update/deptTier")
    @Override
    public QueryResponseResult deptTierUpdate(DepartmentTier departmentTier) {
        if(departmentTier == null){
            //参数非法
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return this.departmentService.deptTierUpdate(departmentTier);
    }

    @DeleteMapping("/delete/deptTier")
    @Override
    public QueryResponseResult deptTierDelete(Integer id) {
        return this.departmentService.deptTierDelete(id);
    }

    @PostMapping("/add/deptTierRelev")
    @Override
    public QueryResponseResult deptTierRelevInsert(@RequestBody  List<DepartmentTierRelev> departmentTierRelev) {
        if(CollectionUtils.isEmpty(departmentTierRelev)){
            //参数非法
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return this.departmentService.deptTierRelevInsert(departmentTierRelev);
    }


    @DeleteMapping("/delete/deptTierRelev")
    @Override
    public QueryResponseResult deptTierRelevDelete(@RequestBody List<DepartmentTierRelev> departmentTierRelev) {
        if(CollectionUtils.isEmpty(departmentTierRelev)){
            //参数非法
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return this.departmentService.deptTierRelevDelete(departmentTierRelev);
    }
}
