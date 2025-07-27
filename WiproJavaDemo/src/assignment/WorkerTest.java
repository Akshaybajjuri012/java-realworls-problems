package assignment;
abstract class Worker {
 protected String name;
 protected double salaryRate;

 public Worker(String name, double salaryRate) {
     this.name = name;
     this.salaryRate = salaryRate;
 }

 public abstract double pay(int hours);

 public String getName() {
     return name;
 }
}

class DailyWorker extends Worker {

 public DailyWorker(String name, double salaryRate) {
     super(name, salaryRate); 
 }

 @Override
 public double pay(int daysWorked) {
     return salaryRate * daysWorked;
 }
}

class SalariedWorker extends Worker {

 public SalariedWorker(String name, double salaryRate) {
     super(name, salaryRate); 
 }

 @Override
 public double pay(int hoursWorked) {
     return salaryRate * 40; 
 }
}
public class WorkerTest {
    public static void main(String[] args) {
       
        DailyWorker daily = new DailyWorker("mohan", 100.0);          
        SalariedWorker salaried = new SalariedWorker("ram", 25.0);   
        
        System.out.println(daily.getName() + "'s pay for 5 days: $" + daily.pay(5));
        System.out.println(salaried.getName() + "'s pay for 30 hours: $" + salaried.pay(30));
        System.out.println(salaried.getName() + "'s pay for 50 hours: $" + salaried.pay(50)); 
    }
}



/*
mohan's pay for 5 days: $500.0
ram's pay for 30 hours: $1000.0
ram's pay for 50 hours: $1000.0
*/