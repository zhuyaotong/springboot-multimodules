package com.imooc.firstappdemo.config;

import com.imooc.firstappdemo.domain.User;
import com.imooc.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数 配置
 * @author Yaotong Zhu
 * @date 2020/07/04
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *  请求接口：ServletRequest 或者 HttpServletRequest
     *  响应接口：ServletResponse 或者 HttpServletResponse
     * Spring 5.0 重新定义了服务请求和响应接口
     *  请求接口：ServerRequest
     *  响应接口：ServerResponse
     *  即可支持 Servlet 规范，也可以支持自定义，比如 Netty (Web Server)
     *
     *  定义 Get 请求，并且返回所有的用户对象 URI: /person/find/all
     *  以下实现 异步非阻塞 方式
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    // 返回所有的用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }

}
