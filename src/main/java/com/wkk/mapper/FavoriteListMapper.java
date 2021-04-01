package com.wkk.mapper;

import com.wkk.pojo.DO.FavoriteListDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库中的 produceInfo 表
 */
@Mapper
public interface FavoriteListMapper {
    int insert(FavoriteListDO favoriteList);

    int update(FavoriteListDO favoriteList);

    int deleteBatch(List<Integer> ids);

    int deleteById(Integer id);

    int deleteByAccount(Integer userAccount);

    int deleteByAccountAndName(Integer userAccount, String produceName);

    List<FavoriteListDO> findByUserAccount(Integer account);

    FavoriteListDO findByNameAndAccount(String produceName, Integer account);

    List<FavoriteListDO> list();
}
