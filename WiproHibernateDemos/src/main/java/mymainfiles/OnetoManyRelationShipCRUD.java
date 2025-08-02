package mymainfiles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.CustomerPojo;
import mypojos.VendorPOJO;
public class OnetoManyRelationShipCRUD {
	static Scanner sc = new Scanner(System.in);
    static SessionFactory factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- VENDOR-CUSTOMER MENU ---");
            System.out.println("1. Add Vendor with Customers");
            System.out.println("2. View All Vendors");
            System.out.println("3. Update Vendor");
            System.out.println("4. Delete Vendor");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
            case 1 : addVendor();break;
            case 2 : viewAll();break;
            case 3 : updateVendor();break;
            case 4 : deleteVendor();break;
            case 0 : System.out.println("Exiting...");break;
            default :System.out.println("Invalid choice.");
        }
        } while (choice != 0);
        factory.close();
    }
        public static void addVendor() 
        {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            VendorPOJO vendor = new VendorPOJO();
            System.out.print("Enter vendor ID: ");
            vendor.setVid1(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter vendor name: ");
            vendor.setVname1(sc.nextLine());
            sc.nextLine();        
            System.out.print("Enter vendor email: ");
            vendor.setVemail(sc.nextLine());

            List<CustomerPojo> list = new ArrayList<>();
            System.out.print("How many customers? ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) 
            {
            	CustomerPojo c = new CustomerPojo();
                System.out.print("Enter customer ID: ");
                c.setCustid(sc.nextInt());
                sc.nextLine();        
                System.out.print("Enter customer name: ");
                c.setCustname(sc.nextLine());
                list.add(c);//customers to be added in arraylist
            }
                vendor.setCustomers(list);//One to many:: One vendor many customers!
                session.persist(vendor);//Iam persisting vendor object, but customer object will also be persisted by default!
                //session.save(vendor);//Iam saving vendor object, but customer object will also be persisted by default!

                tx.commit();
                session.close();
                System.out.println("Vendor and customers saved successfully.");
            }
        public static void viewAll() {
            Session session = factory.openSession();
            session.clear();
            @SuppressWarnings("unchecked")
			List<VendorPOJO> list = session.createQuery("from VendorPOJO").list();//HQL COMMAND
            for (VendorPOJO v : list) {
                System.out.println("\nVendor ID: " +v.getVid1());
                System.out.println("Vendor Name: " + v.getVname1());
                System.out.println("Vendor Email: " + v.getVemail());
                
                System.out.println("Customers:");
                for (CustomerPojo c : v.getCustomers()) {
                    System.out.println("  - " + c.getCustid()+ " : " + c.getCustname());
                }
            }

            session.close();
        }
        public static void updateVendor() {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            System.out.print("Enter vendor ID to update: ");
            int id = sc.nextInt();

            VendorPOJO v =(VendorPOJO) session.get(VendorPOJO.class, id);//select * from tablename where eno=?
            if (v != null) 
            {
                System.out.print("Enter new vendor name: ");
                v.setVname1(sc.next());

                // Optionally update customer names
                for (CustomerPojo c : v.getCustomers()) {
                    System.out.print("Update name for customer ID " + c.getCustid() + " (current: " + c.getCustname() + "): ");
                    c.setCustname(sc.next());
                }
                session.update(v);//update operation
                tx.commit();
                System.out.println("Vendor updated.");
            } else {
                System.out.println("Vendor ID not found.");
            }

            session.close();
        }
        public static void deleteVendor() {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            System.out.print("Enter vendor ID to delete: ");
            int id = sc.nextInt();
            VendorPOJO v =(VendorPOJO) session.get(VendorPOJO.class, id);

            if (v != null) {
                session.delete(v); // Will also delete all customers (cascade)
                tx.commit();
                System.out.println("Vendor and associated customers deleted.");
            } else {
                System.out.println("Vendor not found.");
            }

            session.close();
        }



}
