public class Main1 {

    public static void main(String[] args) {
        Basket vanyaBasket = new Basket(1000);
        vanyaBasket.add("Milk",40,3,500);
        vanyaBasket.add("Avocado",100,1,200);
        vanyaBasket.add("Pizza", 545,1,1000);
        vanyaBasket.print("Vanya's basket:");
        vanyaBasket.printAll();
        vanyaBasket.clear();
        System.out.println("------------------------");
        Basket elizavetaBasket = new Basket(1000);
        elizavetaBasket.add("Bread", 70,2,250);
        elizavetaBasket.add("Coffe", 230,2,1000);
        elizavetaBasket.add("Lemon",35,5,50);
        elizavetaBasket.print("Elizaveta's basket:");
        elizavetaBasket.printAll();
        elizavetaBasket.clear();
        System.out.println("-------------------------");

        System.out.println("Total number of items in the baskets: " + Basket.getItemCountForAllBaskets() + " pc.");
        System.out.println("Total amount in baskets: " + Basket.getCostForAllBaskets() + " Rub.");
    }
}
