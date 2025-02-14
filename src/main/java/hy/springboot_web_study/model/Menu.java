package hy.springboot_web_study.model;

public class Menu {
    private String menuName;
    private int price;

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
