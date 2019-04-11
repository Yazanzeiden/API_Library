package com.eclipslink.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.eclipselink.entity.books;

public class bookAction {

	public List<books> getAllBooks() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Api");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("Select e FROM books e");
		@SuppressWarnings("unchecked")
		List<books> list = query.getResultList();

		return list;

	}

	public String insertIntoLibrary(books book) {
		if(book != null) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Api");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		books insertBook = new books();
		insertBook.setId(book.getId());
		insertBook.setNamee(book.getNamee());
		insertBook.setAuthor(book.getAuthor());
		insertBook.setQuantity(book.getQuantity());
		insertBook.setPrice(book.getPrice());
		entitymanager.persist(insertBook);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
		return "done";
		}else {
			return "faild";}
		
		
		
		
	}
	
	public String removeFromLibrary(books book) {
		if(book.getId()>0) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Api");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		books removeBook = new books();
		removeBook = entitymanager.find( books.class,book.getId());
	      entitymanager.remove( removeBook );
	      entitymanager.getTransaction( ).commit( );
	      entitymanager.close( );
	      emfactory.close( );
		return "remove done successfuly ";
		}else {
			return "faild";}	
	}
	
	public String updateBooks(books book) {
		if(book.getId()>0) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Api");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		books updateBook = new books();
		updateBook = entitymanager.find( books.class,book.getId());
		updateBook.setNamee(book.getNamee());
		updateBook.setAuthor(book.getAuthor());
		updateBook.setQuantity(book.getQuantity());
		updateBook.setPrice(book.getPrice());
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
		return "update done successfuly ";
		}else {
			return "faild";}	
	}
	
	
	

}
