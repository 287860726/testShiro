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
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer Id;
    private String username;
    private String password;

    private Role role;
}
