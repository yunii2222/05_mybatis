package com.ohgiraffers.section01.xmlconfig;

import java.awt.*;
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
                default :
                    System.out.println("잘못 된 메뉴 번호를 선택하셨습니다."); break;
            }

        }while (true);
    }
}
