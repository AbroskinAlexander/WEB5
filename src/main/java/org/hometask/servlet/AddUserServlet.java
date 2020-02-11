package org.hometask.servlet;

import org.hometask.service.UserService;
import org.hometask.service.UserServiceImpl;
import org.hometask.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImpl.getInstance();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String birthday = req.getParameter("date");
        String role = req.getParameter("role");
        User newUser = new User(email,name, surname, password, birthday,role);
        serv.addUser(newUser);
        resp.sendRedirect("/admin");
    }

}
