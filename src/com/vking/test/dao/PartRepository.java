package com.vking.test.dao;

import com.vking.test.data.Part;

public interface PartRepository {
	void save(Part part);

	Part findByName(String name);
	
	void genericNewPart(Part part);
}
