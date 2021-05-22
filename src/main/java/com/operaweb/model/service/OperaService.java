package com.operaweb.model.service;

import java.util.List;

import com.operaweb.model.entity.Opera;

public interface OperaService {

	List<Opera> list();

	Opera findById(Integer id);

}
