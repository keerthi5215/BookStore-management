package com.example.demobookstore.dao;
import com.example.demobookstore.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList,Integer>{

}



