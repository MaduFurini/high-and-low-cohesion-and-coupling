package LowCoupling;

public class MySQLRepository {
    public void save(Order order) {
        System.out.println(
            "Saving order..." +
            "\n" +
            "Order: " +
            order
        );
    }
}
