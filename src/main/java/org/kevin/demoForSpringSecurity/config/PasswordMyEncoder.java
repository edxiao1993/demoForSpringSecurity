package org.kevin.demoForSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin.Zng
 * @date 2021/4/18 15:33
 */
@Configuration
public class PasswordMyEncoder{
    @Bean
    public PasswordEncoder passwordEncoder(){
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();

        encoderMap.put("noop", NoOpPasswordEncoder.getInstance());
        encoderMap.put("bcrypt", new BCryptPasswordEncoder());
        encoderMap.put("scrypt", new SCryptPasswordEncoder());

        // if not appoint, the default encrypt is bcrypt.
        return new DelegatingPasswordEncoder("noop", encoderMap);
    }
}
