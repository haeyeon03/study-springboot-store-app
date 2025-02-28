package hy.springboot_web_study.controller;

import hy.springboot_web_study.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hy.springboot_web_study.service.MenuService;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    /**
     * 전체 메뉴를 조회합니다.
     *
     * @return List 전체 메뉴 리스트를 보여줍니다.
     */

    @GetMapping("/api/menus")

    public ResponseEntity<?> getMenuList() {
        List<Menu> menuList = menuService.getMenuList();
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }

    /**
     * 새 메뉴를 추가합니다.
     *
     * @param request Menu
     * @return int 추가 성공 시 1, 실패 시 0 을 반환합니다.
     */
    @PostMapping("/api/menus")
    public ResponseEntity<?> addMenu(@RequestBody Menu request) {
        int result = menuService.addMenu(request.getMenuName(), request.getPrice());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 키워드를 포함한 메뉴 정보를 조회합니다.
     *
     * @param keyword String
     * @return List 키워드를 포함한 메뉴 리스트를 보여줍니다.
     */
    @GetMapping("/api/menus/keyword")
    public ResponseEntity<?> getMenuListByKeyword(@RequestParam String keyword) {
        List<Menu> menuList = menuService.getMenuListByKeyword(keyword);
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }

    /**
     * 메뉴 이름을 받아 기존 가격을 수정 합니다.
     *
     * @param request Menu
     * @return int 수정 성공 시 1, 실패 시 0 을 반환합니다.
     */
    @PutMapping("/api/menus")
    public ResponseEntity<?> modifyPrice(@RequestBody Menu request) {
        int result = menuService.modifyPrice(request.getMenuName(), request.getPrice());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 메뉴를 삭제 합니다.
     *
     * @param request Menu
     * @return int 삭제 성공 시 1, 실패 시 0 을 반환합니다.
     */
    @DeleteMapping("/api/menus")
    public ResponseEntity<?> removeMenu(@RequestBody Menu request) {
        int result = menuService.removeMenu(request.getMenuName());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
