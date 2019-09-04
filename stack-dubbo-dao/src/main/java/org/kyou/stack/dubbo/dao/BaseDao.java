package org.kyou.stack.dubbo.dao;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class BaseDao {
    @Resource
    private SqlSession proxy;

    public <T> T selectOne(String statement) {
        return proxy.selectOne(statement);
    }

    public <T> T selectOne(String statement, Object parameter) {
        return proxy.selectOne(statement, parameter);
    }

    public <E> List<E> selectList(String statement) {
        return proxy.selectList(statement);
    }

    public <E> List<E> selectList(String statement, Object parameter) {
        return proxy.selectList(statement, parameter);
    }

    public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return proxy.selectList(statement, parameter, rowBounds);
    }

    public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return proxy.selectMap(statement, mapKey);
    }

    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
        return proxy.selectMap(statement, parameter, mapKey);
    }

    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
        return proxy.selectMap(statement, parameter, mapKey, rowBounds);
    }

    public <T> Cursor<T> selectCursor(String statement) {
        return proxy.selectCursor(statement);
    }

    public <T> Cursor<T> selectCursor(String statement, Object parameter) {
        return proxy.selectCursor(statement, parameter);
    }

    public <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds) {
        return proxy.selectCursor(statement, parameter, rowBounds);
    }

    public void select(String statement, Object parameter, ResultHandler handler) {
        proxy.select(statement, parameter, handler);
    }

    public void select(String statement, ResultHandler handler) {
        proxy.select(statement, handler);
    }

    public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        proxy.select(statement, parameter, rowBounds, handler);
    }

    public int insert(String statement) {
        return proxy.insert(statement);
    }

    public int insert(String statement, Object parameter) {
        return proxy.insert(statement, parameter);
    }

    public int update(String statement) {
        return proxy.update(statement);
    }

    public int update(String statement, Object parameter) {
        return proxy.update(statement, parameter);
    }

    public int delete(String statement) {
        return proxy.delete(statement);
    }

    public int delete(String statement, Object parameter) {
        return proxy.delete(statement, parameter);
    }
}
