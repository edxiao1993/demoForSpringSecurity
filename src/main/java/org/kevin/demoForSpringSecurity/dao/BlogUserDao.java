package org.kevin.demoForSpringSecurity.dao;

import org.kevin.demoForSpringSecurity.model.BlogUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Kevin.Zng
 * @date 2021/4/18 12:32
 */
public interface BlogUserDao extends CrudRepository<BlogUser, String> {
    List<BlogUser> findByUsername(String name);
    Optional<BlogUser> findById(String id);
}
