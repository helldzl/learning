package com.learning.stage01.lesson01.test;

import com.learning.stage01.lesson01.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Task01Tests {

    @Test
    public void test() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session1 = sqlSessionFactory.openSession(true);
        SqlSession session2 = sqlSessionFactory.openSession(true);
        SqlSession session3 = sqlSessionFactory.openSession(false);
        UserMapper m1 = session1.getMapper(UserMapper.class);
        UserMapper m2 = session2.getMapper(UserMapper.class);
        UserMapper m3 = session2.getMapper(UserMapper.class);

        // first select
        System.out.println(m1.findOne(1L));
        session1.close();

        // update
//        User user = new User();
//        user.setId(2L);
//        user.setUsername("曲子乐3333331111");
//        int update = m3.update(user);
//        System.out.println("update:" + update);
//        session3.close();

        // second select
        System.out.println(m2.findOne(1L));
        session2.close();
        //
        TimeUnit.SECONDS.sleep(1);
    }
}
