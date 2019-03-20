package com.mybatis;

import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Class: TestMybatis
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/20 20:01
 * Version: V1.0
 */
public class TestMybatis {
    //    日志记录
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
//        1构建者
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
//        1.1加载配置文件返回Reader
        Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
//      也可以  InputStream inputStream=BookDao.class.getClassLoader().getResourceAsStream("config.xml");

//        2构建者创建工厂
        SqlSessionFactory factory = factoryBuilder.build(reader);
//        3工厂创建实例返回sqlSession
        SqlSession sqlSession = factory.openSession();
//        4使用session执行想要执行的sql语句

// ===================================================================
//        User user = new User(1, "是", "5");
//        int insertUser = sqlSession.insert("insertUser", user);
//        logger.debug("插入" + insertUser);
        List<User> all = sqlSession.selectList("selectAll");
        logger.debug(all);


//        5事务处理需要提交才可以执行
        sqlSession.commit();
//        6关闭释放资源
        sqlSession.close();
    }
}
