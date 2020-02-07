package servlet;

import AcessDB.ServiceAll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
//    private ServiceClient serv;
//
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        serv = new ServiceClient();
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        ServiceAll.getInstance().deletUser(id);
        response.sendRedirect("http://localhost:8080");
    }

}
