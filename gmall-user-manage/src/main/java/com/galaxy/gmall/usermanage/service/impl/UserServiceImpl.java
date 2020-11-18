package com.galaxy.gmall.usermanage.service.impl;

import com.galaxy.gmall.usermanage.bean.UserInfo;
import com.galaxy.gmall.usermanage.mapper.UserInfoMapper;
import com.galaxy.gmall.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author 张福起
 * @Date 2020/11/18 11:31
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> getUserInfoListAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
     userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
     Example example=new Example(userInfo.getClass());
     example.createCriteria().andEqualTo("loginName",name);
     userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void delUser(UserInfo userInfo) {
     userInfoMapper.deleteByPrimaryKey(userInfo.getId());
    }
}
