package com.example.ogun.Vaadin.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import com.example.ogun.Vaadin.repository.DbAll;
import com.example.ogun.Vaadin.repository.ProgramingLangue;
import com.example.ogun.Vaadin.utils.HibernateUtil;

public class DbAllService {

	public List<DbAll> findAllFilm2(String str) {
		String hql = "Select dbAll " + "From DbAll dbAll " + "Left Join Fetch dbAll.user u "
				+ "Left Join Fetch dbAll.programingLangue pl " + "Left Join Fetch dbAll.programinLangueCategory plc "
				+ "Left Join Fetch dbAll.problem p " + " Where dbAll.problem.title  LIKE CONCAT('%', :str, '%') Or"
				+ " dbAll.programinLangueCategory.name LIKE CONCAT('%', :str, '%') Or "
				+ " dbAll.programingLangue.name LIKE CONCAT('%', :str, '%')";

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) {

			@SuppressWarnings("unchecked")
			Query<DbAll> query = session.createQuery(hql).setParameter("str", MatchMode.ANYWHERE.toMatchString(str));
			System.out.println("selecttttttttt");
			return (List<DbAll>) query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void save(DbAll dbAll) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			session.merge(dbAll);
			transaction.commit();
			System.out.println("saveeeee");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean delete(ProgramingLangue programingLangue) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "delete from DbAll dbAll where dbAll.programingLangue.id= :pid ";
			@SuppressWarnings("unchecked")
			Query<DbAll> query = session.createQuery(hql).setParameter("pid", programingLangue.getId());
			System.out.println(query.executeUpdate());
			transaction.commit();
			return true;
		} catch (Throwable t) {
			transaction.rollback();
			t.printStackTrace();
			return false;
		}
	}

	public boolean delete(DbAll dbAll) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			session.delete(dbAll);
			transaction.commit();
			System.out.println("deleteeeeeeeee");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
