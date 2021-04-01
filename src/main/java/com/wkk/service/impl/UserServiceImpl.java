package com.wkk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.UserInfoDO;
import com.wkk.repository.UserInfoRepository;
import com.wkk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserInfoRepository userInfoRepository;

    @Override
    public int insert(UserInfoDO userInfo) {
        return userInfoRepository.insert(userInfo);
    }

    @Override
    public int update(UserInfoDO userInfo) {
        return userInfoRepository.update(userInfo);
    }

    @Override
    public int deleteById(Integer id) {
        return userInfoRepository.deleteById(id);
    }

    @Override
    public int deleteByAccount(Integer account) {
        return userInfoRepository.deleteByAccount(account);
    }

    @Override
    public int freezeByAccount(Integer account) {
        return userInfoRepository.freezeByAccount(account);
    }

    @Override
    public int unFreezeByAccount(Integer account) {
        return userInfoRepository.unFreezeByAccount(account);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return userInfoRepository.deleteBatch(ids);
    }

    @Override
    public UserInfo findByAccount(Integer account) {
        return userInfoRepository.findByAccount(account);
    }

    @Override
    public List<UserInfo> list() {
        return userInfoRepository.list();
    }

    @Override
    public List<UserInfo> findByParName(String parName) {
        return userInfoRepository.findByParName(parName);
    }

    @Override
    public PageInfo<UserInfo> pageUser(Integer index, Integer size) {
        PageHelper helper = new PageHelper();
        helper.startPage(index, size);
        List<UserInfo> list = userInfoRepository.list();
        PageInfo<UserInfo> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
