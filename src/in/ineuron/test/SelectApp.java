package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.entity.Address;
import in.ineuron.entity.StudentInfo;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		try {

			session = HibernateUtil.getSession();

			StudentInfo info = session.get(StudentInfo.class, id);

			System.out.println(info);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
