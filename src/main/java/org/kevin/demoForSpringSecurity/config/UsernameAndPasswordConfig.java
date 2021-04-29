package org.kevin.demoForSpringSecurity.config;

import org.kevin.demoForSpringSecurity.dao.BlogUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Kevin.Zng
 * @date 2021/4/18 12:53
 */
//@Configuration
public class UsernameAndPasswordConfig {
    @Autowired
    private BlogUserDao blogUserDao;

//    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("kevin")
                .password("123456")
                .authorities("read")
                .build();

        userDetailsService.createUser(userDetails);
        return userDetailsService;
    }

//    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
