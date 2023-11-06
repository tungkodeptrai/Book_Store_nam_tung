/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.implement.BookDAO;
import dal.implement.CategoriesDAO;
import entity.Books;
import entity.Categories;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author TNO
 */
@MultipartConfig
public class DashboardServlet extends HttpServlet {

    BookDAO bookDAO;
    CategoriesDAO categoryDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        bookDAO = new BookDAO();
        categoryDAO = new CategoriesDAO();
        // find list book
        List<Books> list = bookDAO.findAll();
        List<Categories> listCategory = categoryDAO.findAll();
        //
        // set into session
        session.setAttribute("listBook", list);
        session.setAttribute("listCategories", listCategory);
        //move on to dashboard.jsp
        request.getRequestDispatcher("../views/admin/dashboard/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // set utf8 to searth with vietnam languge
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // get action 
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");

        switch (action) {
            case "add":
                addBook(request);
                break;
            case "delete":
                delebeBook(request);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("dashboard");

    }

    private void addBook(HttpServletRequest request) {
        // create oject bookDAO
        bookDAO = new BookDAO();
        // get information
        // get name
        String name = request.getParameter("name");
        // get author
        String author = request.getParameter("author");
        // get price
        int price = Integer.parseInt(request.getParameter("price"));
        // get quantity
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        // get description
        String description = request.getParameter("description");
        //get categoryId
        int categoryId = Integer.parseInt(request.getParameter("category"));

        String imagePath = null;

        try {
            Part part = request.getPart("image");

            //  line save imga
            String path = request.getServletContext().getRealPath("/image");
            File dir = new File(path);
            // if not have path -> auto create path
            if (!dir.exists()) {
                dir.mkdir();
            }
            File image = new File(dir, part.getSubmittedFileName());
            part.write(image.getAbsolutePath());
            imagePath = "/BookStore/images/" + image.getName();

        } catch (Exception e) {

        }
        // create oject book
        Books book = Books.builder()
                .name(name)
                .author(author)
                .price(price)
                .quantity(quantity)
                .description(description)
                .categoryId(categoryId)
                .image(imagePath)
                .build();

        bookDAO.insert(book);

    }

    private void delebeBook(HttpServletRequest request) {
        bookDAO = new BookDAO();
        // getinformation
        int id = Integer.parseInt(request.getParameter("id"));
        // delete book by id
        bookDAO.deteteById(id);
    }

}
