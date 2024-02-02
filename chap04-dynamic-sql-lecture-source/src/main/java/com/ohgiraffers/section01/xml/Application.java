package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("========== 마이바티스 동적 쿼리 ========");
            System.out.println("1. if 확인하기 ");
            System.out.println("2. choose(when, otherwise) 확인하기 ");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기 ");
            System.out.println(" 메뉴 선택 ");
            System.out.print("=> ");
            int no  = sc.nextInt();

            switch (no) {
                case 1 : ifSubMenu(); break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");return;
            }
        }while (true);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuSerivce menuSerivce = new MenuSerivce();
        do {
            System.out.println("==========if 서브 메뉴 ==========");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 ");
            System.out.println(" 메뉴 번호 입력 ");
            System.out.print("=> ");
            int no  = sc.nextInt();

            switch (no) {
                case 1 :  menuSerivce.selectMenuByPrice(inputPrice()); break;
                case 2 : menuSerivce.searchMenu(inputSearchCriteria());break;
                case 9 : return;
            }
        }while (true);
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력해주세요(name 또는 category)");
        System.out.print("=> ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력해주세요 ");
        System.out.print("=> ");
        /* 검색키워드 */
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 가격의 최대금액을 입력해주세요");
        System.out.println("=> ");
        int price = sc.nextInt();

        return price;
    }
}
