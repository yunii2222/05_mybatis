package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {
        System.out.println("========= 메뉴 목록 ==========");
        for ( MenuDTO menu : menuList ){
            System.out.println(menu);
        }
    }
    /* 조회가 잘 됐다면 보여준다. */
    public void printMenu(MenuDTO menu) {
        System.out.println("========== 조회된 메뉴 ==========");
        System.out.println(menu);

    }
    public void printSuccessMessage(String successCode) {
        System.out.println("========== Success ==========");
        String successMessage = "";
        switch (successCode) {
            case "insert" :
                successMessage = " 신규 메뉴 등록이 완료 되었습니다.";
                break;
            case "update" :
                successMessage = "메뉴 수정에 성공했습니다.";
                break;
            case "delete" :
                successMessage = "메뉴 삭제에 성공했습니다.";
                break;
        }
        /* 메세지 출력 */
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("========== Error ==========");
        String errorMassage = "";
        switch (errorCode) {
            case "selectList" :
                errorMassage = "메뉴 목록 조회에 실패했습니다 ";
                break;
                /* 다른 에러 메세지 보여주기 */
            case "selectOne" :
                errorMassage = "해당하는 코드에 맞는 메뉴 조회에 실패했습니다.";
                break;
            case "insert" :
                errorMassage = "신규 메뉴 등록에 실패했습니다.";
                break;
            case "update" :
                errorMassage = " 메뉴 수정에 실패했습니다.";
                break;
            case  "delete" :
                errorMassage = "메뉴 삭제에 실패했습니다.";
                break;
        }
        /* 메세지 출력 */
        System.out.println(errorMassage);
    }
}
