package SpringDataJPAPart2.Repository;

import SpringDataJPAPart2.Entity.Vehicle1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository1 extends JpaRepository<Vehicle1, Long> {
}
