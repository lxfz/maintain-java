package com.sm.mapper;


import com.sm.pojo.User;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
  List<User> selectUser();

  //根据id查询用户
  User selectUserById(int id);

  //添加一个用户
  int addUser(User user);

  //修改一个用户
  int updateUser(User user);

  //根据id删除用户
  int deleteUser(int id);

}
