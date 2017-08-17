package com.sailing.dao;

import com.sailing.entity.History;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistoryMapper {
    int deleteByPrimaryKey(String historyId);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(String historyId);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    List<History> selectByBuyerId(String bid);

    List<History> selectBySellerId(String sid);

    List<History> selectHistoryAll();
}