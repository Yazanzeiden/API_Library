package com.eclipselink.service;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eclipselink.entity.books;
import com.eclipslink.dao.bookAction;

@Path("/UserService")

public class CreateBooks {
	bookAction bookActions = new bookAction();

	@GET
	@Path("/getUsers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<books> getUsers() {
		return bookActions.getAllBooks();
	}

	@GET
	@Path("/insertBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public String putBooksIntoLibrary(books book) {
		if (book != null) {
			return bookActions.insertIntoLibrary(book);
		} else {
			return "faild";
		}
	}

	@GET
	@Path("/removeBook")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeBookeFromLibrary(books book) {
		if (book != null) {
			return bookActions.removeFromLibrary(book);
		} else {
			return "faild";
		}
	}

	@GET
	@Path("/updateBook")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateBookeFromLibrary(books book) {
		if (book != null) {
			return bookActions.updateBooks(book);
		} else {
			return "faild";
		}
	}
}
