package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    /* 메뉴 전체 조회 start */
    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }
    /* 메뉴 전체 조회 end */

    /* 메뉴 코드로 조회 start */
    public MenuDTO selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = menuMapper.selectMenuByMenuCode(menuCode);

        sqlSession.close();

        return menu;
    }
    /* 메뉴 코드로 출력 end */

    /* 메뉴 추가 start */
    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.registMenu(menu);
        if (result > 0 ) {
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return result > 0;
    }
    /* 메뉴 추가 end */

    /* 메뉴 수정 start */
    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.modigytMenu(menu);
        if (result > 0 ) {
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return result > 0;
    }
    /* 메뉴 수정 end */

    /* 메뉴 삭제 start */
    public boolean deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        int result = menuMapper.deleteMenu(menuCode);
        if (result > 0 ) {
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return result > 0;
    }
    /* 메뉴 삭제 end */
}








