package com.learning.stage01.lesson01.mapper;


import com.learning.stage01.lesson01.domain.User;

/**
 * Created at 2021/1/26
 *
 * @author quzile3
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
public interface UserMapper {

    User findOne(Long id);

    int update(User user);

}
