package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {
        System.out.println("========= 메뉴 목록 ==========");
        for ( MenuDTO menu : menuList ){
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("========== Error ==========");
        String errorMassage = "";
        switch (errorCode) {
            case "selectList" :
                errorMassage = "메뉴 목록 조회에 실패했습니다 ";
                break;
        }
        System.out.println(errorMassage);
    }
}
