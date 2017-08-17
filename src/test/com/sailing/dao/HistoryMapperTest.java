package com.sailing.dao;

import com.sailing.entity.History;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class HistoryMapperTest {
    @Autowired
    HistoryMapper  historyMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void selectByBuyerId() throws Exception {
        List<History> histories = historyMapper.selectByBuyerId("36331");
        System.out.print("h1:"+histories);
    }

    @Test
    public void selectBySellerrId() throws Exception {
        List<History> histories = historyMapper.selectBySellerId("32832");
        System.out.println("h2:"+histories);
    }
    @Test
    public void selectHistoryAll()throws Exception{
        List<History> histories = historyMapper.selectHistoryAll();
        System.out.println("hhh3:"+histories.toString());
    }
}