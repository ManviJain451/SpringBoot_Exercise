package SpringDataJPAPart2.Entity;

import jakarta.persistence.Entity;

@Entity
public class Car2 extends Vehicle2 {
    private int seatingCapacity;

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}


