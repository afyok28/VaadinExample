package com.example.ogun.Vaadin.service;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.ogun.Vaadin.repository.ProgramingLangue;
import com.example.ogun.Vaadin.repository.User;
import com.example.ogun.Vaadin.utils.HibernateUtil;

public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public boolean validate(String nick, String password) {
		String sql = "Select user From User user Where user.nick= :nick and user.password= :password";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createQuery(sql).setParameter("nick", nick).setParameter("password", password);
			User user = (User) query.getSingleResult();
			if (user != null)
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public User selectt(String nick) {

		ProgramingLangueService languesService = new ProgramingLangueService();
		List<ProgramingLangue> list = languesService.select();
		for (ProgramingLangue programingLangues : list) {
			System.out.println(programingLangues);
		}

		String sql = "Select user From User user Where user.nick= :nick ";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createQuery(sql).setParameter("nick", nick);
			User user = (User) query.getSingleResult();
			user.setPassword(null);
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}
}
