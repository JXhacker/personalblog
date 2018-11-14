package com.wanzhiwen.blog.dao;

import com.wanzhiwen.blog.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */

@Repository
public interface UserDao {
    User login(User user);
}
