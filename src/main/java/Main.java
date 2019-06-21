import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "memory.csv";
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;

        Queue<Vehicle> queue = new LinkedList<>();

        File file = new File(fileName);
        Scanner sreader = new Scanner(file);

        while(sreader.hasNextLine()){
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

        queue.add(Helper.readVehicle());
        System.out.println(queue);

        boolean flag = true;
        while (flag) {
            System.out.println("0 - program kończy działanie");
            System.out.println("1 - dodanie nowego pojazdu do kolejki");
            System.out.println("2 - pobranie pojazdu z kolejki do przeglądu");
            menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 0:
                    flag = false;
                    System.out.println("Program has finished");
                    if (!queue.isEmpty()) {
                        //zapisz kolejke do pliku
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                        for (Vehicle vehicle : queue) {
                            writer.write(vehicle.toString());
                            writer.newLine();
                        }
                        writer.close();

                    }

                    break;
                case 1:
                    queue.add(Helper.readVehicle());
                    break;
                case 2:
                    System.out.println(queue.poll());
                    break;
                default:
                    System.out.println("provided choice is not valid. please enter your choice again");
            }

        }

    }
}
