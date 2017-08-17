package com.sailing.mybatisUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;

/**
 * varchar转list
 *
 */
public class ListTypeHandler implements TypeHandler<List> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List list, JdbcType jdbcType) throws SQLException {
        if(list==null||list.size()==0){
            ps.setString(i,null);
        }
        else {
            StringBuilder sb=new StringBuilder();
            for (Object o : list) {
                sb.append(o.toString());
                sb.append(",");
            }
            ps.setString(i,sb.toString());
        }
    }

    @Override
    public List getResult(ResultSet rs, String s) throws SQLException {
        String listStr=rs.getString(s);
        if(StringUtils.isEmpty(listStr)) {
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        String[] listStrs = listStr.split(",");
        for(String str : listStrs) {
            if(StringUtils.isEmpty(str)) {
                continue;
            }
            list.add(Integer.valueOf(str));
        }
        return list;

    }

    @Override
    public List getResult(ResultSet rs, int i) throws SQLException {
        String listStr=rs.getString(i);
        if(StringUtils.isEmpty(listStr)) {
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        String[] listStrs = listStr.split(",");
        for(String str : listStrs) {
            if(StringUtils.isEmpty(str)) {
                continue;
            }
            list.add(Integer.valueOf(str));
        }
        return list;

    }

    @Override
    public List getResult(CallableStatement cs, int i) throws SQLException {
        String listStr=cs.getString(i);
        if(StringUtils.isEmpty(listStr)) {
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        String[] listStrs = listStr.split(",");
        for(String str : listStrs) {
            if(StringUtils.isEmpty(str)) {
                continue;
            }
            list.add(Integer.valueOf(str));
        }
        return list;
    }
}
