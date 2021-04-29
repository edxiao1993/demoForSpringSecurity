package org.kevin.demoForSpringSecurity.config;

import org.kevin.demoForSpringSecurity.dao.BlogUserDao;
import org.kevin.demoForSpringSecurity.model.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kevin.Zng
 * @date 2021/4/18 13:44
 */
@Service
public class UserDetailsServiceMyImpl implements UserDetailsService {

    @Autowired
    private BlogUserDao blogUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.err.println("I am here");
        List<BlogUser> blogUserList = blogUserDao.findByUsername(username);
        if(blogUserList != null && blogUserList.size() == 1){
            BlogUser user = blogUserList.get(0);
            // 不加 authorities 的话，会不给登录，还不告诉你哪里错了的那种！
            return User.withUsername(user.getUsername()).password(user.getPassword()).authorities("read").build();
        }
        throw new UsernameNotFoundException("not find the username or there are more than one record in DB");
    }
}
