package HumanResource;
//class Bộ phận

public class Department {
    private String id;
    private String name;
    private int employee=0;
    public Department() {
    }

    public Department(String id, String name, int employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public String getId() {
        return this.id;
    }

    public Department setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public int getEmployee() {
        return this.employee++;
    }

    public Department setEmployee(int employee) {
        this.employee = employee;
        return this;
    }

    @Override
    public String toString() {
        return String.format("|%-6s|%-9s|%-4d|",id,name,employee);
    }
}

