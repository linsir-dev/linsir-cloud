package com.linsir.gateway.filter;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * description：GlobalRequestLogFilter
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/10 16:18
 */
@Component
@Schema
@Slf4j
public class GlobalRequestLogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // 打印请求路径
        String path = request.getPath().pathWithinApplication().value();


        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            MultiValueMap<String, String> queryParams = request.getQueryParams();
            String requestUrl = UriComponentsBuilder.fromPath(path).queryParams(queryParams).build().toUriString();

            // 构建成一条长 日志，避免并发下日志错乱
            StringBuilder responseLog = new StringBuilder(300);
            // 日志参数
            List<Object> responseArgs = new ArrayList<>();
            responseLog.append("\n\n================ Gateway Response Start  ================\n");
            ServerHttpResponse response = exchange.getResponse();
            // 打印路由 200 get: /api/xxx/xxx
            responseLog.append("<=== {} {}: {}\n");
            // 参数
            String requestMethod = request.getMethod().name();
            responseArgs.add(response.getStatusCode().value());
            responseArgs.add(requestMethod);
            responseArgs.add(requestUrl);

            // 打印请求头
            HttpHeaders headers = response.getHeaders();
            headers.forEach((headerName, headerValue) -> {
                responseLog.append("===Headers===  {}: {}\n");
                responseArgs.add(headerName);
                responseArgs.add(StringUtils.join(headerValue));
            });

            responseLog.append("================  Gateway Response End  =================\n");
            // 打印执行时间
            log.info(responseLog.toString(), responseArgs.toArray());
        }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
