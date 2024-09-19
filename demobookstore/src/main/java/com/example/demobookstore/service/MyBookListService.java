package com.example.demobookstore.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demobookstore.model.*;
import com.example.demobookstore.dao.*;

@Service
public class MyBookListService {
	
	@Autowired
	private static MyBookListRepository mybook;
	
	public static void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public static List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}

