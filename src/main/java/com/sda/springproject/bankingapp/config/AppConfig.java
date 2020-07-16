package com.sda.springproject.bankingapp.config;

import com.sda.springproject.bankingapp.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.sda.springproject.bankingapp")
public class AppConfig {

    @Bean
    public LoginService getLoginService(){
        return new LoginService();
    }
}
