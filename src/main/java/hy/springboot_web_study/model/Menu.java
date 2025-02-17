package hy.springboot_web_study.model;

public class Menu {
    private String menuName;
    private int price;

    // args 가 없는 생성자
    public Menu() {
    }

    // args 가 존재하는 생성자
    public Menu(String menuName) {
        this.menuName = menuName;
    }

    // args 가 존재하는 생성자
    public Menu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
