import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;

class Helper {


    static Vehicle readVehicle() {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        System.out.println("podaj liczbe odpowiadajaca typowi pojazdu");

        VehicleType[] types = VehicleType.values();
        for (VehicleType type : types) {
            System.out.println(type);
        }

        vehicle.setVehicleType(VehicleType.fromInteger(Integer.parseInt(sc.nextLine())));

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

    static void readBufferToQueue(String fileName, Queue<Vehicle> queue) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sreader = new Scanner(file);

        while (sreader.hasNextLine()) {
            String line = sreader.nextLine();
            String[] vehicleArgs = line.split(",");
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(VehicleType.fromInteger(Integer.parseInt(vehicleArgs[0])));
            vehicle.setMake(vehicleArgs[1]);
            vehicle.setModel(vehicleArgs[2]);
            vehicle.setYear(Integer.parseInt(vehicleArgs[3]));
            vehicle.setMileage(Integer.parseInt(vehicleArgs[4]));
            vehicle.setVin(vehicleArgs[5]);
            queue.add(vehicle);
        }
    }

    static void writeQueueToFile(String fileName, Queue<Vehicle> queue) throws IOException {
        System.out.println("Program has finished");
        if (!queue.isEmpty()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Vehicle vehicle : queue) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            writer.close();
        }
    }
}
