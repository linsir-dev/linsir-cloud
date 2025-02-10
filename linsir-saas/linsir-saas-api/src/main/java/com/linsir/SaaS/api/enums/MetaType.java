package com.linsir.SaaS.api.enums;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/09/01 13:16:11
 */
public enum MetaType {

    MENU("menu"),
    LINK("link"),
    BUTTON("button"),
    IFRAME("iframe");

    private String type;

    MetaType(String type)
    {
        this.type = type;
    }
}
