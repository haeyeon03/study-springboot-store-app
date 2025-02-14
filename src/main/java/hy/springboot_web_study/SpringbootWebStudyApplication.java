package hy.springboot_web_study;

import hy.springboot_web_study.model.Menu;
import hy.springboot_web_study.service.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

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
            System.out.println("2. Show a filtered menu.");
            System.out.println("3. Add new menu.");
            System.out.println("4. Modify a menu.");
            System.out.println("5. Remove a menu.");
            System.out.println("9. Exit.");

            Scanner in1 = new Scanner(System.in); // 사용자 입력값 받기
            String selectedNumber = in1.next();

            // 사용자 입력값(번호)에 따른 분기 처리
            switch (selectedNumber) {
                case "1": // 1. 전체 메뉴 조회
                    List<Menu> menuList = menuService.getMenuList();
                    printMenu(menuList);
                    break;
                case "2":
                    break;
                case "3": // 3. 새 메뉴 추가
                    while (true) {
                        System.out.println("Type new menu name.");
                        Scanner in2 = new Scanner(System.in);
                        String menuName = in2.next();
                        System.out.println("Type price of the menu.");
                        Scanner in3 = new Scanner(System.in);
                        int price = in3.nextInt();
                        if (menuService.addMenu(menuName, price) == 1) {
                            System.out.println("=== New Menu's been added successfully. ===");
                            break;
                        } else {
                            System.out.println("=== Menu already exists. Please type another new menu. ===");
                        }
                    }
                    break;
                case "4": // 4. 기존 메뉴 이름 및 가격 변경
                    break;
                case "5": // 5. 기존 메뉴 삭제
                    while (true) {
                        printMenu(menuService.getMenuList());
                        System.out.println("Type a menu to remove.");
                        Scanner in4 = new Scanner(System.in);
                        String menuName = in4.next();
                        if (menuService.removeMenu(menuName) == 1) {
                            System.out.println("=== The Menu's been removed successfully. ===");
                            break; // while 문 break
                        } else {
                            System.out.println("=== The menu doesn't exist. Please type a valid menu. ===");
                        }
                    }
                    break;
                case "9": // 9. 시스템 종료
                    System.out.println("=== Thank you for using HY's Restaurant Management System ===");
                    System.exit(0);
            }
        }
    }

    /**
     * 메뉴 리스트를 콘솔에 표시합니다.
     *
     * @param menuList 메뉴 리스트
     */
    static void printMenu(List<Menu> menuList) {
        System.out.println("----------MENU----------");
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            String menuName = menu.getMenuName();
            int price = menu.getPrice();
            System.out.printf("%d. %s(%d)%n", i + 1, menuName, price);
        }
        System.out.println("------------------------");
    }
}
