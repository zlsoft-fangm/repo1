package com.zlsoft.framework.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 部门model
 */
@Data //生成getter.setter等函数
@NoArgsConstructor //生成无参构造函数
@AllArgsConstructor //生成全参构造函数
public class Department {

    private Integer ID;
    private Integer 上级ID;
    private String 编码;
    private String 名称;
    private String 简码;
    private String 位置;
    private Integer 末级;
    private Date 建档时间;
    private Date 撤档时间;
    private String 环境类别;
    private Integer 部门负责人;
    private String 站点;
    private Integer 顺序;
    private Date 最后修改时间;
    private String 别名;
    private String 位置编码;
}





















































































