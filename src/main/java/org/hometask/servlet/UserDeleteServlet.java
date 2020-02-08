package org.hometask.servlet;

import org.hometask.service.UserService;
import org.hometask.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {

    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImp.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        serv.deletUser(id);
        response.sendRedirect("/");
    }

}
