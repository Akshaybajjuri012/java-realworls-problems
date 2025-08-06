package problem2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PropertyMain {
	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PropertyMain.class, args);

        PropertyDemo propertyDemo = context.getBean(PropertyDemo.class);
        propertyDemo.printValues();
    }

}
