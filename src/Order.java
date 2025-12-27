import java.util.List;

public class Order {

    //Long orderId, List<Product> products, String status, Long customerId
    private long orderId;
    private List<Product> products;
    private String status;
    private long customerId;

    public Order() {
    }

    public Order(long orderId, List<Product> products, String status, long customerId) {
        this.orderId = orderId;
        this.products = products;
        this.status = status;
        this.customerId = customerId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
