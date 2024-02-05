package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

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
                case 2 : chooseSubMenu(); break;
                case 3 : foreachSunMenu(); break;
                case 4 : trimSubMenu(); break;
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
                case 1 : menuSerivce.selectMenuByPrice(inputPrice()); break;
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

    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        /* 호출하고 싶은 대상 */
        MenuSerivce menuSerivce = new MenuSerivce();
        do {
            System.out.println("=========choose 서브 메뉴 =========");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기 (식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호 입력");
            System.out.print("=> ");
            int no = sc.nextInt();

            switch (no){
                /* searchMenuBySubCategory로 찾겠다. */
                case 1 : menuSerivce.searchMenuBySubCategory(inputSubCategory()); break;
                case 9 : break;
            }
        }while (true);
    }
    private static SearchCriteria inputSubCategory() {

        Scanner sc = new Scanner(System.in);
        System.out.println("상위 분류를 입력해주세요 (식사, 음료, 디저트)");
        System.out.print("=>");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void foreachSunMenu() {
        Scanner sc = new Scanner(System.in);
        /* 호출하고 싶은 대상 */
        MenuSerivce menuSerivce = new MenuSerivce();
        do {
            System.out.println("=========foreach 서브 메뉴 =========");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호 입력");
            System.out.print("=> ");
            int no = sc.nextInt();

            switch (no){
                /* searchMenuBySubCategory로 찾겠다. */
                case 1 : menuSerivce.searchMenuByRandomMenuCode(createRandomMenuCodeList()); break;
                case 9 : break;
            }
        }while (true);
    }

    private static Set<Integer> createRandomMenuCodeList() {
        Set<Integer> set = new TreeSet<>();
        while (set.size() < 5) {
            /* 메뉴 번호로 1~21 까지로 가정 */
            int temp = ((int) (Math.random() * 21) + 1);
            set.add(temp);
        }
        System.out.println(set);
        return set;
    }

    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        /* 호출하고 싶은 대상 */
        MenuSerivce menuSerivce = new MenuSerivce();
        do {
            System.out.println("=========trim 서브 메뉴 =========");
            System.out.println("1. 메뉴 혹은 카테고리 코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우로 검색하며,"
                    + "검색 조건이 없는 경우에는 전체 검색");
            System.out.println("2. 원하는 메뉴 정보만 수정");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호 입력");
            System.out.print("=> ");
            int no = sc.nextInt();

            switch (no){
                /* searchMenuBySubCategory로 찾겠다. */
                case 1 : menuSerivce.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 2 : menuSerivce.modifyMenu(inputChangeInfo()); break;
                case 9 : break;
            }
        }while (true);
    }

    private static Map<String, Object> inputSearchCriteriaMap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 조건을 입력하세요(category or name or both or null)");
        System.out.print("=>");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        if ("category".equals(condition)) {

            System.out.println("검색할 카테고리 코드 입력");
            System.out.print("=> ");
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue", categoryValue);
        } else if ("name".equals(condition)) {

            System.out.println("검색할 메뉴명 입력");
            System.out.print("=> ");
            String nameValue = sc.nextLine();
            criteria.put("nameValue", nameValue);
        } else if ("both".equals(condition)) {

            System.out.println("검색할 메뉴명 입력");
            System.out.print("=> ");
            int nameValue = sc.nextInt();
            criteria.put("nameValue", nameValue);

            System.out.println("검색할 카테고리 코드 입력");
            System.out.print("=> ");
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue", categoryValue);

        }
        return criteria;
    }

    private static Map<String, Object> inputChangeInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("변경할 메뉴 코드 입력 ");
        System.out.print("=>");
        int menuCode = sc.nextInt();

        System.out.println("변경할 메뉴 이름 입력");
        System.out.print("=>");
        /* 아래로 내려 작성하면 빈문자열로 전달되기때문에 Scanner위에 작성 */
        sc.nextLine();
        String menuName = sc.nextLine();

        System.out.println("변경할 카테고리 코드 입력");
        System.out.print("=>");
        int categoryCode = sc.nextInt();

        System.out.println("변경할 판매여부 입력");
        System.out.print("=>");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String , Object> criteria = new HashMap<>();
        criteria.put("menuCode",menuCode);
        criteria.put("menuName",menuName);
        criteria.put("categoryCode",categoryCode);
        criteria.put("orderableStatus",orderableStatus);

        return criteria;
    }
}
