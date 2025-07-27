package assignment;
enum Currency {
    DOLLAR,
    EURO,
    POUND,
    YEN,
    RUPEE,
    FRANC
}
public class CurrencyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("List of currencies:");
	        for (Currency currency : Currency.values()) {
	            System.out.println(currency);
	        }

	        System.out.println("\nDescriptions:");
	        for (Currency currency : Currency.values()) {
	            switch (currency) {
	                case DOLLAR:
	                    System.out.println("Dollar: The official currency of the United States.");
	                    break;
	                case EURO:
	                    System.out.println("Euro: The official currency of the Eurozone countries.");
	                    break;
	                case POUND:
	                    System.out.println("Pound: The official currency of the United Kingdom.");
	                    break;
	                case YEN:
	                    System.out.println("Yen: The official currency of Japan.");
	                    break;
	                case RUPEE:
	                    System.out.println("Rupee: The official currency of India.");
	                    break;
	                case FRANC:
	                    System.out.println("Franc: Former currency of Switzerland and several African countries.");
	                    break;
	                default:
	                    System.out.println("Unknown currency.");
	                    break;
	            }
	        }

	}

}

/*
List of currencies:
DOLLAR
EURO
POUND
YEN
RUPEE
FRANC

Descriptions:
Dollar: The official currency of the United States.
Euro: The official currency of the Eurozone countries.
Pound: The official currency of the United Kingdom.
Yen: The official currency of Japan.
Rupee: The official currency of India.
Franc: Former currency of Switzerland and several African countries.
*/