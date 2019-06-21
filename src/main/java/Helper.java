import java.sql.SQLOutput;
import java.util.Scanner;

public class Helper {


    public static Vehicle readVehicle() {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        System.out.println("podaj liczbe odpowiadajaca typowi pojazdu");

        VehicleType[] types = VehicleType.values();
        for (VehicleType type : types) {
            System.out.println(type);
        }

        //trzeba zrobić metode wyboru
        vehicle.setVehicleType(VehicleType.LORRY);

        sc.nextLine();

        System.out.println("podaj markę");
        vehicle.setMake(sc.nextLine());
        System.out.println("podaj model");
        vehicle.setModel(sc.nextLine());

        System.out.println("podaj rok produkcji");
        vehicle.setYear(sc.nextInt());
        sc.nextLine();
        System.out.println("podaj przebieg");
        vehicle.setMileage(sc.nextInt());
        sc.nextLine();
        System.out.println("podaj vin");
        vehicle.setVin(sc.nextLine());

        System.out.println(vehicle);
        return vehicle;
    }
}
