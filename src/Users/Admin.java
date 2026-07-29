package Users;

public class Admin extends User {
    private int adminId;

    public Admin(int userId, String name, String email, String phone, int adminId) {
        super(userId, name, email, phone);
        this.adminId = adminId;
    }

    public int getAdminId() { return adminId; }
    public void setAdminId(int adminId) { this.adminId = adminId; }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminID=" + adminId +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}