package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		double rate = 0.0;

		try {
			tx = session.beginTransaction();
			
			Query query = session.createQuery("SELECT InterestRate FROM RateDomainModel WHERE MinCreditScore is" + GivenCreditScore);
			query.setParameter("CreditScore", GivenCreditScore);
			
			List<?> list = query.list();
			rate = ((RateDomainModel)list.get(0)).getInterestRate();

			tx.commit();
		} 
		
		catch (HibernateException e){
			if (tx != null){
				tx.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		
		} 
		
		return rate;
		
	}
	
	

	public static ArrayList<RateDomainModel> getRates() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>();

		try {
			tx = session.beginTransaction();

			List rules = session.createQuery("FROM RateDomainModel ORDER BY RATEID").list();
			for (Iterator iterator = rules.iterator(); iterator.hasNext();) {
				RateDomainModel r = (RateDomainModel) iterator.next();
				rates.add(r);

			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rates;

	}

}