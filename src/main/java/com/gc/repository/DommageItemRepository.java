package com.gc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gc.entity.DommageItem;

import java.util.List;

@Repository
public interface DommageItemRepository extends JpaRepository<DommageItem, Long> {
	List<DommageItem> findAllByEirId(Long id);
}

