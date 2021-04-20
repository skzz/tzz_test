package com.example.demo.dao;

import com.example.demo.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    Users findByUsernameAndPasswd(String username, String passwd );

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

}