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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class InfoUserServlet extends HttpServlet {

    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = (Long) req.getSession().getAttribute("userId");
        List<User> user = new ArrayList<>();
        user.add(serv.getUserById(id));
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/UserUpdateUserPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User updateUser = new User();
        updateUser.setId(Long.parseLong(req.getParameter("id")));
        updateUser.setEmail(req.getParameter("email"));
        updateUser.setName(req.getParameter("name"));
        updateUser.setSurname(req.getParameter("surname"));
        updateUser.setPassword(req.getParameter("password"));
        updateUser.setBirthday(req.getParameter("date"));
        updateUser.setRole(req.getParameter("role"));
        serv.updateUser(updateUser);
        resp.sendRedirect("/user");
    }
}
