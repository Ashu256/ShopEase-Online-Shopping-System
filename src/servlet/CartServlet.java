package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String item = request.getParameter("item");
        cart.add(item);

        session.setAttribute("cart", cart);

        response.getWriter().print("added");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (cart == null) {
            out.print("[]");
        } else {
            out.print(cart.toString());
        }
    }
}
