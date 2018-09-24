package com.manish.interview.hackerearth.salesforce;

public class BookeUnavailableException extends Exception {
    public BookeUnavailableException(String book_is_already_boorowed) {
        super(book_is_already_boorowed);
    }
}
