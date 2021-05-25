package com.operaweb.model.service;

import java.util.List;

import com.operaweb.model.entity.Opera;

public interface OperaService {

	List<Opera> list();

	Opera findById(Integer id);

	Opera create(Opera opera);

	Opera edit(Opera opera);

	void delete(Integer id);

	List<Opera> search(String q);

}
