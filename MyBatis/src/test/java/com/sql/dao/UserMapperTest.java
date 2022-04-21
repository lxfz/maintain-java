package com.sql.dao;

import com.sql.mapper.UserMapper;
import com.sql.pojo.User;
import com.sql.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
  @Test
  public void selectUser() {
    SqlSession session = MybatisUtils.getSession();
    //方法一:
    // List<User> users = session.selectList("com.sql.mapper.UserMapper.selectUser");

    //方法二:
    UserMapper mapper = session.getMapper(UserMapper.class);
    List<User> users = mapper.selectUser();
    for (User user : users) {
      System.out.println(user);
    }
    session.close();
  }

  @Test
  public void tsetSelectUserById() {
    SqlSession session = MybatisUtils.getSession(); //获取SqlSession连接 UserMapper mapper = session.getMapper(UserMapper.class);
    UserMapper mapper = session.getMapper(UserMapper.class);
    User user = mapper.selectUserById(1);
    System.out.println(user);
    session.close();
  }

  @Test
  public void testAddUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    User user = new User(5, "王五", "zxcvbn");
    int i = mapper.addUser(user);
    System.out.println(i);
    session.commit(); //提交事务,重点!不写的话不会提交到数据库 session.close();
  }

  @Test
  public void testUpdateUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    User user = mapper.selectUserById(1);
    user.setPwd("asdfgh");
    int i = mapper.updateUser(user);
    System.out.println(i);
    session.commit(); //提交事务,重点!不写的话不会提交到数据库 session.close();
  }

  @Test
  public void testDeleteUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    int i = mapper.deleteUser(5);
    System.out.println(i);
    session.commit(); //提交事务,重点!不写的话不会提交到数据库 session.close();
  }


}
