import java.util.Scanner;

abstract class Shop<T> {
    protected T price;
    protected int noltem;
    protected String itemName;

    public Shop(T price, int noltem, String itemName) {
        this.price = price;
        this.noltem = noltem;
        this.itemName = itemName;
    }

    public abstract T TotalBill();

    public String toString() {
        return "Item: " + itemName + "\nQuantity: " + noltem + "\nPrice: " + price + "\nTotal Bill: " + TotalBill();
    }
}

class Cafe extends Shop<Integer> {
    public Cafe(Integer price, int noltem, String itemName) {
        super(price, noltem, itemName);
    }

    public Integer TotalBill() {
        return price * noltem;
    }
}

class Restaurant extends Shop<Double> {
    private double vat;
    private double serviceCharge;

    public Restaurant(Double price, int noltem, String itemName) {
        super(price, noltem, itemName);
        this.vat = 0.05;
        this.serviceCharge = 0.1;
    }

    public Double TotalBill() {
        return (price * noltem) + ((price * noltem) * vat) + ((price * noltem) * serviceCharge);
    }

    public String toString() {
        return super.toString() + "\nVAT: " + (vat * 100) + "%\nService Charge: " + (serviceCharge * 100) + "%";
    }
}

public class Final {
    public static void compareBill(Shop<?> shop1, Shop<?> shop2) {
        System.out.println("Comparing bills:");
        System.out.println("Shop 1:\n" + shop1);
        System.out.println("\nShop 2:\n" + shop2);

        System.out.println("\nShop 1's bill is " + shop1.TotalBill() + " units.");
        System.out.println("Shop 2's bill is " + shop2.TotalBill() + " units.");

        if (shop1.TotalBill().equals(shop2.TotalBill())) {
            System.out.println("Both bills are equal.");
        } else {
            System.out.println("Bills are not equal.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter details for Cafe:");
        System.out.print("Enter price: ");
        int cafePrice = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int cafeQuantity = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter item name: ");
        String cafeItemName = scanner.nextLine();

   
        Cafe cafe = new Cafe(cafePrice, cafeQuantity, cafeItemName);

   
        System.out.println("\nEnter details for Restaurant:");
        System.out.print("Enter price: ");
        double restaurantPrice = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int restaurantQuantity = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter item name: ");
        String restaurantItemName = scanner.nextLine();

   
        Restaurant restaurant = new Restaurant(restaurantPrice, restaurantQuantity, restaurantItemName);

        scanner.close();

        compareBill(cafe, restaurant);
    }
}