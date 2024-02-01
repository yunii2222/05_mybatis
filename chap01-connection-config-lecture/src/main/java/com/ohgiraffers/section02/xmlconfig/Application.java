package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";
        try {
            InputStream  inputStream = Resources.getResourceAsStream(resource);

            /* inputStream를 읽어오는 sqlSessionFactory 이다.  */
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            /* 수동으로 커밋해주겠다는 코드 false로 작성 */
            SqlSession sqlSession = sqlSessionFactory.openSession(false);

            /* mapper.xml 파일의 namespace와 select 태그의 id를 통해 찾아온다.
            * namespace.id */
            java.util.Date date = sqlSession.selectOne("mapper.selectDate");
            System.out.println("date : " + date);
            
            /* 불필요하다면 닫아주는 동작 수행 */
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
