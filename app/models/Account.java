package models;

import siena.*;

import java.util.Collection;

public class Account extends Model {

    @Id
    public Long id;

    public String paypalID;
    public String type;

    public Account(String paypalID, String type) {
        this.paypalID = paypalID;
        this.type = type;
    }

    static Query<Account> all() {
        return Model.all(Account.class);
    }

    public static Account findById(Long id) {
        return all().filter("id", id).get();
    }

    public String toString() {
        return paypalID;
    }

}