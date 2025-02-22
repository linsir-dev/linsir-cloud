package com.linsir.gateway.filter;


import com.linsir.core.mybatis.util.JSON;
import com.linsir.core.mybatis.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * description：AuthorizationFilter
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/22 0:28
 */
@Component
@Order(1)
@Slf4j
public class AuthorizationFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest request = exchange.getRequest();
        //1.获取请求路径
        String path = request.getURI().getPath();
        log.info("基于网关的path:{}请求", path);

        //2.处理白名单
        if (path.startsWith("//"))
        {
            log.info("path:{},为白名单",path);
            return chain.filter(exchange);
        }
        //3.校验token
        //获取对应的token
        String token = request.getHeaders().getFirst("Authorization");
        if (!StringUtils.isEmpty(token)) {
            return chain.filter(exchange);
        }else
        {
            byte[] bits =JSON.stringify(JsonResult.FAIL_NO_PERMISSION("没有token")).getBytes();
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
    }
}
