package hy.springboot_web_study.service;

import hy.springboot_web_study.model.Menu;
import hy.springboot_web_study.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    List<Menu> menuList = new ArrayList<>();

    /**
     * 전체 메뉴를 조회힙니다.
     *
     * @return List 전체 메뉴 리스트
     */
    public List<Menu> getMenuList() {
        return menuRepository.findAll();
    }

    /**
     * 새 메뉴를 추가합니다.
     *
     * @param menuName 메뉴 이름
     * @param price    가격
     * @return int 리스트 추가 성공 시 1, 실패 시 0 을 반환합니다.
     */
    public int addMenu(String menuName, int price) {
        // 기존 메뉴 리스트에 중복된 메뉴 이름이 있는지 확인
        return menuRepository.save(new Menu(menuName, price));
    }

    /**
     * 메뉴 이름을 받아 기존 가격을 수정 합니다.
     *
     * @param menuName 수정할 메뉴 이름
     * @param price    새 가격
     * @return int 메뉴 가격 수정 성공 시 1, 실패 시 0 을 반환합니다.
     */
    public int modifyPrice(String menuName, int price) {
        if (isDuplicatedMenuName(menuName)) {
            menuRepository.update(new Menu(menuName,price));
            return 1;
        }
        return 0;
    }

    /**
     * 기존 메뉴를 리스트에서 찾아 삭제 합니다.
     *
     * @param menuName 삭제할 메뉴 이름
     * @return int 리스트 삭제 성공 시 1, 실패 시 0 을 반환합니다.
     */
    public int removeMenu(String menuName) {
        return menuRepository.delete(menuName);
    }

    /**
     * 중복된 메뉴 이름을 확인합니다.
     *
     * @param menuName 메뉴 이름
     * @return boolean 중복된 메뉴 이름 있다면 true, 없다면 false 를 반환합니다.
     */
    public boolean isDuplicatedMenuName(String menuName) {
        Menu menu = menuRepository.findOne(menuName);
        if (menu != null) {
            return true;
        }
        return false;

    }
}
