package HumanResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class quản lý từng  chức năng

public class ManagerHuman {
    List<Staff> staffs = new ArrayList<>();
    List<Department> departments = new ArrayList<>();

    public ManagerHuman(){
    }
    //    chức năng thêm nv
    public void add(Staff staff){
        this.staffs.add(staff);
    }

    //chức năng tìm kiếm tên hoặc id
    public Staff searchNameOrId(String sc){
        return this.staffs.stream().filter(s->s.getName().equalsIgnoreCase(sc)
                || s.getId().equalsIgnoreCase(sc)).findFirst().orElse(null); }

    // thể hiện ds toàn bộ nhân viên
    public void show(){ this.staffs.forEach(s-> s.display()); }

//chức năng duyệt ds lương nv tăng dần
    public void sortSalaryUp(){
        Collections.sort(staffs, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.calculateSalary() >= o2.calculateSalary()?1:-1;
            }
        });
        this.staffs.forEach(s-> s.displaySalary());
        }
    //chức năng duyệt ds lương nv giảm dần

    public void sortSalaryDown(){
        Collections.sort(staffs, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.calculateSalary() >= o2.calculateSalary()?-1:1;
            }
        });
        this.staffs.forEach(s-> s.displaySalary());
    }
//    chức năng sắp xêp toàn bộ nv theo từng bộ phận
    public void sortDepartment(){
        Collections.sort(staffs, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getDepartment().compareTo(o2.getDepartment());
            }
        });
        this.staffs.forEach(s-> s.display());
    }
    //chức năng thêm bộ phận mới
    public void addDepartment(Department department){
        this.departments.add(department);
    }
//    chức năng duyệt toàn ds bộ phận
    public Department sortDepart(String department){
        return this.departments.stream().filter(d->d.getName().equalsIgnoreCase(department)).findFirst().orElse(null);
    }
//    chức năng duyệt toàn bộ ds bộ phận
    public void showDepartment(){
        this.departments.forEach(d-> System.out.println(d.toString()));
    }
    }


