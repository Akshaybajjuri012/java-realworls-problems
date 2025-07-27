package assignment;

public class Problem10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
            System.out.println("Please provide the number of eggs as a command line argument.");
            return;
        }
        int totalEggs = Integer.parseInt(args[0]);
        int gross = totalEggs / 144;
        int remainingAfterGross = totalEggs % 144;
        int dozens = remainingAfterGross / 12;
        int leftover = remainingAfterGross % 12;
        System.out.println("Your number of eggs is: " + gross + " gross, " + dozens + " dozen, and " + leftover + " eggs.");


	}

}

/*
Your number of eggs is: 34 gross, 8 dozen, and 8 eggs.
*/