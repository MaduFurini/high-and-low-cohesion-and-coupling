package LowCoupling;

public class DatabaseRepositoryInterface {
    public void save(Order order) {
        System.out.println(
            "Saving order..." +
            "\n" +
            "Order: " +
            order
        );
    }
}
