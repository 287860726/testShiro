package com.zhaocm.test.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: zhaocm
 * @time: 2020/11/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String roleName;
}
