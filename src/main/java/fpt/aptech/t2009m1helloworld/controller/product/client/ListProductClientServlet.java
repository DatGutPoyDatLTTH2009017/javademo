package fpt.aptech.t2009m1helloworld.controller.product.client;

import fpt.aptech.t2009m1helloworld.controller.product.MySqlProductModel;
import fpt.aptech.t2009m1helloworld.controller.product.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListProductClientServlet extends HttpServlet {
    private ProductModel productModel;

    public ListProductClientServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", productModel.findAll());
        req.getRequestDispatcher("/client/products/list.jsp").forward(req, resp);
    }
}
