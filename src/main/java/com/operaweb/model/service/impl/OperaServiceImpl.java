package com.operaweb.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operaweb.model.entity.Opera;
import com.operaweb.model.repository.OperaRepository;
import com.operaweb.model.service.OperaService;

@Service
public class OperaServiceImpl implements OperaService {

	@Autowired
	private OperaRepository operaRepository;

	@Override
	public List<Opera> list() {

		return operaRepository.findAll();
	}

	@Override
	public Opera findById(Integer id) {

		return operaRepository.findById(id).orElse(new Opera());
	}

}
