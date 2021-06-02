package com.operaweb.model.service;

import java.util.List;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.viewmodel.Pagination;

public interface OperaService {

	List<Opera> list();

	Opera findById(Integer id);

	Opera create(Opera opera);

	Opera edit(Opera opera);

	void delete(Integer id);

	List<Opera> search(String q);

	List<Opera> search(String q, String s);

	Pagination<Opera> search(String q, String s, int pageNumber, int pageSize);

}
