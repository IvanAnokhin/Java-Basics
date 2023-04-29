public class Manager implements Employee {
    private static final int FIXED_RATE = 50000;
    private final int earningsForCompany;
    public Manager() {
        this.earningsForCompany = (int) (Math.random() * 25000) + 115000;
    }
    public int getMonthSalary() {
        return FIXED_RATE + (int) (earningsForCompany * 0.05);
    }
}
