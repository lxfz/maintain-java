package com.sql.mapper;

import com.sql.pojo.User;

import java.util.List;

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
