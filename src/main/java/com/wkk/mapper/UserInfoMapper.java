package com.wkk.mapper;

import com.wkk.pojo.DO.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 userInfo 表
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 添加 UserInfo 实例
     */
    int insert(UserInfoDO userInfo);

    /**
     * 更新 UserInfo 实例
     */
    int update(UserInfoDO userInfo);

    /**
     * 通过 Id 删除用户
     */
    int deleteById(Integer id);

    int deleteByAccount(Integer account);

    /**
     * 冻结用户
     */
    int freezeByAccount(Integer account);

    /**
     * 冻结用户
     */
    int unFreezeByAccount(Integer account);

    /**
     * 批量删除 userInfo
     */
    int deleteBatch(List<Integer> ids);

    /**
     * 根据 account 进行查找
     */
    UserInfoDO findByAccount(Integer account);

    /**
     * 查询所有 userInfo
     */
    List<UserInfoDO> list();

    /**
     * 根据 userName 进行模糊查找
     */
    List<UserInfoDO> findByParName(String parName);
}
