package org.kevin.demoForSpringSecurity.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Kevin.Zng
 * @date 2021/4/18 12:28
 */
@Entity
@Table(name="blog_user")
@Data
public class BlogUser {
    @Id
    private String id;

    private String username;
    private String password;
    private LocalDateTime create_time;
//    private boolean status;
}
