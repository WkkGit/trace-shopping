package com.wkk.repository;

import com.wkk.constants.AccountStatusEnum;
import com.wkk.mapper.UserInfoMapper;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.UserInfoDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoRepository {
    @Resource
    UserInfoMapper mapper;

    public int insert(UserInfoDO userInfo) {
        return mapper.insert(userInfo);
    }

    public int update(UserInfoDO userInfo) {
        return mapper.update(userInfo);
    }

    public int deleteById(Integer id) {
        return mapper.deleteById(id);
    }

    public int deleteByAccount(Integer account) {
        return mapper.deleteByAccount(account);
    }

    public int freezeByAccount(Integer account) {
        return mapper.freezeByAccount(account);
    }

    public int unFreezeByAccount(Integer account) {
        return mapper.unFreezeByAccount(account);
    }

    public int deleteBatch(List<Integer> ids) {
        return mapper.deleteBatch(ids);
    }

    public UserInfo findByAccount(Integer account) {
        return transformToBO(mapper.findByAccount(account));
    }

    public List<UserInfo> list() {
        List<UserInfo> res = new ArrayList<>();
        List<UserInfoDO> list = mapper.list();
        for(UserInfoDO userInfoDO : list){
            res.add(transformToBO(userInfoDO));
        }
        return res;
    }

    public List<UserInfo> findByParName(String parName) {
        List<UserInfo> res = new ArrayList<>();
        List<UserInfoDO> list = mapper.findByParName(parName);
        for(UserInfoDO userInfoDO : list){
            res.add(transformToBO(userInfoDO));
        }
        return res;
    }

    private UserInfo transformToBO(UserInfoDO userInfoDO){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoDO.getId());
        userInfo.setUserName(userInfoDO.getUserName());
        userInfo.setAccount(userInfoDO.getAccount());
        userInfo.setPassword(userInfoDO.getPassword());
        userInfo.setSalt(userInfoDO.getSalt());
        userInfo.setAddress(userInfoDO.getAddress());
        userInfo.setPhone(userInfoDO.getPhone());
        userInfo.setGender(userInfoDO.getGender());
        int code = userInfoDO.getStatus();
        userInfo.setStatus(AccountStatusEnum.getInstance(code));
        return userInfo;
    }
}
