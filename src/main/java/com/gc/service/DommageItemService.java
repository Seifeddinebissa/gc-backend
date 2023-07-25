package com.gc.service;

import java.util.List;

import com.gc.entity.DommageItem;

public interface DommageItemService {

	DommageItem getById(Long id);

	DommageItem addItem(DommageItem item);

	DommageItem updateItem(DommageItem item);

	List<DommageItem> getAll();

	void deletById(Long id);
	List<DommageItem> getAllByEirId(Long id);

}