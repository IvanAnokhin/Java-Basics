public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight;
    private static int totalCount;
    private static int totalPriceAll;
    private static int totalCountAll;

    private static class AllBaskets {
        static int itemCount;
        static int cost;
    }

    public Basket() {
        increaseCount(1);
        countAll(Basket.totalCount);
        items = "list of products";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }
    public Basket(String items, int totalPrice, double totalWeight, int count) {
        this();
        this.items = this.items + items;
        this.totalWeight = totalWeight;
        Basket.count = count;
    }
    public int getCount() {
        return totalCount;
    }


    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }
    public static void priceAll(int totalPrice) {
        Basket.totalPriceAll = Basket.totalPriceAll + totalPrice;
    }
    public static int getPriceAll() {
        return Basket.totalPriceAll;
    }
    private static void countAll(int totalCount) {
        Basket.totalCountAll = Basket.totalCountAll + totalCount;
    }
    public static int getCountAll() {
        return Basket.totalCountAll;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }
    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }
    public void add(String name, int price, int count, double weight) {
        boolean error = contains(name);
        if (totalPrice + count * price >= limit) {
            error = true;
        }
        if (error) {
            System.out.println("limit previshen");
            return;
        }


        items = items + "\n" + name + " - " +
                count + " pc. - " + "Price: " + price + " Rub." + " Weight - " + weight + " Gram";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        totalCount = totalCount + count;
        totalCountAll = totalCountAll + totalCount;
        totalPriceAll = totalPriceAll + totalPrice;
        AllBaskets.itemCount += count;
        AllBaskets.cost += price * count;
    }
    public int getTotalPrice() {
        return totalPrice;

    }
    public static int getItemCountForAllBaskets() {
        return AllBaskets.itemCount;
    }
    public static int getCostForAllBaskets() {
        return AllBaskets.cost;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    public boolean contains(String name) {
        return items.contains(name);
    }
    public void printAll() {
        System.out.println("\n" + "Total cost - " + getTotalPrice() + " Rub." + "\n" + "Total weight of products - " + getTotalWeight() + " Gram" + "\n" + "Total number of products " + getCount() + " pc." + "\n");
    }
    public static void printBasket() {
        System.out.println("Total number of products in all baskets - " + getCountAll() + "\n" + "Total cost of goods - " + getPriceAll());
    }
    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
        totalCount = 0;
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
