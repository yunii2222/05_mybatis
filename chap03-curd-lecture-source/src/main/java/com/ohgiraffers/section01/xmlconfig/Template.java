package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /* SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야 하며
    * 애플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory를 다시 빌드하지 않는 것이 좋은 형태이다.
    * 애플리케이션 스코츠로 관리하기 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다.
    * singeton : 오로지 1개의 객체만 생성  */

    /* static영역에 */
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        /* 최초 실행 시 sqlSessionFactory 객체가 없으면 생성하고 생성 된 뒤에는 if문에 진입하지 않는다. */
        if (sqlSessionFactory == null) {
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";
            try {
                /* 설정파일을 읽어오고, */
                InputStream inputStream = Resources.getResourceAsStream(resource);
                /* qlSessionFactoryBuilder()를 sqlSessionFactory를 : 생성하고 유지할 필요가 없다.
                * 따라서 메소드 스코프로 만든다. */
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sqlSessionFactory.openSession(false);
    }

}
