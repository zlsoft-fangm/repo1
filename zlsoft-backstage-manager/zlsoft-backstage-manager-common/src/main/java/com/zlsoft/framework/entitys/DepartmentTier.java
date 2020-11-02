package com.zlsoft.framework.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门层级model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentTier {
    private int ID;
    private int 上级ID;
    private String 名称;
    private int 排序;

}
