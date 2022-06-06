package fpt.aptech.t2009m1helloworld.controller.shoppingcart;

import fpt.aptech.t2009m1helloworld.controller.product.MySqlProductModel;
import fpt.aptech.t2009m1helloworld.controller.product.Product;
import fpt.aptech.t2009m1helloworld.controller.product.ProductModel;
import fpt.aptech.t2009m1helloworld.entity.ShoppingCart;
import fpt.aptech.t2009m1helloworld.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubCartServlet extends HttpServlet {
    private ProductModel productModel;

    public SubCartServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            Integer quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = productModel.findById(productId);
            if (product == null) {
                resp.getWriter().println("Product is not found!");
                return;
            }
            if (quantity <= 0) {
                resp.getWriter().println("Invalid quantity!");
                return;
            }
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
            shoppingCart.sub(product, quantity);
            shoppingCartHelper.saveCart(shoppingCart);
            resp.sendRedirect("/shopping-cart/get");
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}