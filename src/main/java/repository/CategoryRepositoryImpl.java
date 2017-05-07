package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Category;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public List<Category> findAllCategories() {
		EntityManager em = emf.createEntityManager();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Category.class));
        return em.createQuery(cq).getResultList();
	}

}
