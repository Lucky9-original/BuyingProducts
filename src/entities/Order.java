package entities;

import entities.enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Order() {
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem (OrderItem item){
        orderItems.add(item);
    }
    
    public void removeOrderItem (OrderItem item){
        orderItems.remove(item);
    }
    
    public double total(){
        double sum = 0;
        for (OrderItem c: orderItems){
            sum += c.subTotal();
        }
        
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + sdf.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName() + "(" + sdf2.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
        sb.append("Order items: \n");
        for (OrderItem c : orderItems){
            sb.append(c.getProduct().getName() + ", €" + String.format("%.2f", c.getPrice()) + ", Quantity: " + c.getQuantity() + ", Subtotal: €" + String.format("%.2f\n", c.subTotal()));
        }
        sb.append("Total price: €" + String.format("%.2f\n", this.total()));
        return sb.toString();
    }
    
    
    
}
