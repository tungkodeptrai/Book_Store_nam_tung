/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.GenericDAO;
import dal.implement.BookDAO;
import dal.implement.CategoriesDAO;
import entity.Books;
import entity.Categories;
import entity.PageControl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TNO
 */
public class HomeServlet extends HttpServlet {

    GenericDAO<Books> bookDAO;
    GenericDAO<Categories> categoriesDAO;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // set utf8 to searth with vietnam languge
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        // create DAO
        categoriesDAO = new CategoriesDAO();
        bookDAO = new BookDAO();
        
        // create session
        HttpSession session = request.getSession();
        
        // create oject page control
        PageControl pageControl = new PageControl();
        List<Categories> listCategories = categoriesDAO.findAll();
        
        //pagination 
        List<Books> listBook = pagination(request, pageControl);


        session.setAttribute("listBook", listBook);
        session.setAttribute("listCategories", listCategories);
        request.setAttribute("pageControl", pageControl);
        //System.out.println(pageControl);

        request.getRequestDispatcher("views/user/homePage/homePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    public void searchByName(HttpServletRequest request, HttpServletResponse response) {

        String keyword = request.getParameter("keyword");

        BookDAO bookDAO = new BookDAO();

        List<Books> list = bookDAO.searchContainName("name", keyword);
        // creat session

        HttpSession session = request.getSession();
        // set data into session
        session.setAttribute("listBook", list);
    }

    private void searchByCategory(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        BookDAO bookDAO = new BookDAO();

        List<Books> list = bookDAO.searchByProperty("categoryId", id);
        // creat session

        HttpSession session = request.getSession();
        // set data into session
        session.setAttribute("listBook", list);
    }

    private List<Books> pagination(HttpServletRequest request,
            PageControl pageControl) {
        String pageRaw = request.getParameter("page");
        BookDAO bookDAO = new BookDAO();
        int page;
        try {
            page = Integer.parseInt(pageRaw);
        } catch (Exception e) {
            page = 1;
        }
        
        // get action 
        String action = request.getParameter("action") == null ? "defaultFindAll" : request.getParameter("action");
        
        int totalRecord = 0;
        List<Books> listBook = null;
        
        switch (action) {
            case "search":
                // find how many record
                String keyword = request.getParameter("keyword");
                totalRecord = bookDAO.findTotalRecordByName(keyword);
                listBook = bookDAO.findByNameAndPage(keyword, page);              
                // return listBooks
                pageControl.setUrlPattern("Home?action=search&keyword=" + keyword + "&");
                break;
                
            case "category":
                String categoryId = request.getParameter("categoryId");                
                totalRecord = bookDAO.findTotalRecordByCategoryId(categoryId);               
                listBook = bookDAO.findByCateIdAndPage(categoryId, page);               
                pageControl.setUrlPattern("Home?action=category&categoryId=" + categoryId + "&");
                break;
            default:               
                // paggination at home page
                
                // find total record
                totalRecord = bookDAO.findTotalRecord();
                //search list books at page that user select 
                listBook = bookDAO.findByPage(page);               
                pageControl.setUrlPattern("Home?");

        }
        // search how many records and listbook by name
        
        // find total pages 
        int totalPage = (totalRecord % constant.constant.RECORD_PER_PAGE == 0
        ? (totalRecord / constant.constant.RECORD_PER_PAGE) : (totalRecord / constant.constant.RECORD_PER_PAGE + 1));
        // set data into pageControl
        pageControl.setPage(page);
        pageControl.setTotalPage(totalPage);
        pageControl.setTotalRecord(totalRecord);

        return listBook;
        
    }

}
