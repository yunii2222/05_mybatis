package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
            /* 메소드의 첫번째 인자로 어떠한 sql구문을 수행할 것인지 전달한다.
            * mapper의 namespace와 id를 통해서 구분한다. */
        return sqlSession.selectList( "MenuMapper.selectAllMenu" );
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        /* Mapper.XML파일로 가서 먼저 무엇을 할것인지 정한다.
        * select하나 더 작성.
        * 조회해서 얻어야 하는 값은 하나기 때문에 (?)
        * 메소드의 두번째 인자로 sql 구문을 수행할 때 필요한 값을 전달한다.
        * "MenuMapper.selectMenuByMenuCode"를 전달 받을 건데 menuCode값을 쓰세요~ */
         return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        /* 어떤 이름을로 어떤 가격으로 전달할지 모르기때문에 menu값을 넣어줌 */
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }
}
