package com.udacity.course1.dataPersistence.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class WebConfiguration {

    /*@Configuration
    public class WebConfiguration {
        @Bean
        ServletRegistrationBean h2servletRegistration(){
            ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
            registrationBean.addUrlMappings("/console/*");
            return registrationBean;
        }
    }*/
}
