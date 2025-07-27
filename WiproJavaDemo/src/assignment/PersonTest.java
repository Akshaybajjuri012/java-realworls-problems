package assignment;
abstract class Person {
    public abstract void eat();
    public abstract void exercise();
}

// Athlete subclass
class Athlete extends Person {
    @Override
    public void eat() {
        System.out.println("Athlete eats a balanced diet with proteins and veggies.");
    }

    @Override
    public void exercise() {
        System.out.println("Athlete exercises daily with intense workouts.");
    }
}
class LazyPerson extends Person {
    @Override
    public void eat() {
        System.out.println("Lazy person eats fast food and snacks all day.");
    }

    @Override
    public void exercise() {
        System.out.println("Lazy person rarely exercises and prefers lying on the couch.");
    }
}
public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person athlete = new Athlete();
        Person lazy = new LazyPerson();

        System.out.println("=== Athlete ===");
        athlete.eat();
        athlete.exercise();

        System.out.println("\n=== Lazy Person ===");
        lazy.eat();
        lazy.exercise();

	}

}

/*
 * === Athlete ===
Athlete eats a balanced diet with proteins and veggies.
Athlete exercises daily with intense workouts.

=== Lazy Person ===
Lazy person eats fast food and snacks all day.
Lazy person rarely exercises and prefers lying on the couch.
*/
