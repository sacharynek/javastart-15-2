import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private VehicleType vehicleType;
    private String make, model;
    private int year, mileage;
    private String vin;



}
