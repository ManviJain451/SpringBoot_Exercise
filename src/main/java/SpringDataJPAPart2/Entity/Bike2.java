package SpringDataJPAPart2.Entity;

import jakarta.persistence.Entity;

@Entity
public class Bike2 extends Vehicle2{
    private boolean hasCarrier;

    public boolean isHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }
}
