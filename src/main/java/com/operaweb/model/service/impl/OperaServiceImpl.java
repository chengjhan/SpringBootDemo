package com.operaweb.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.repository.OperaRepository;
import com.operaweb.model.service.OperaService;
import com.operaweb.model.viewmodel.Pagination;

@Service
public class OperaServiceImpl implements OperaService {

	@Autowired
	private OperaRepository operaRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Opera> list() {

		return operaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Opera findById(Integer id) {

		return operaRepository.findById(id).orElse(new Opera());
	}

	@Transactional
	@Override
	public Opera create(Opera opera) {

		return operaRepository.saveAndFlush(opera);
	}

	@Transactional
	@Override
	public Opera edit(Opera opera) {

		return operaRepository.saveAndFlush(opera);
	}

	@Transactional
	@Override
	public void delete(Integer id) {

		operaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Opera> search(String q) {

		return operaRepository.findByTitleContaining(q);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Opera> search(String q, String s) {

		return operaRepository.findByTitleContainingOrderByTitleOrYear(q, s);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination<Opera> search(String q, String s, int pageNumber, int pageSize) {

		Pagination<Opera> pagination = new Pagination<Opera>();
		pagination.setList(operaRepository.findByTitleContainingOrderByTitleOrYearPaging(q, s, pageNumber, pageSize));
		pagination.setCount(operaRepository.countByTitleContaining(q));
		pagination.setPageNumber(pageNumber);
		pagination.setPageSize(pageSize);

		return pagination;
	}

}
