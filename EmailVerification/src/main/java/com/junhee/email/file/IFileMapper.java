package com.junhee.email.file;

import com.junhee.email.model.Item;

public interface IFileMapper {

	public Item Save(Item item);
	
	public Item FindById(Long id);
	
}
