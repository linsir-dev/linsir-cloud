package com.linsir.auth.modules.auth.vo;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MockRole.java
 * @Description TODO
 * @createTime 2022年07月14日 14:59:00
 */
@Data
public class MockTokenVO {

    private String token;

    private MockUserInfoVO userInfo;

    private String message;

}
