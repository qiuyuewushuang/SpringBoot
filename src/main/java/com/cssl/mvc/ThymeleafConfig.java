package com.cssl.mvc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolution;

//@Configuration
public class ThymeleafConfig extends WebMvcConfigurationSupport {

    private ApplicationContext application;

   /* @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        super.addResourceHandlers(registry);
    }*/

    //@Bean
    //@ConfigurationProperties(prefix = "spring.thymeleaf")
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver srtr=new SpringResourceTemplateResolver();
        srtr.setApplicationContext(application);
        srtr.setCharacterEncoding("UTF-8");
        return srtr;
    }

    //@Bean
    public SpringTemplateEngine engine(){
        SpringTemplateEngine engine=new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
       // engine.setTemplateResolver(templateResolver());
        return engine;
    }

    //@Bean
    public ThymeleafViewResolver resolver(SpringTemplateEngine engine){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(engine);
        return resolver;
    }
}
