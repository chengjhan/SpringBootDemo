package com.operaweb.model.repository.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.repository.OperaRepositoryCustom;

@Repository
public class OperaRepositoryImpl implements OperaRepositoryCustom {

	@Resource
	private EntityManager entityManager;

	@Override
	public List<Opera> findByTitleContainingOrderByTitleOrYear(String q, String s) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Opera> criteriaQuery = criteriaBuilder.createQuery(Opera.class);
		Root<Opera> from = criteriaQuery.from(Opera.class);
		CriteriaQuery<Opera> select = criteriaQuery.select(from);

		if (!"".equals(q)) {
			criteriaQuery.where(criteriaBuilder.like(from.get("title"), "%" + q + "%"));
		}

		switch (s) {
		case "title_asc":
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get("title")));
			break;
		case "title_desc":
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("title")));
			break;
		case "year_asc":
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get("year")));
			break;
		case "year_desc":
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("title")));
			break;
		default:
			break;
		}

		Query query = entityManager.createQuery(select);

		return query.getResultList();
	}

	@Override
	public List<Opera> findByTitleContainingOrderByTitleOrYearPaging(String q, String s, int pageNumber, int pageSize) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Opera> criteriaQuery = criteriaBuilder.createQuery(Opera.class);
		Root<Opera> from = criteriaQuery.from(Opera.class);
		criteriaQuery.select(from);

		// 搜尋
		if (!"".equals(q)) {
			criteriaQuery.where(criteriaBuilder.like(from.get("title"), "%" + q + "%"));
		}

		// 排序
		switch (s) {
		case "title_asc":
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get("title")));
			break;
		case "title_desc":
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("title")));
			break;
		case "year_asc":
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get("year")));
			break;
		case "year_desc":
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("title")));
			break;
		default:
			break;
		}

		Query query = entityManager.createQuery(criteriaQuery);

		// 分頁
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@Override
	public long countByTitleContaining(String q) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Opera> from = criteriaQuery.from(Opera.class);
		criteriaQuery.select(criteriaBuilder.count(from));

		// 搜尋
		if (!"".equals(q)) {
			criteriaQuery.where(criteriaBuilder.like(from.get("title"), "%" + q + "%"));
		}

		Query query = entityManager.createQuery(criteriaQuery);

		return (long) query.getSingleResult();
	}

}
