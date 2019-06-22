import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private VehicleType vehicleType;
    private String make, model;
    private int year, mileage;
    private String vin;

    void setVehicleType(VehicleType vehicleType) {
        if (null == vehicleType) {
            throw new NullPointerException("vehicle type musn't be null");
        }
        this.vehicleType = vehicleType;
    }

    void setMake(String make) {
        if (make.length() < 3) {
            throw new IllegalArgumentException("Marka jest za krótka");
        }
        this.make = make;
    }

    void setModel(String model) {
        if (make.length() < 3) {
            throw new IllegalArgumentException("Model jest za krótki");
        }
        this.model = model;
    }

    void setYear(int year) {
        if (year < 1960 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("rok musi być większy od 1960 i nie może być wiekszy niż " + LocalDate.now().getYear());
        }
        this.year = year;
    }

    void setMileage(int mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("przebieg nie moze być mniejszy niż 0");
        }
        this.mileage = mileage;
    }

    void setVin(String vin) {
        if (make.length() < 3) {
            throw new IllegalArgumentException("Vin jest za krótki");
        }
        this.vin = vin;
    }

    @Override
    public String toString() {
        return this.getVehicleType().getValue() + "," + this.getMake() + ","
                + this.getModel() + "," + this.getYear() + "," + this.getMileage() + "," + this.getVin();
    }
}
