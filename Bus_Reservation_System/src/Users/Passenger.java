package Users;

public class Passenger extends User {

    public Passenger(int userId, String name, String email, String phone) {
        super(userId, name, email, phone);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ID=" + userId +
                ", Name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                '}';
    }
}
