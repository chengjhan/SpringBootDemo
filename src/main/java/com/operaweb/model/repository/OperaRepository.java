package com.operaweb.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operaweb.model.entity.Opera;

@Repository
public interface OperaRepository extends JpaRepository<Opera, Integer> {

	List<Opera> findByTitleContaining(String q);

}
