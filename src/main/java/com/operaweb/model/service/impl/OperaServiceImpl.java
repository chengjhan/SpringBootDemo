package com.operaweb.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.repository.OperaRepository;
import com.operaweb.model.service.OperaService;

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

}
