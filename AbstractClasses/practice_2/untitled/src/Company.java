import java.util.*;
public class Company {
    private final List<Employee> employees = new ArrayList<Employee>();
    public void hire(Employee employee) { // Найм сотрудника.
        this.employees.add(employee);
    }
    public void hireAll(Collection<Employee> employees) { // Найм списка сотрудников.
        this.employees.addAll(employees);
    }
    public void fire(Employee employee) { // Увольнение сотрудника.
        employees.remove(employee);
    }
    public static int getIncome() { // Доход компании.
        return 15000000;
    }
    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });
    }
    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<>(employees);
        Collections.sort(copyList, comparator);
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(copyList.get(i));
        }
        return result;
    }
    public int countEmployees() {
        return employees.size();
    }
    public List<Employee> getEmployees() {
        return employees;
    }
}