package org.kevin.demoForSpringSecurity.controller;

import org.kevin.demoForSpringSecurity.common.CommonUtils;
import org.kevin.demoForSpringSecurity.dao.BlogUserDao;
import org.kevin.demoForSpringSecurity.model.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kevin.Zng
 * @date 2021/4/18 12:22
 */
@RestController
public class IndexController {
    @Autowired
    private BlogUserDao blogUserDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/index")
    public String index(){
        return "hello world~";
    }

    @GetMapping("/createUser")
    public int createUser(@RequestParam("username") String username,
                             @RequestParam("password") String password){
        BlogUser blogUser = new BlogUser();
        blogUser.setId(CommonUtils.generateUUID());
        blogUser.setUsername(username);
        blogUser.setPassword(passwordEncoder.encode(password));

        blogUserDao.save(blogUser);

        return 1;
    }
}
