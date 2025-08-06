package problem6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        PersonDAO personDAO = context.getBean(PersonDAO.class);

        System.out.println("Initial list of persons:");
        List<Person> persons = personDAO.findAll();
        persons.forEach(System.out::println);

        System.out.println("\nGet person with ID 2:");
        System.out.println(personDAO.findById(2));

        System.out.println("\nCreating person with ID 4:");
        Person newPerson = new Person(4, 36, "Sergey", "Emets");
        personDAO.insert(newPerson);

        System.out.println("\nList after creation:");
        personDAO.findAll().forEach(System.out::println);

        System.out.println("\nUpdating person with ID 4 (lastName -> CHANGED):");
        newPerson.setLastName("CHANGED");
        personDAO.update(newPerson);

        System.out.println("\nList after update:");
        personDAO.findAll().forEach(System.out::println);

        System.out.println("\nDeleting person with ID 2:");
        personDAO.deleteById(2);

        System.out.println("\nFinal list of persons:");
        personDAO.findAll().forEach(System.out::println);

        context.close();
    }
}
