package fpt.aptech.t2009m1helloworld.controller.product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListProduct extends HttpServlet {
    private ProductModel productModel;

    public ListProduct() {
        this.productModel = new MySqlProductModel();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", productModel.findAll());
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
