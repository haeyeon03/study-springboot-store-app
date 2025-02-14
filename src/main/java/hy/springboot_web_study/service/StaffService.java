package hy.springboot_web_study.service;

import hy.springboot_web_study.model.Menu;
import hy.springboot_web_study.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    public List<Staff> getStaff() {

        List<Staff> staffList = new ArrayList<>();

        Staff staff1 = new Staff();
        staff1.setName("가군");
        staff1.setAge(22);

        staffList.add(staff1);

        return staffList;
    }
}
