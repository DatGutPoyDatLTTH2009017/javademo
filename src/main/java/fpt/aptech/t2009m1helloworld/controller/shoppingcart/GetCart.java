package fpt.aptech.t2009m1helloworld.controller.shoppingcart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/fpt/aptech/t2009m1helloworld/controller/product/client/shopping-cart/demo.jsp").forward(req, resp);
    }
}