package com.common;

public class SearchCondition {
    private String searchOption;
    private String searchValue;

    public SearchCondition() {
    }

    public SearchCondition(String searchOption, String searchValue) {
        this.searchOption = searchOption;
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "searchOption='" + searchOption + '\'' +
                ", searchValue='" + searchValue + '\'' +
                '}';
    }

    public String getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(String searchOption) {
        this.searchOption = searchOption;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    // * 주석을 지우고 검색 조건을 담은 객체를 생성할 java class를 작성하세요.
    // * 모든 필드는 String 타입으로 작성하시고, 필수로 작성해야 하는 필드는 option(검색 조건), value(검색어)입니다.
    // * DTO 객체에 대하여 기본적으로 작성해야 하는 사항 5가지 항목을 반드시 작성하세요.

}
