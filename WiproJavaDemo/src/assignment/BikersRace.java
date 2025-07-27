package assignment;
import java.util.Scanner;
public class BikersRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        double[] speeds = new double[5];
        double sum = 0;
        System.out.println("Enter the speeds of 5 bikers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Speed of biker " + (i + 1) + ": ");
            speeds[i] = scanner.nextDouble();
            sum += speeds[i];
        }
            double average = sum / 5;
            System.out.println("\nAverage speed: " + average);
            System.out.println("Qualifying bikers (speed > average):");
            boolean found = false;
            for (int i = 0; i < 5; i++) {
                if (speeds[i] > average) {
                    System.out.println("Biker " + (i + 1) + " with speed: " + speeds[i]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No biker qualified.");
            }
            
      }
	
}


/*
 Enter the speeds of 5 bikers:
Speed of biker 1: 60
Speed of biker 2: 48
Speed of biker 3: 80
Speed of biker 4: 20
Speed of biker 5: 60

Average speed: 53.6
Qualifying bikers (speed > average):
Biker 1 with speed: 60.0
Biker 3 with speed: 80.0
Biker 5 with speed: 60.0
*/
