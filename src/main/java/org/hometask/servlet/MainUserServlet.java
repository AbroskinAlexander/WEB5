package org.hometask.servlet;


import org.hometask.model.User;
import org.hometask.service.UserService;
import org.hometask.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class MainUserServlet extends HttpServlet {

    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user = serv.getAllUser();
        req.setAttribute("users", user);
        getServletContext().getRequestDispatcher("/UserMainPage.jsp").forward(req, resp);
    }

}
