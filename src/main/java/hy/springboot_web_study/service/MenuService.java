package hy.springboot_web_study.service;

import hy.springboot_web_study.model.Menu;
import hy.springboot_web_study.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /**
     * 전체 메뉴를 조회합니다.
     *
     * @return List 전체 메뉴 리스트를 보여줍니다.
     */
    public List<Menu> getMenuList() {
        return menuRepository.findAll();
    }

    /**
     * 새 메뉴를 추가합니다.
     *
     * @param menuName 메뉴 이름
     * @param price    가격
     * @return int 추가 성공 시 1, 실패 시 0 을 반환합니다.
     */
    public int addMenu(String menuName, int price) {
        return menuRepository.save(new Menu(menuName, price));
    }

    /**
     * 키워드를 포함한 메뉴 정보를 조회합니다.
     *
     * @param keyword 메뉴 이름
     * @return List 키워드를 포함한 메뉴 리스트를 보여줍니다.
     */
    public List<Menu> getMenuListByKeyword(String keyword) {
        return menuRepository.findAll(new Menu(keyword));
    }

    /**
     * 메뉴 이름을 받아 기존 가격을 수정 합니다.
     *
     * @param menuName 수정할 메뉴 이름
     * @param price    새 가격
     * @return int 메뉴 가격 수정 성공 시 1, 실패 시 0 을 반환합니다.
     */
    public int modifyPrice(String menuName, int price) {
        return menuRepository.update(new Menu(menuName, price));
    }

    /**
     * 기존 메뉴를 리스트에서 찾아 삭제 합니다.
     *
     * @param menuName 삭제할 메뉴 이름
     * @return int 삭제 성공 시 1, 실패 시 0 을 반환합니다.
     */
    public int removeMenu(String menuName) {
        return menuRepository.delete(new Menu(menuName));
    }

    /**
     * 중복된 메뉴 이름을 확인합니다.
     *
     * @param menuName 메뉴 이름
     * @return boolean 중복된 메뉴 이름 있다면 true, 없다면 false 를 반환합니다.
     */
    public boolean isDuplicatedMenuName(String menuName) {
        Menu menu = menuRepository.findOne(new Menu(menuName));
        if (menu != null) {
            return true;
        }
        return false;
    }
}
