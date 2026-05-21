package HighCoupling;

public class Order {
    private final DatabaseRepositoryInterface db;
    private final EmailRepositoryInterface email;

    public Order(DatabaseRepositoryInterface db, EmailRepositoryInterface email) {
        this.db = db;
        this.email = email;
    }

    public void finish() {
        db.save(this);
        email.send(this);
    }
}
