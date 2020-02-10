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

@WebServlet("/")
public class LoginUserServlet extends HttpServlet {
    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/UserLoginPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User newUser = serv.getUserByEmail(email);
        if (password.equals(newUser.getPassword())) {
            req.getSession().setAttribute("role", newUser.getRole());
            if (newUser.getRole().equals("admin")) {
                req.getSession().setAttribute("user", newUser.getId());
                resp.sendRedirect("/admin");
            } else {
                req.getSession().setAttribute("user", newUser.getId());
                resp.sendRedirect("/user");
            }
        } else {
            req.setAttribute("status", "Не верный логин или пароль");
            getServletContext().getRequestDispatcher("/UserLoginPage.jsp").forward(req, resp);
        }

    }
}
