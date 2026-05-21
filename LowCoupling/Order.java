package LowCoupling;

public class Order {
    private MySQLRepository db = new MySQLRepository();
    private SmtpEmail email = new SmtpEmail();

    public void finish() {
        db.save(this);
        email.send(this);
    }
}
