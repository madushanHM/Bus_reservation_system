package Users;

public class Conductor extends User {
    private int conductorId;

    public Conductor(int userId, String name, String email, String phone, int conductorId) {
        super(userId, name, email, phone);
        this.conductorId = conductorId;
    }

    public int getConductorId() { return conductorId; }
    public void setConductorId(int conductorId) { this.conductorId = conductorId; }

    @Override
    public String toString() {
        return "Conductor{" +
                "ConductorID=" + conductorId +
                ", Name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                '}';
    }
}