package org.occ.p3.consumer.repository;


import java.util.List;

import org.occ.p3.model.Book;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends CrudRepository<Book, Integer>{

	 
	
	
}
