package com.bing.mini.batis;

import com.bing.mini.jdbc.core.JdbcTemplate;
import com.bing.mini.jdbc.core.PreparedStatementCallback;

public interface SqlSession {
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);

    Object selectOne(String sqlid, Object[] args, PreparedStatementCallback pstmtcallback);
}