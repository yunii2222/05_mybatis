package com.ohgiraffers.section01.xmlconfig;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TemplateTestView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* MenuController 파일 가지고 오기 */
        MenuController menuController = new MenuController();

        do {
            System.out.println("========="+"🥗"+"메뉴 관리"+"🥗"+"=========");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("메뉴 관리 번호 입력");
            System.out.print("=> ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    menuController.selectAllMenu(); break;
                case 2 :
                    /* 입력받을수있는 별도의 메소들를 정의 */
                    /* inputMenuCode() 아무것도 작성하지 않았기때문에 같은 클래스내에 생성 */
                    menuController.selectByMenuCode(inputMenuCode()); break;
                case 3 :
                    menuController.registMenu(inputMenu()); break;
                case 4 :
                    menuController.modifyMenu(inputModifyMenu()); break;
                case 5 :
                    menuController.deleteMenu(inputDeleteMenu()); break;
                default :
                    System.out.println("잘못 된 메뉴 번호를 선택하셨습니다."); break;
            }

        }while (true);
    }

    private static Map<String, String> inputDeleteMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" 삭제할 메뉴 코드를 입력하세요");
        System.out.print("=> ");
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        return parameter;
    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" 수정할 메뉴 코드를 입력하세요");
        System.out.print("=> ");
        String menuCode = sc.nextLine();
        System.out.println(" 수정할 메뉴 이름을 입력하세요");
        System.out.print("=> ");
        String menuName = sc.nextLine();
        System.out.println(" 수정할 메뉴 가격을 입력하세요");
        System.out.print("=> ");
        String menuPrice = sc.nextLine();
        System.out.println(" 수정할 메뉴 카테고리 코드를 입력하세요");
        System.out.print("=> ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" 메뉴 이름을 입력하세요");
        System.out.print("=> ");
        String menuName = sc.nextLine();
        System.out.println(" 메뉴 가격을 입력하세요");
        System.out.print("=> ");
        String menuPrice = sc.nextLine();
        System.out.println(" 메뉴의 카테고리 코드를 입력하세요");
        System.out.print("=> ");
        String categoryCode = sc.nextLine();

        /* Map이라는곳에 HashMap<>으로 parameter변수에 넣어 선언.(?)*/
        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        /* parameter로 반환해서 넘어갈수있도록 처리해줌. */
        return parameter;
    }

    /* 같은 클래스 내부에서 사용하는 용도로 작성했기 때문에 인텔리제이에서 유추해서 private으로 선언
    * 어떤 값으로 반환할지 유추할수 없었기 때문에 Object로 생성 되었다.
    * 반환 값을 Map으로 생성 */
    private static Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 메뉴 코드를 입력하세요 ");
        System.out.println("=> ");
        String menuCode = sc.nextLine();

        /* Map이라는곳에 HashMap<>으로 parameter변수에 넣어 선언.(?)*/
        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        /* parameter로 반환해서 넘어갈수있도록 처리해줌. */
        return parameter;
    }
}
