package org.occ.p3.service;

import org.occ.p3.consumer.repository.BookRepository;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.UserRepository;
import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Book;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	WorkRepository workRepository;
	@Autowired
	BorrowRepository borrowRepository;
	@Autowired
	BookRepository bookRepository;

	public Boolean borrowBook(Integer workId, Integer userId) {

		Boolean toReturn = false;

		// Recuperer le Work dont on connait l'ID (creer work repository)
		Work myWorkGot = workRepository.findById(workId).get();
		System.out.println("Id" + myWorkGot.getId() + " : " + myWorkGot.getTitle());

		// recuperer la liste dans myborrowgot
		List<Book> bookList = myWorkGot.getBook();
		System.out.println("booklistsize :" + bookList.size() + " " + bookList.get(0).getId().toString());

		// On parcours la bookList
		for (Book result : bookList) {
			if (result.isAvailable()) {
				System.out.println("isAvailable");
				Borrow borrowToSave = new Borrow();
				borrowToSave.setBook(result);
				// on simule user1 pour test
				User user = userRepository.findById(userId).get();
				// On associe le user a borrow
				borrowToSave.setUserBorrowingId(user.getId());
				borrowToSave.setStartBorrowDate(new Date());
				// mettre le statut Ã  jour
				borrowToSave.setStatus("ENCOURS");
				// Save le borrow dans le repository
				borrowRepository.save(borrowToSave);
				// Indique que le livre n'est plus disponible et on sauvegarde dans le
				// bookRepository
				result.setAvailable(false);
				bookRepository.save(result);
				user.getBorrow().add(borrowToSave);
				userRepository.save(user);
				toReturn = true;
				break;
			}

		}
		return toReturn;
	}

	public Boolean extendBorrow(Integer borrowId) {
		
		/*
		valeur de retour a false
		recupérer le borrow dont on connait lId
		modifie le statut du borrow 
		recalculer la date de restitution
		sauvegarder en base
		met la valeur de retour a true  */
		Boolean toReturn = false;

		
		Borrow borrow = borrowRepository.findById(borrowId).get();
		if(!borrow.getStatus().equals("EXTENDED") && !borrow.getStatus().equals("TERMINE")) {
		borrow.setExtended(true);
		borrow.setStatus("EXTENDED");
		//borrow.setEndBorrowDate(new Date());      should set a borrow date + 14 more days 
		borrowRepository.save(borrow);
		toReturn = true;
		}
		 
		return toReturn;
	}

	public Boolean endBorrow(Integer borrowId) {
		Boolean toReturn = false;

		
		
		Borrow borrow = borrowRepository.findById(borrowId).get();
		if(!borrow.getStatus().equals("TERMINE")) {
		borrow.setStatus("TERMINE");
		borrow.setEndBorrowDate(new Date());
		borrow.getBook().setAvailable(true); 
		bookRepository.save(borrow.getBook());
		borrowRepository.save(borrow);
		toReturn = true;
		}
		 
		return toReturn;
	}
}
