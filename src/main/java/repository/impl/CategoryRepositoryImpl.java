package repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Category;
import repository.capi.CategoryRepository;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceContext
	private EntityManager em;

	public static final String DELETED_CATEGORY_NAME = "Deleted";

	// TODO : the em.refresh here is due to updating the product from the backOffice.
	// In theory - an optimisation is possible by refreshing the 2 affected categories in the moment of productUpdate.
	@Override
	public Category getCategoryById(Short id) {
		Category category = em.find(Category.class, id);
		em.refresh(category);
		return category;
	}

	@Override
	public List<Category> findAllCategories() {
		CriteriaQuery<Category> cq = em.getCriteriaBuilder().createQuery(Category.class);
		cq.select(cq.from(Category.class));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findStorefrontCategories() {
		String theQuery = "SELECT c FROM Category c WHERE NOT c.name = :name";
		return em.createQuery(theQuery).setParameter("name", DELETED_CATEGORY_NAME).getResultList();
	}
}
