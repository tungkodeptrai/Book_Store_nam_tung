/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import static constant.constant.RECORD_PER_PAGE;
import dal.GenericDAO;
import entity.Books;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author TNO
 */
public class BookDAO extends GenericDAO<Books> {

    public static void main(String[] args) {
        for (Books books : new BookDAO().findByPage(1)) {
            System.out.println(books);
        }
    }

    @Override
    public List<Books> findAll() {
        return queryGenericDAO(Books.class);
    }

    public List<Books> searchContainName(String property, String keyword) {
        String sql = "select * from Books\n"
                + "where " + property + " like ? ";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name", "%" + keyword + "%");
        return queryGenericDAO(Books.class, sql, parameterMap);
    }

    public List<Books> searchByProperty(String property, String id) {
        String sql = "select * from Books\n"
                + "where " + property + " = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("categoryId", id);
        return queryGenericDAO(Books.class, sql, parameterMap);

    }

    public List<Books> findByPage(int page) {
        String sql = "select * from Books\n"
                + "Order by [id]\n"
                + "offset ? ROWS \n"
                + "Fetch next ? ROWS ONLY";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("offset", (page - 1) * RECORD_PER_PAGE);
        parameterMap.put("fetch next", constant.constant.RECORD_PER_PAGE);
        return queryGenericDAO(Books.class, sql, parameterMap);
    }

    public int findTotalRecord() {
        return findTotalRecordGenericDAO(Books.class);
    }

    public int findTotalRecordByCategoryId(String categoryId) {
        String sql = "select count(*) from Books\n"
                + "where categoryId = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("categoryId", categoryId);
        return findTotalRecordGenericDAO(Books.class, sql, parameterMap);
    }

    public List<Books> findByCateIdAndPage(String categoryId, int page) {
        String sql = "select * from Books\n"
                + "where categoryId = ?\n"
                + "order by  id\n"
                + "offset ? rows\n"
                + "fetch next ? rows only";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("categoryId", categoryId);
        parameterMap.put("offset", (page - 1) * constant.constant.RECORD_PER_PAGE);
        parameterMap.put("fetch next", constant.constant.RECORD_PER_PAGE);
        return queryGenericDAO(Books.class, sql, parameterMap);

    }

    public int findTotalRecordByName(String keyword) {
        String sql = "select count(*) from Books\n"
                + "where name like ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name", "%" + keyword + "%");
        return findTotalRecordGenericDAO(Books.class, sql, parameterMap);
    }

    public List<Books> findByNameAndPage(String keyword, int page) {
        String sql = "select * from Books\n"
                + "where name like ?\n"
                + "order by  id\n"
                + "offset ? rows\n"
                + "fetch next ? rows only";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name", "%" + keyword + "%");
        parameterMap.put("offset", (page - 1) * constant.constant.RECORD_PER_PAGE);
        parameterMap.put("fetch next", constant.constant.RECORD_PER_PAGE);
        return queryGenericDAO(Books.class, sql, parameterMap);
    }

    @Override
    public int insert(Books book) {
        return insertGenericDAO(book);
    }

    public void deteteById(int id) {
        String sql = "DELETE FROM [dbo].[Books]\n"
                + "      WHERE id = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", id);
        updateGenericDAO(sql, parameterMap);
    }

}
