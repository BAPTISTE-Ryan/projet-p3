package org.occ.p3.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface BorrowService {


	 public Boolean borrowBook(Integer workId, Integer memberId);
	 public Boolean extendBorrow(Integer borrowId);
	 public Boolean endBorrow(Integer borrowId);

//	public Works getBookById(Integer workId);
//
//	public Works getOriginWork();
//
//    public Works getBookList (Integer workId);
//
//    public Book findAvailableBook (Integer bookId);

}
