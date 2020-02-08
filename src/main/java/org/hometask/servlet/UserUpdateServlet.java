package org.hometask.servlet;

import org.hometask.model.User;
import org.hometask.service.UserService;
import org.hometask.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {

    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImp.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        List<User> newUser = new ArrayList<>();
        newUser.add(serv.getUserById(id));
        req.setAttribute("user", newUser);
        getServletContext().getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User newUser = new User();
        newUser.setId(Long.parseLong(req.getParameter("id")));
        newUser.setEmail(req.getParameter("email"));
        newUser.setName(req.getParameter("name"));
        newUser.setSurname(req.getParameter("surname"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setBirthday(req.getParameter("date"));
        serv.updateUser(newUser);
        resp.sendRedirect("/");
    }
}
