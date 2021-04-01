package com.wkk.service;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.UserInfoDO;

import java.util.List;

public interface UserService {

    int insert(UserInfoDO userInfo);

    int update(UserInfoDO userInfo);

    int deleteById(Integer id);

    int deleteByAccount(Integer account);

    int freezeByAccount(Integer account);

    int unFreezeByAccount(Integer account);

    int deleteBatch(List<Integer> ids);

    UserInfo findByAccount(Integer account);

    List<UserInfo> list();

    List<UserInfo> findByParName(String parName);

    PageInfo<UserInfo> pageUser(Integer index, Integer size);
}
