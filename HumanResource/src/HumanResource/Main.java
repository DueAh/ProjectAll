package HumanResource;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
//Chương trình 9
public class Main {
    static ManagerHuman managerHuman = new ManagerHuman();
    public static void main(String[] args) {
        new Scanner(System.in);
        Staff st1 = new Employee("1","Văn",11,1,1,"1/1/2001","It",1);
        Staff st2 = new Employee("2","Toàn",12,2,2,"1/1/2002","Marketing",2);
        Staff st3 = new Employee("3","Đạt",13,3,3,"1/1/2003","It",3);
        Staff st4 = new Employee("4","tuấn",14,4,4,"1/1/2004","Sale",4);
        Staff st5 = new Employee("5","Ngọc",15,5,5,"1/1/2005","Marketing",5);
        Staff st6 = new Manager("6","Nhung",16,1,1,"1/1/2001","It","Business Leader");
        Staff st7 = new Manager("7","Dung",17,1,1,"1/1/2002","Marketing","Project Leader");
        Staff st8 = new Manager("8","Kiệt",18,1,1,"1/1/2003","It","Technical Leader");
        Staff st9 = new Manager("9","Duy",19,1,1,"1/1/2004","Marketing","Business Leader");
        Staff st10 = new Manager("10","Lung",20,1,1,"1/1/2005","Sale","Project Leader");
        Department dep1 = new Department("100","It",4);
        Department dep2 = new Department("101","Marketing",4);
        Department dep3 = new Department("102","Sale",2);
        managerHuman.staffs.addAll(Arrays.asList(st1,st2,st3,st4,st5,st6,st7,st8,st9,st10));
        managerHuman.departments.addAll(Arrays.asList(dep1,dep2,dep3));
        int choose;
        do {
            showMenu();
            System.out.println("choose");
            choose = input.inputMenu();
            switch(choose) {
                case 1:System.out.println("=========Danh sách toàn bộ NV==========");
                    managerHuman.show();
                    break;
                case 2:
                    System.out.println("=========Danh sách bộ phận==========");
                    System.out.printf("|%-6s|%-9s|%-4s|\n","Id","TenBoPhan","SoNV");
                    managerHuman.showDepartment();
                break;
                case 3:{System.out.println("=========Danh sách toàn bộ NV theo từng bộ phận==========");
                    managerHuman.sortDepartment();
                    break;
                }
                case 4:

                    System.out.println("Nhập số lượng nv cần thêm:");
                    int n = input.inputInt();
                    for(int i=0; i < n; i++) {
                        System.out.println("Nhập a: để chọn Employee");
                        System.out.println("Nhập b: để chọn Manager");
                        String type = input.inputString().toLowerCase(Locale.ROOT);
                        switch (type) {
                            case "a": {
                                managerHuman.add(addStaff("a"));
                                break;
                            }
                            default:
                                managerHuman.add(addStaff("b"));
                                break;
                        }
                    }
                    break;
                case 5:{
                    System.out.println("Nhập tên hoặc id muốn tìm:");
                    String sc = input.inputString();
                    if (managerHuman.searchNameOrId(sc) == null) {
                        System.out.println("ko tim thay");
                    }else
                        managerHuman.searchNameOrId(sc).display();
                    break;
                }
                case 6:System.out.println("Bảng lương của nhân viên theo thứ tự giảm dần");
                    managerHuman.sortSalaryDown();
                    break;
                case 7:
                    System.out.println("Bảng lương của nhân viên theo thứ tự tăng dần");
                    managerHuman.sortSalaryUp();
                    break;
                case 8:
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.out.println("Bạn nhập sai rồi nhập lại đi");
            }
        } while(choose != 8);

    }

    public static void showMenu() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty: bao gồm 2 loại");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty giảm dần");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("8. Exit");
    }

    public static Staff addStaff(String type) {
        System.out.println("Mã nv:");
        String id = input.inputString();
        System.out.println("Tên:");
        String name = input.inputString();
        System.out.println("Tuổi:");
        int age = input.inputInt();
        System.out.println("hệ số lương:");
        double rate = input.inputDouble();
        System.out.println("số ngày nghỉ:");
        int dayOff = input.inputInt();
        System.out.println("ngày vào làm:");
        String startDate = input.inputDate();
        System.out.println("tên bộ phận:");
        String department = input.inputString();
       if(managerHuman.sortDepart(department) != null){
           managerHuman.sortDepart(department).setEmployee( managerHuman.sortDepart(department).getEmployee()+1);
       }else{
           System.out.println("Nhập id bộ phận");
            String idbp = input.inputString();
            int employeedb =1;
            Department departments = new Department(idbp,department,employeedb);
            managerHuman.addDepartment(departments);
       }
        if(type.equalsIgnoreCase("a")){
            System.out.println("Giờ làm thêm:");
            int hourWork = input.inputInt();
            return  new Employee(id, name, age, rate, dayOff, startDate, department, hourWork);
        }else {
            System.out.println("Chon chức vụ: ");
            System.out.println("a.Business Leader");
            System.out.println("b.Project Leader");
            System.out.println("c.Technical Leader");
            String choose = input.inputString();
                if (choose.equalsIgnoreCase("a")) {
                    String position = "Business Leader";
                    return new Manager(id, name, age, rate, dayOff, startDate, department, position);
                }
                   else if (choose.equalsIgnoreCase("b")) {
                        String position = "Project Leader";
                        return new Manager(id, name, age, rate, dayOff, startDate, department, position);
                    }
                        else{
                        String position = "Technical Leader";
                        return new Manager(id, name, age, rate, dayOff, startDate, department, position);
                }
            }
        }
    }

