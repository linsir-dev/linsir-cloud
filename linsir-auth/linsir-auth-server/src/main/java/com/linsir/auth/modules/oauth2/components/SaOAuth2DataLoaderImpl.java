package com.linsir.auth.modules.oauth2.components;


import cn.dev33.satoken.oauth2.data.loader.SaOAuth2DataLoader;
import cn.dev33.satoken.oauth2.data.model.loader.SaClientModel;
import com.linsir.auth.modules.oauth2.dao.SaClientMockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description：SaOAuth2DataLoaderImpl
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/22 5:02
 */
@Component
public class SaOAuth2DataLoaderImpl implements SaOAuth2DataLoader {




    @Autowired
    SaClientMockDao saClientMockDao;

    // 根据 clientId 获取 Client 信息
    @Override
    public SaClientModel getClientModel(String clientId) {
        // 此为模拟数据，真实环境需要从数据库查询
        return saClientMockDao.getClientModel(clientId);
    }

    // 根据 clientId 和 loginId 获取 openid
    @Override
    public String getOpenid(String clientId, Object loginId) {
        // 此处使用框架默认算法生成 openid，真实项目建议改为从数据库查询
        return SaOAuth2DataLoader.super.getOpenid(clientId, loginId);
    }
}
