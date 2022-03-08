package academy.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import academy.lgs.dao.UserDao;
import academy.lgs.domain.User;
import academy.lgs.shared.FactoryManager;

public class UserDaoImpl implements UserDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public User create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			user = em.find(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public List<User> readAll() {
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> from = criteria.from(User.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), email));
			TypedQuery<User> typed = em.createQuery(criteria);
			user = typed.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}