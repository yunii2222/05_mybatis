package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class MenuController {
    /* 한 번 초기화 되면  */
    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void selectAllMenu(){
        
        /* 조회 된 목록 반환을 위해 selectAllMenu파일 생성 */
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null){
            printResult.printMenuList(menuList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }
}
