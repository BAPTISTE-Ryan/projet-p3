package org.occ.p3.service;

import java.util.List;

import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService{

	@Autowired
	WorkRepository workrepository;
	
	public List<Work> findByAuthor(String author) {
		return workrepository.findByAuthorContaining(author);
		 
	}

	public Work getWorkById(Integer workId) {
		
		Work workGotFromConsumer = workrepository.findById(workId).get();
		return workGotFromConsumer;
	}
	
	

}
