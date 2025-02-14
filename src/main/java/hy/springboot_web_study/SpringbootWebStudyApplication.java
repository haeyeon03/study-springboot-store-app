package hy.springboot_web_study;

import hy.springboot_web_study.model.Menu;
import hy.springboot_web_study.service.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringbootWebStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebStudyApplication.class, args);
        MenuService menuService = new MenuService();
        System.out.println("=== Welcome to HY's Restaurant Management System! ===");
        while (true) {
            System.out.println("Please type the number to get information.");
            System.out.println("1. Show all menu.");
            System.out.println("2. Add new menu.");
            System.out.println("9. Exit.");

            Scanner in1 = new Scanner(System.in); // 사용자 입력값 받기
            String selectedNumber = in1.next();

            // 사용자 입력값(번호)에 따른 분기 처리
            if ("1".equals(selectedNumber)) {
                // 1. 전체 메뉴 조회
                List<Menu> menuList = menuService.getMenuList();
                printMenu(menuList);
            } else if ("2".equals(selectedNumber)) {
                // 2. 새 메뉴 추가
                System.out.println("Type new menu name.");
                Scanner in2 = new Scanner(System.in);
                String menuName = in2.next();
                System.out.println("Type price of the menu.");
                Scanner in3 = new Scanner(System.in);
                int price = in3.nextInt();
                menuService.addMenu(menuName, price);
            } else if ("3".equals(selectedNumber)) {
                // 3. 기존 메뉴 이름 및 가격 변경
            } else if ("4".equals(selectedNumber)) {
                // 4. 기존 메뉴 삭제
            } else if ("9".equals(selectedNumber)) {
                // 9. 시스템 종료
                System.out.println("=== Thank you for using HY's Restaurant Management System ===");
                break;
            }
        }
    }

    /**
     * 메뉴 리스트를 콘솔에 표시합니다.
     *
     * @param menuList 메뉴 리스트
     */
    static void printMenu(List<Menu> menuList) {
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            String menuName = menu.getMenuName();
            int price = menu.getPrice();
            System.out.println("메뉴: " + menuName);
            System.out.println("가격: " + price);
            System.out.println("---------------------------");
        }
    }

}
