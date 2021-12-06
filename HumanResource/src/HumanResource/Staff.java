package HumanResource;
//Class cha staff
public abstract class Staff implements ICalculator {
    private String id;
    private String name;
    private int age;
    private double payRate;
    private int numDayOff;
    private String startDate;
    private String department;

    public Staff() {
    }
    public abstract void  display();
    public abstract void displaySalary();

    public Staff(String id, String name, int age, double payRate, int numDayOff, String startDate, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.payRate = payRate;
        this.numDayOff = numDayOff;
        this.startDate = startDate;
        this.department = department;
    }

    public String getId() {
        return this.id;
    }

    public Staff setId(String id) {
        this.id = id;
        return this;
    }

    public String getDepartment() {
        return this.department;
    }

    public Staff setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Staff setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return this.age;
    }

    public Staff setAge(int age) {
        this.age = age;
        return this;
    }

    public double getPayRate() {
        return this.payRate;
    }

    public Staff setPayRate(double payRate) {
        this.payRate = payRate;
        return this;
    }

    public int getNumDayOff() {
        return this.numDayOff;
    }

    public Staff setNumDayOff(int numDayOff) {
        this.numDayOff = numDayOff;
        return this;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public Staff setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }


    public String toString() {
        return String.format("|%-6s|%-6s|%-6s|%-6.2f|%-16d|%-16s|%-12s|", this.id, this.name, this.age, this.payRate, this.numDayOff, this.startDate, this.department);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    public  String SalaryInfo(){
        return String.format("|%-6s|%-6s|%-12s|", this.id, this.name, this.department);
    }
}
