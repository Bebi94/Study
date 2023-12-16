package com.mykyong.common.models.dao;

import java.util.List;


import com.mykyong.common.models.entity.Book;

public interface BookDAO {
      void createBook(Book book);
      void deleteBook(int id);
      void updateBook(int id, String title);
      Book findBookByID(int id);
      List<Book> showAllBook();
      List<Book> showBooksBySize(Integer page_size, Integer page_num);
}
