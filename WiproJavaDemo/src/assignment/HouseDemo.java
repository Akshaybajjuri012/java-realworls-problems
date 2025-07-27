package assignment;
import static java.lang.System.out;  
import java.util.Arrays;


class Hall {
    public void enterMessage() {
        out.println("This is the first room while entering the house");
    }
}


class Kitchen {
    public void showAppliances() {
        String[] appliances = {"Refrigerator", "Microwave", "Oven", "Dishwasher", "Toaster"};

        System.out.println("Original appliances:");
        for (String item : appliances) {
            System.out.println("- " + item);
        }
        String[] copiedAppliances = Arrays.copyOf(appliances, appliances.length);

        System.out.println("\nCopied appliances:");
        for (String item : copiedAppliances) {
            System.out.println("- " + item);
        }
    }
}
public class HouseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hall hall = new Hall();
        hall.enterMessage();

        System.out.println(); // spacing

        Kitchen kitchen = new Kitchen();
        kitchen.showAppliances();

	}

}

/*
This is the first room while entering the house

Original appliances:
- Refrigerator
- Microwave
- Oven
- Dishwasher
- Toaster

Copied appliances:
- Refrigerator
- Microwave
- Oven
- Dishwasher
- Toaster
*/