package servlet;


import AcessDB.ServiceAll;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user = ServiceAll.getInstance().getAllUser();
        req.setAttribute("users", user);
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);
    }

}
