package org.lskar.librarysystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.lskar.librarysystem.utils.JwtUtils;


import java.io.IOException;

@Slf4j
//@Component
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1. 获取到请求路径
        String requestURI = request.getRequestURI(); // /employee/login

        //2. 判断是否是登录请求, 如果路径中包含 /login, 说明是登录操作, 放行
        if (requestURI.contains("/login")){
            log.info("登录请求, 放行");
            filterChain.doFilter(request, response);
        }

        //3. 获取请求头中的token
        String token = request.getHeader("token");

        //4. 判断token是否存在, 如果不存在, 说明用户没有登录, 返回错误信息(响应401状态码)
        if (token == null || token.isEmpty()){
            log.info("令牌为空, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //5. 如果token存在, 校验令牌, 如果校验失败 -> 返回错误信息(响应401状态码)
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法, 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //6. 校验通过, 放行
        log.info("令牌合法, 放行");
        filterChain.doFilter(request, response);
    }
}