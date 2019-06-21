import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;

        Queue<Vehicle> queue = new LinkedList<>();

        queue.add( Helper.readVehicle());
        System.out.println(queue);



        boolean flag = true;
        while(flag){
            System.out.println("0 - program kończy działanie");
            System.out.println("1 - dodanie nowego pojazdu do kolejki");
            System.out.println("2 - pobranie pojazdu z kolejki do przeglądu");
            menuChoice = sc.nextInt();

            switch(menuChoice){
                case 0:
                    flag = false;
                    System.out.println("Program has finished");
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
