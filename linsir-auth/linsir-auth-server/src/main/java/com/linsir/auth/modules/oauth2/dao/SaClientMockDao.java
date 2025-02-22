package com.linsir.auth.modules.oauth2.dao;


import cn.dev33.satoken.oauth2.consts.GrantType;
import cn.dev33.satoken.oauth2.data.model.loader.SaClientModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * description：SaClientMockDao
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/22 5:07
 */
@Component
public class SaClientMockDao {

    public List<SaClientModel> list = new ArrayList<>();

    public SaClientMockDao(){
        // 模拟应用1
        SaClientModel client1 = new SaClientModel()
                .setClientId("1001")    // client id
                .setClientSecret("aaaa-bbbb-cccc-dddd-eeee")    // client 秘钥
                .addAllowRedirectUris("*")    // 所有允许授权的 url
                .addContractScopes("openid", "unionid", "userid", "userinfo", "oidc")    // 所有签约的权限
                .addAllowGrantTypes(     // 所有允许的授权模式
                        GrantType.authorization_code, // 授权码式
                        GrantType.implicit,  // 隐藏式
                        GrantType.refresh_token,  // 刷新令牌
                        GrantType.password,  // 密码式
                        GrantType.client_credentials,  // 客户端模式
                        "phone_code"  // 自定义授权模式 手机号验证码登录
                );
        list.add(client1);

        // 模拟应用2
        SaClientModel client2 = new SaClientModel()
                .setClientId("1002")
                .setClientSecret("aaaa-bbbb-cccc-dddd-eeee")
                .addAllowRedirectUris("*")
                .addContractScopes("openid", "unionid", "userid", "userinfo", "oidc")
                .addAllowGrantTypes(
                        GrantType.authorization_code,
                        GrantType.implicit,
                        GrantType.refresh_token,
                        GrantType.password,
                        GrantType.client_credentials
                );
        list.add(client2);

        // 模拟应用3
        SaClientModel client3 = new SaClientModel()
                .setClientId("1003")
                .setClientSecret("aaaa-bbbb-cccc-dddd-eeee")
                .addAllowRedirectUris("*")
                .addContractScopes("openid", "unionid", "userid", "userinfo", "oidc")
                .addAllowGrantTypes(
                        GrantType.authorization_code,
                        GrantType.implicit,
                        GrantType.refresh_token,
                        GrantType.password,
                        GrantType.client_credentials
                );
        list.add(client3);
    }

    /**
     * 根据应用 id 查找对应的应用，找不到则返回 null
     * @param clientId 应用 id
     * @return 应用对象
     */
    public SaClientModel getClientModel(String clientId) {
        return list.stream()
                .filter(e -> e.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
    }
}
