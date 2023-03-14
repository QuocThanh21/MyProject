package com.demoqa.pages;

import com.demoqa.pages.shared.DataTable;
import com.demoqa.pages.shared.SearchBox;
import java.util.ArrayList;

public class BookStorePage extends BasePage{
    private DataTable booksTable;
    private SearchBox searchBox;

    /** ---------------------- Constructor ------------------------ */
    public BookStorePage() {
        booksTable = new DataTable();
        searchBox = new SearchBox();
    }

    /** ---------------------- Methods ------------------------ */
    public void inputSearchBox(String keyword) {
        searchBox.inputSearchBox(keyword);
    }

    // Define method to verify that title of books in search results matches with search keyword
    public boolean isMatchedSearchResults(String keyword) {
        return booksTable.isMatchedSearchResults(keyword);
    }

    public void clickTitleBookLink() {
        booksTable.clickTitleBookLink();
    }

    public boolean isBookInListTitlesOfBooks(ArrayList<String> listTitlesOfBooks, String nameOfBook) {
        for (String title : listTitlesOfBooks) {
            if (title.equals(nameOfBook)) {
                return true;
            }
        }
        return false;
    }
}
