package com.zlsoft.framework.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门层级关联
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentTierRelev {
    private Integer 层级ID;
    private Integer 部门ID;

}
