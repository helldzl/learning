package com.learning.stage01.lesson01.test;

import com.learning.stage01.lesson01.domain.User;
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
    public void test01() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session1 = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper m1 = session1.getMapper(UserMapper.class);
        UserMapper m2 = session2.getMapper(UserMapper.class);

        //第⼀次查询，发出sql语句，并将查询的结果放⼊缓存中
        User u1 = m1.findOne(1L);
        System.out.println(u1);
        session1.commit(); //第⼀次查询完后关闭 sqlSession

        //第⼆次查询，即使sqlSession1已经关闭了，这次查询依然不发出sql语句
        User u2 = m2.findOne(1L);
        System.out.println(u2);
        session2.close();
    }

    @Test
    public void test02() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session1 = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        SqlSession session3 = sqlSessionFactory.openSession();

        UserMapper m1 = session1.getMapper(UserMapper.class);
        UserMapper m2 = session2.getMapper(UserMapper.class);
        UserMapper m3 = session2.getMapper(UserMapper.class);

        // first select
        User user1 = m1.findOne(1L);
        session1.close();

        // update
        User user = new User();
        user.setId(2L);
        user.setUsername("曲子乐3333331111");
        int update = m3.update(user);
        System.out.println("update:" + update);
        // session3.close();

        // second select
        User user2 = m2.findOne(1L);
        session2.close();
        System.out.println(user1 == user2);
        //
        TimeUnit.SECONDS.sleep(1);
    }
}
