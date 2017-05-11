package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Category;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Category getCategoryById(Short id) {
		return em.find(Category.class, id);
	}
	
	@Override
	public List<Category> findAllCategories() {
		CriteriaQuery<Category> cq = em.getCriteriaBuilder().createQuery(Category.class);
        cq.select(cq.from(Category.class));
        return em.createQuery(cq).getResultList();
	}
}
