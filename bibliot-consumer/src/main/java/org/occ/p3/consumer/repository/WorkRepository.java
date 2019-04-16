package org.occ.p3.consumer.repository;

import java.util.List;

import org.occ.p3.model.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work,Integer> {

	public List<Work> findByAuthorContaining(String author);
	                  
}
