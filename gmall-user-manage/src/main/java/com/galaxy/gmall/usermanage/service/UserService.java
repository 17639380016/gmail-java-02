package com.galaxy.gmall.usermanage.service;

import com.galaxy.gmall.usermanage.bean.UserInfo;

import java.util.List;

/**
 * @Author 张福起
 * @Date 2020/11/18 11:31
 */
public interface UserService {

    List<UserInfo> getUserInfoListAll();

    void addUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void updateUserByName(String name,UserInfo userInfo);

    void delUser(UserInfo userInfo);

}
