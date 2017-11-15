package org.vinci.tomcat.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by XizeTian on 2017/11/13.
 */
@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter {
    @Value("${vinci-tomcat.web-path:}")
    String webPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!StringUtils.isEmpty(webPath)) {
            registry.addResourceHandler("/**").addResourceLocations("file:" + webPath + "/");
        } else {
            throw new RuntimeException("vinci-tomcat.web-path 为空, 请配置前端路径.");
        }
        super.addResourceHandlers(registry);
    }
}
