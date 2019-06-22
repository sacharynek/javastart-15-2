import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "memory.csv";
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        boolean menuFlag = true;

        Queue<Vehicle> queue = new LinkedList<>();

        Helper.readBufferToQueue(fileName, queue);

        while (menuFlag) {
            System.out.println("0 - program kończy działanie");
            System.out.println("1 - dodanie nowego pojazdu do kolejki");
            System.out.println("2 - pobranie pojazdu z kolejki do przeglądu");
            System.out.println("3 - program drukuje kolejkę");

            menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 0:
                    menuFlag = false;
                    Helper.writeQueueToFile(fileName, queue);
                    break;
                case 1:
                    queue.add(Helper.readVehicle());
                    break;
                case 2:
                    System.out.println(queue.poll());
                    break;
                case 3:
                    System.out.println(queue);
                    break;
                default:
                    System.out.println("provided choice is not valid. please enter your choice again");
            }
        }
    }
}
