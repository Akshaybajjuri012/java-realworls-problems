package mydaofiles;
import mypojos.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class ItemDAO {
	public void addItem(String name, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);

        session.save(item);
        tx.commit();
        session.close();
    }
	public List<Item> getAllItems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Item> query = session.createQuery("FROM Item", Item.class);
        List<Item> itemList = query.list();
        session.close();
        return itemList;
    }

    
    public Item getItemById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }
    public void updateItem(Long id, String name, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Item item = session.get(Item.class, id);
        if (item != null) {
            item.setName(name);
            item.setPrice(price);
            session.update(item);
        }

        tx.commit();
        session.close();
    }
    public void deleteItem(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Item item = session.get(Item.class, id);
        if (item != null) {
            session.delete(item);
        }

        tx.commit();
        session.close();
    }

}
