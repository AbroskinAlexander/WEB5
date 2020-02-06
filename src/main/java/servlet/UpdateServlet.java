package servlet;

import AcessDB.ServiceClientHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
//      private ServiceClient serv;
//
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        serv = new ServiceClient();
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User newUser = new User();
        newUser.setId(Long.parseLong(req.getParameter("id")));
        newUser.setName(req.getParameter("name"));
        newUser.setSurname(req.getParameter("surname"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setBirthday(req.getParameter("date"));
        ServiceClientHibernate.getInstance().updateUser(newUser);
        resp.sendRedirect("http://localhost:8080");
    }
}
