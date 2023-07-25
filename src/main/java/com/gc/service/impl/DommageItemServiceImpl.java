package com.gc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gc.entity.DommageItem;
import com.gc.repository.DommageItemRepository;
import com.gc.service.DommageItemService;

@Service
public class DommageItemServiceImpl implements DommageItemService {

	@Autowired
	DommageItemRepository itemRepository;

	@Override
	public DommageItem getById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public DommageItem addItem(DommageItem item) {
		return itemRepository.save(item);
	}

	@Override
	public DommageItem updateItem(DommageItem item) {
		return itemRepository.save(item);
	}

	@Override
	public List<DommageItem> getAll() {
		return itemRepository.findAll();
	}

	@Override
	public void deletById(Long id) {
		itemRepository.deleteById(id);
		
	}

	@Override
	public List<DommageItem> getAllByEirId(Long id) {
		return itemRepository.findAllByEirId(id);
	}


}
