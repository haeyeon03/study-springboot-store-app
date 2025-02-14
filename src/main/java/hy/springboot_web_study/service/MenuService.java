package hy.springboot_web_study.service;

import hy.springboot_web_study.model.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    List<Menu> menuList = new ArrayList<>();
    /**
     * 새 메뉴를 추가합니다.
     *
     * @param menuName 메뉴 이름
     * @param price 가격
     */
    public void addMenu(String menuName, int price) {
        Menu menu = new Menu();
        // 기존 메뉴 리스트에 중복된 메뉴 이름이 있는지 확인
        if (!isDuplicatedMenuName(menuName)) {
            menu.setMenuName(menuName);
            menu.setPrice(price);
            menuList.add(menu);
        }
    }

    /**
     * 전체 메뉴를 조회힙니다.
     * 
     * @return List 전체 메뉴 리스트
     */
    public List<Menu> getMenuList() {
        return menuList;
    }

    /**
     * 중복된 메뉴 이름을 확인합니다.
     *
     * @param menuName 메뉴 이름
     * @return boolean 중복된 메뉴 이름 있다면 true, 없다면 false 를 반환합니다.
     */
    public boolean isDuplicatedMenuName(String menuName) {
        for (int i = 0; i < menuList.size(); i++) {
            if (menuName.equals(menuList.get(i).getMenuName())) {
                return true;
            }
        }
        return false;
    }
}
