package com.demoqa.testdatas;

import com.demoqa.models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookTestData {
    public List<Book> bookAlreadyInCollection;
    public List<String> isbnListOfBookToAdd;
    public String isbnOfBookToDelete;
    public String isbnOfBookIsReplaced;
    public Book bookToReplace;

    public ArrayList<String> getIsbnListOfBookAlreadyInCollection() {
        ArrayList<String> listIsbnOfBook = new ArrayList<>();
        for (Book book : bookAlreadyInCollection) {
            listIsbnOfBook.add(book.isbn);
        }
        return listIsbnOfBook;
    }
}
