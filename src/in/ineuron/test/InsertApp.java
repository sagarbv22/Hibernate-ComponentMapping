package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.entity.Address;
import in.ineuron.entity.StudentInfo;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {

			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Address address = new Address();
			address.setDoorNo(9);
			address.setStreet("BasweshwaraNagar");
			address.setCity("Bengaluru");

			StudentInfo info = new StudentInfo();
			info.setSname("Sagar");
			info.setSage(23);
			info.setAddress(address);

			Integer row = (Integer) session.save(info);
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Record inserted successfully");
			} else {
				transaction.rollback();
				System.out.println("Failed to insert");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
