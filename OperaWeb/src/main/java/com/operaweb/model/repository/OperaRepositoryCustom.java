package com.operaweb.model.repository;

import java.util.List;

import com.operaweb.model.entity.Opera;

public interface OperaRepositoryCustom {

	List<Opera> findByTitleContainingOrderByTitleOrYear(String q, String s);

	List<Opera> findByTitleContainingOrderByTitleOrYearPaging(String q, String s, int pageNumber, int pageSize);

	long countByTitleContaining(String q);

}
