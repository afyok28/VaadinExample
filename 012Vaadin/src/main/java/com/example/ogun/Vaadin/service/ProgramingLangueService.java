package com.example.ogun.Vaadin.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.ogun.Vaadin.repository.ProgramingLangue;
import com.example.ogun.Vaadin.utils.HibernateUtil;

public class ProgramingLangueService {

	public List<ProgramingLangue> select() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			@SuppressWarnings("unchecked")
			Query<ProgramingLangue> query = session.createQuery("Select pl From ProgramingLangue pl");
			return query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public boolean save(ProgramingLangue programingLangue) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			session.merge(programingLangue);
			transaction.commit();
			System.out.println("saveeeee");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(ProgramingLangue programingLangue) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			Transaction transaction = session.beginTransaction();
			session.delete(programingLangue);
			transaction.commit();
			session.close();
			DbAllService dbAllService=new DbAllService();
			return dbAllService.delete(programingLangue);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
