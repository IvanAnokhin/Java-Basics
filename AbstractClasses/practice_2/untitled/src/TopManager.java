public class TopManager implements Employee {
    public static int FIXED_RATE = 1500000;
    public int getMonthSalary() {
        return FIXED_RATE + Company.getIncome() > 10000000 ? (int) (FIXED_RATE * 1.5) : 0;
    }
}
