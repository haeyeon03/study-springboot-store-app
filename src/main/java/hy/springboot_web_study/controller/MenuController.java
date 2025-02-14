package hy.springboot_web_study.controller;

import hy.springboot_web_study.model.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hy.springboot_web_study.service.MenuService;

import java.util.List;

@RestController
public class MenuController {
    @GetMapping("/api/menus")
    public ResponseEntity<?> getMenus(int a) {
        MenuService menuService = new MenuService();
        List<Menu> menuList = menuService.getMenuList();
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }

}
