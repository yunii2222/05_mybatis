package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService(){
        menuDAO = new MenuDAO();
    }


    /*  */
    public List<MenuDTO> selectAllMenu() {
        /* Connection 대신 사용하는 구문 (SqlSession내에 Connection이 내장되어 있음.) */
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }
}
