package buyingproducts;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = tec.nextLine();
        System.out.print("Email: ");
        String email = tec.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(tec.nextLine());
        System.out.println("");
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = tec.nextLine();
        System.out.print("How many items to this order? ");
        int n = tec.nextInt();
        
        Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
        
        for (int i=1; i<=n; i++){
            System.out.println("Enter #" + i + " item data: ");
            tec.nextLine();
            System.out.print("Product name: ");
            String nameProduct = tec.nextLine();
            System.out.print("Product price: ");
            double priceProduct = tec.nextDouble();
            System.out.print("Quantity: ");
            int quantity = tec.nextInt();
            order.addOrderItem(new OrderItem(quantity, priceProduct, new Product(nameProduct, priceProduct)));
        }
        
        System.out.println("");
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order.toString());
        
        
        
    }
    
}
