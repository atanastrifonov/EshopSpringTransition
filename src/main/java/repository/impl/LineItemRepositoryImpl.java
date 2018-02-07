package repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.LineItem;
import repository.capi.LineItemRepository;

@Repository
@Transactional
public class LineItemRepositoryImpl implements LineItemRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public LineItem getLineItemById(Integer id) {
		return em.find(LineItem.class, id);
	}

	@Override
	public int addLineItem(LineItem lineItem) {
		em.persist(lineItem);
		em.flush();
		return lineItem.getId();
	}

}
