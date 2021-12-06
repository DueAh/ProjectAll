package HumanResource;
//SubClass kế thừa từ class staff
//class thể hiện thông tin nhân vien
//và implements từ class Calculator để tính lương nv

public class Employee extends Staff {
        private int hourWork;
        public Employee() {
        }
    @Override
    public void display() {
        System.out.printf("|%-6s|%-6s|%-6s|%-6s|%-16s|%-16s|%-12s|%-15s|%-5s|\n", "Id", "Ten", "Tuoi", "HeSo", "SoNgayNghi", "NgayVaoLam", "BoPhan", "GioLamThem", "Luong");
        System.out.println(toString());
        System.out.println();
    }

    @Override
    public void displaySalary() {
        System.out.printf("|%-6s|%-6s|%-12s|%-6s|\n","id","Ten", "BoPhan","Luong");
        System.out.println(Salary());
        System.out.println();
    }


    public Employee(String id, String name, int age, double payRate, int numDayOff, String startDate, String department, int hourWork) {
            super(id, name, age, payRate, numDayOff, startDate, department);
            this.hourWork = hourWork;

        }

        public double calculateSalary() {
            return this.getPayRate() * 3000000 + (this.getHourWork() * 200000);
        }


    public String Salary() {
        String str2 = super.SalaryInfo();
        return str2 + String.format("%-6.0f|",this.calculateSalary());
    }


    public int getHourWork() {
            return this.hourWork;
        }

        public String toString() {
            String str1 = super.toString();
            return str1 + String.format("%-15d|%-5.0f|", this.getHourWork(), this.calculateSalary());
        }
    }

