package com.manish.interview.hackerearth.salesforce;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

class BookCollection{

    static Map<Book,Integer> availableBookCollection = new ConcurrentHashMap<>();
    static List<Book> borrowedBookCollection = new ArrayList<>();
    static {
        availableBookCollection.put(new Book(121,"book1","author2","publication2",BookCategory.CIVIL),3);
        availableBookCollection.put(new Book(122,"book2","author1","publication1",BookCategory.CIVIL),3);
        availableBookCollection.put(new Book(123,"book3","author3","publication2",BookCategory.CIVIL),3);

    }

    public static void borrowBook(Book book) throws BookeUnavailableException {
        Integer availableCount = availableBookCollection.getOrDefault(book,0);
        if(availableCount<= 0 ){
            throw new BookeUnavailableException("Book is already boorowed");
        }
        availableBookCollection.put(book,availableCount-1);
    }

    public static void returnBook(Book book) {
        Integer availableCount = availableBookCollection.getOrDefault(book,0);
        availableBookCollection.put(book,availableCount+1);
    }

    public static boolean findBook(String bookName){
        Stream<Map.Entry<Book, Integer>> entryStream = availableBookCollection.entrySet().stream().filter(x -> x.getKey().getName().equals(bookName));
        return entryStream.findFirst().get().getValue()>0;
    }

    public static boolean findBookByCategory(String bookName){
        Stream<Map.Entry<Book, Integer>> entryStream = availableBookCollection.entrySet().stream().filter(x -> x.getKey().getName().equals(bookName));
        return entryStream.findFirst().get().getValue()>0;
    }

    public static boolean findBookByAuthor(String authorName){
        Stream<Map.Entry<Book, Integer>> entryStream = availableBookCollection.entrySet().stream().filter(x -> x.getKey().getAuthor().equals(authorName));
        return entryStream.findFirst().get().getValue()>0;
    }


}
class Book{

    private int isbn;
    private String name;
    private String author;
    private String publication;
    private BookCategory bookCategory;

    public int getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public Book(int isbn, String name, String author, String publication, BookCategory bookCategory) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.bookCategory = bookCategory;
    }


}

public class Solution {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
