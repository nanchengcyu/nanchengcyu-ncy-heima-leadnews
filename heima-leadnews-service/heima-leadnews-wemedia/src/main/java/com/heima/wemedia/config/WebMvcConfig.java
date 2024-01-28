package com.heima.wemedia.config;

import com.heima.wemedia.interceptor.WmTokenInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebMvcConfig
 * Package: com.heima.wemedia.config
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/28 17:35
 * @Version 1.0
 */
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WmTokenInterceptor()).addPathPatterns("/**");
    }
}
