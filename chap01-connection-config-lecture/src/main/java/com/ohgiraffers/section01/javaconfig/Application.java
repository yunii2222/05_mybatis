package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.Connection;
import java.util.Map;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {
        /* DB접속에 관ㄹ한 환경 설정
        * JdbcTransactionFactory : 수동 커밋, ManagedTransactionFactory : 자동 커밋
        * PooledDataSource : 커넥션풀 사용, UnPooledDataSource : 커넥션풀 미사용 */
        Environment environment = new Environment(
                "dev", // 환경 정보 이름
                new JdbcTransactionFactory(), // 트랜잭션 매니저 종류(JDBC or MANAGED)
                new PooledDataSource(DRIVER,URL,USER,PASSWORD)  // Connection Pool 사용 유무(Pool or UnPooled)
        );

        /* 생성한 환경 설정 정보로 MyBatis 설정객체 */
        Configuration configuration = new Configuration(environment);

        /* 설정 객체에 Mapper 등록 */
        configuration.addMapper(Mapper.class);

        /* SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        *  SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *  build() : 설정에 대한 정보를 담고 있는 configuration 타입의 객체 혹은 외부 설정 파일과 연결 된 stream을
        *  매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드 */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /* openSession() : SqlSession 타입의 인터페이스를 반환하는 메소드로 boolean 타입을 인자로 전달 */
        /* false : DML 수행 후 auto commit 옵션을 false로 지정 */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        
        /* getMapper() : Configuration에 등록 된 Mapper를 동일 타입에 대해 반환하는 메소드 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        
        /* Mapper 인터페이스에 작성 된 메소드 호출하여 쿼리 실행 */
        java.util.Date data = mapper.selectData();
        System.out.println("data⏰ : " + data);

        /* SqlSession 객체 반납 */
        sqlSession.close();

    }
}
