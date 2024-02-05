package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuSerivce {
    private DynamicSqlMapper dynamicSqlMapper;
    public void selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* 기본 자료형 타입으로는 if 조건문의 값을 비교할 수 없으므로 Map 타입으로 가공해서 전달한다.
         * (Map의 경우 key 값, DTO 객체의 경우 getter를 이용하여 값이 확인된다.) */
        Map<String , Integer> map = new HashMap<>();
        map.put("price", price);

        /* map에 price값을 담아 전달한다. */
        List<MenuDTO> menuList = dynamicSqlMapper.selectMenuByPrice(map);

        /* 검색한 리스트를 출력할것이다. */
        if (menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* map에 price값을 담아 전달한다. */
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenu(searchCriteria);

        /* 검색한 리스트를 출력할것이다. */
        if (menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuBySubCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* 메소드 변경 */
        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuBySubCategory(searchCriteria);

        /* 검색한 리스트를 출력할것이다. */
        if (menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(Set<Integer> randomMenuCodeList) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* map이라는 값 안에Set<Integer>를 담아서  */
        Map<String, Set<Integer>> criteria = new HashMap<>();
        criteria.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByRandomMenuCode(criteria);

        /* 검색한 리스트를 출력할것이다. */
        if (menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = dynamicSqlMapper.searchMenuByNameOrCategory(criteria);

        /* 검색한 리스트를 출력할것이다. */
        if (menuList != null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void modifyMenu(Map<String , Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result =  dynamicSqlMapper.updateMenu(criteria);

        if (result > 0) {
            sqlSession.commit();
            System.out.println("메뉴 정보 변경에 성공하였습니다.");
        }else {
            sqlSession.rollback();
            System.out.println("메뉴 정보 변경에 실패하셨습니다.");
        }
        sqlSession.close();
    }
}
