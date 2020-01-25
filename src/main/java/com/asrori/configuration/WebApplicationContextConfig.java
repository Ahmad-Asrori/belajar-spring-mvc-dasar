package com.asrori.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.util.UrlPathHelper;

import java.util.ArrayList;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("com.asrori")
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:/home/asrori/oficiona/");
    }

    @Bean
    public InternalResourceViewResolver resourceViewResolver(){
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
        bean.setBasename("messages");
        return bean;
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver bean = new SessionLocaleResolver();
        bean.setDefaultLocale(Locale.US);
        return bean;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver bean = new CommonsMultipartResolver();
        bean.setDefaultEncoding("utf-8");
        return bean;
    }

    @Bean
    public MappingJackson2JsonView jsonView(){
        MappingJackson2JsonView bean = new MappingJackson2JsonView();
        bean.setPrettyPrint(true);
        return bean;
    }

    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver bean = new ContentNegotiatingViewResolver();
        bean.setContentNegotiationManager(manager);

        ArrayList<View> views = new ArrayList<>();
        views.add(jsonView());
        bean.setDefaultViews(views);

        return bean;
    }
}
