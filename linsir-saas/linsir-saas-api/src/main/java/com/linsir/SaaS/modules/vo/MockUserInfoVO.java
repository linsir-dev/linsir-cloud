package com.linsir.SaaS.modules.vo;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MockUserInfoVO.java
 * @Description TODO
 * @createTime 2022年07月14日 15:01:00
 */
@Data
public class MockUserInfoVO {

    private int userId;

    private String userName;

    private int dashboard;

    private String[] role;
}
