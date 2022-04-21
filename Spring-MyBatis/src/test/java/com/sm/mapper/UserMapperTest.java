package com.sm.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import com.sm.pojo.User;

public class UserMapperTest {
  @Test
  public void test(){
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserMapper mapper = (UserMapper) context.getBean("userMapper", UserMapper.class);
    List<User> user = mapper.selectUser();
    System.out.println(user);
  }
}
