package extra;

public class Seat {
    private String name;
    private boolean isReserved;

    public Seat() {
    }

    public Seat(String name, boolean isReserved) {
        this.name = name;
        this.isReserved = isReserved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
}
