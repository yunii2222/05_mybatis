package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

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

    /* Map 형태로 넘어온값을 꺼내서 가공하고, 검증한다 */
    public void selectByMenuCode(Map<String, String> parameter) {
        /* 프로그램내에서 int형태로 다룰수 있게 파싱처리해줌. */
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        /* 받아야 하는 반환값은 MenuDTO
        * menuCode하나를 전달받아 MenuDTO로 반환을 받겠다. DB에서 받겠다. */
        MenuDTO menu = menuService.selectMenuByMenuCode(menuCode);

        /* 사용자에게 보여주고싶을때
        * 잘 조회되었을때 printMenu를 보여주고, */
        if (menu != null){
            printResult.printMenu(menu);
            /* 잘 조회되지 않았을때는 아래 에러 코드를 보여준다.
            * "selectOne"은 printResult에 printErrorMessage에있는 코드 변수명 */
        }else {
           printResult.printErrorMessage("selectOne");
        }
    }
    public void registMenu(Map<String, String> parameter) {
        MenuDTO menu = new MenuDTO();
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if (menuService.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(Integer.parseInt(parameter.get("menuCode")));
        menu.setMenuName(parameter.get("menuName"));
        menu.setMenuPrice(Integer.parseInt(parameter.get("menuPrice")));
        menu.setCategoryCode(Integer.parseInt(parameter.get("categoryCode")));

        if (menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("update");
        }else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {

        /* 메뉴코드변수에 메뉴코드를 담았다.  */
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        if (menuService.deleteMenu(menuCode)){
            printResult.printSuccessMessage("delete");
        }else {
            printResult.printErrorMessage("delete");
        }
    }
}
