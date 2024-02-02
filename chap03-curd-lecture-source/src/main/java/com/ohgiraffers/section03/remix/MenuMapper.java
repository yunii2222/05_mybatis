package com.ohgiraffers.section03.remix;

import java.util.List;

public interface MenuMapper {
/* DAO를 사용하지 않고, xml파일 쿼리로 작성하는게 편한데 어떻게 섞어서 사용할지 */
    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByMenuCode(int menuCode);

    /* 삭제 */
    int registMenu(MenuDTO menu);

    /* 수정 */
    int modigytMenu(MenuDTO menu);

    /* 삭제 */
    int deleteMenu(int menuCode);

}
