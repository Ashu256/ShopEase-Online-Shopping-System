package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String json = "["
                + "{\"id\":1,\"name\":\"iPhone 15\",\"price\":80000},"
                + "{\"id\":2,\"name\":\"Laptop\",\"price\":60000},"
                + "{\"id\":3,\"name\":\"Shoes\",\"price\":3000}"
                + "]";

        out.print(json);
    }
}
