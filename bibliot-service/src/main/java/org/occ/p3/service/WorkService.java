package org.occ.p3.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.occ.p3.model.Book;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;

public interface WorkService {

	public List<Work> findByAuthor(String author);

	public Work getWorkById(Integer workId);
}
