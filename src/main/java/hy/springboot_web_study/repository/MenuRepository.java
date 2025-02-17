package hy.springboot_web_study.repository;

import hy.springboot_web_study.model.Menu;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepository {
    private final JdbcTemplate jdbcTemplate;

    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 전체 메뉴를 조회합니다.
     *
     * @return List
     */
    public List<Menu> findAll() {
        String sql = "SELECT MENU_NAME, PRICE FROM MENU";
        RowMapper<Menu> rowMapper = (rs, rowNum) -> new Menu(
                rs.getString("MENU_NAME"),
                rs.getInt("PRICE")
        );
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * 메뉴 이름으로 단 건 조회합니다.
     *
     * @return List
     */
    public Menu findOne(String menuName) {
        String sql = "SELECT * FROM MENU WHERE MENU_NAME = ?";
        RowMapper<Menu> rowMapper = (rs, rowNum) -> new Menu(
                rs.getString("MENU_NAME"),
                rs.getInt("PRICE")
        );
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, menuName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * 새 메뉴를 추가합니다.
     *
     * @param menu 메뉴 이름, 가격
     */
    public int save(Menu menu) {
        try {
            return jdbcTemplate.update("INSERT INTO MENU (MENU_NAME, PRICE) VALUES(?, ?)", menu.getMenuName(), menu.getPrice());
        } catch (DataIntegrityViolationException e) {
            return 0;
        }
    }

    /**
     * 메뉴의 가격을 수정 합니다.
     *
     * @param menu 메뉴 이름, 가격
     */
    public void update(Menu menu) {
        String sql = "UPDATE MENU SET PRICE= ? WHERE MENU_NAME= ?;";
        jdbcTemplate.update(sql, menu.getMenuName(), menu.getPrice());
    }

    /**
     * 메뉴를 삭제 합니다.
     *
     * @param menuName 메뉴 이름
     */
    public int delete(String menuName) {
        return jdbcTemplate.update("DELETE FROM MENU WHERE MENU_NAME = ?", menuName);
    }

}