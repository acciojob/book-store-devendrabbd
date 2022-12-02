package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    Map<Integer, Book> hm;
    static int id=0;
    public BookRepository(){
        hm=new HashMap<>();
    }

    public Book save(Book book){
        id++;
        book.setId(id);
        hm.put(book.getId(), book);
        return book;
    }

    public Book findBookById(int id){
        return hm.get(id);
    }

    public List<Book> findAll(){
        List<Book> ans=new ArrayList<>();
        for(Integer i:hm.keySet()) ans.add(hm.get(i));
        return ans;
    }

    public void deleteBookById(int id){
        for(Integer i:new ArrayList<>(hm.keySet())){
            if(i==id){
                hm.remove(i);
                break;
            }
        }
        return;
    }

    public void deleteAll(){
        hm.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> ans=new ArrayList<>();
        for(Integer i:hm.keySet()){
            if(hm.get(i).getAuthor().equals(author)) ans.add(hm.get(i));
        }
        return ans;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> ans=new ArrayList<>();
        for(Integer i:hm.keySet()){
            if(hm.get(i).getGenre().equals(genre)) ans.add(hm.get(i));
        }
        return ans;
    }
}