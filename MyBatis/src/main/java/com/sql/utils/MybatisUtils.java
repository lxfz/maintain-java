package com.sql.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
  private static SqlSessionFactory sqlSessionFactory;

  static {
    try {
      String resource = "mybatis-config.xml" ;
      InputStream inputStream = Resources.getResourceAsStream(resource);

      // 这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。
      // 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（也就是局部方法变量）
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 获取SqlSession连接
  // 每个线程都应该有它自己的 SqlSession 实例。
  // 每次收到 HTTP 请求，就可以打开一个 SqlSession，返回一个响应后，就关闭它。
  public static SqlSession getSession() {
    return sqlSessionFactory.openSession();
  }
}