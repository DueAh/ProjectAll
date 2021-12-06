package HumanResource;
//SubClass kế thừa từ class staff
//class thể hiện thông tin quản lý
//và implements từ class Calculator để tính lương QL

public class Manager extends Staff {
    private String position;

    public Manager() {
    }

    @Override
    public void display() {
        System.out.printf("|%-6s|%-6s|%-6s|%-6s|%-16s|%-16s|%-12s|%-15s|%-5s|\n", "Id", "Ten", "Tuoi", "HeSo", "SoNgayNghi", "NgayVaoLam", "BoPhan", "ChucVu", "Luong");
        System.out.println(toString());
        System.out.println();
    }

    @Override
    public void displaySalary() {
        System.out.printf("|%-6s|%-6s|%-12s|%-12s|%-15s|\n","id","Ten", "BoPhan","Luong","ChucVu");
        System.out.println(Salary());
        System.out.println();
    }

    public Manager(String id, String name, int age, double payRate, int numDayOff, String startDate, String department, String position) {
        super(id, name, age, payRate, numDayOff, startDate, department);
        this.position = position;
    }


    public double calculateSalary() {
        if (this.position.equalsIgnoreCase("Business Leader")) {
            return getPayRate() * 5000000 + 8000000;
        } else if (this.position.equalsIgnoreCase("Project Leader")) {
            return getPayRate() * 5000000 + 5000000;
        } else {
            return getPayRate() * 5000000 + 6000000;
        }
    }

    public String Salary() {
        String str2 = super.SalaryInfo();
        return str2 + String.format("%-12.0f|%-15s|",this.calculateSalary(),this.position);
    }
    public String toString() {
        String str2 = super.toString();
        return str2 + String.format("%-15s|%-6.0f|", this.position, this.calculateSalary());
    }

}

