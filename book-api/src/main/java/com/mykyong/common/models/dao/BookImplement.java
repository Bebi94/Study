package com.mykyong.common.models.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mykyong.common.models.entity.Book;

import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
public class BookImplement implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   

    @Override
    public void createBook(Book book) {
        String sql = "INSERT INTO BOOKS (title, author, yearOfRelease) VALUES(?,?,?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getYearOfRelease());
        throw new UnsupportedOperationException("Unimplemented method 'createBook'");
    }

    @Override
    public void deleteBook(int id) {
        String sql = "DELETE FROM BOOKS WHERE id = ?";
        jdbcTemplate.update(sql, id);
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    @Override
    public void updateBook(int id, String newTitle) {
        String sql = "UPDATE BOOKS SET title=? WHERE id=?";
        jdbcTemplate.update(sql, newTitle, id);
        throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }


    //vì sao lên https://mkyong.com/spring/spring-jdbctemplate-querying-examples/ thì khi mapResult lại yêu cầu constructor trong khi điều kiện sử dụng spring là ko có constructor
    @Override
    public Book findBookByID(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM BOOKS WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> new Book()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .yearOfRelease(rs.getInt("yearOfRelease")));
    }

    @Override
    public List<Book> showAllBook() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM BOOKS";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Book()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .yearOfRelease(rs.getInt("yearOfRelease")));
    }


    //Ban đầu parameter là int sau đó báo lỗi đổi thành Integer? nhưng vẫn bị lỗi 
    //HTTP ERROR 500 javax.servlet.ServletException: org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.NullPointerException
    @Override
    public List<Book> showBooksBySize(Integer page_size, Integer page_num) {
       
        String sql="select * from books limit " +page_size+ " offset " + ((page_num-1)*page_size);
       
       return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Book()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .yearOfRelease(rs.getInt("yearOfRelease")));

        
    }

}
