package fpt.aptech.t2009m1helloworld.controller.product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProduct extends HttpServlet {

    private ProductModel productModel;
    public CreateProduct() {
        this.productModel = new MySqlProductModel();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException, IOException {
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productModel = new MySqlProductModel();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            String name = req.getParameter("name");
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String description = req.getParameter("description");
            String detail = req.getParameter("detail");
            double price = Double.parseDouble(req.getParameter("price"));
            String thumbnail = req.getParameter("thumbnail");
            int status = Integer.parseInt(req.getParameter("status"));
            Character.UnicodeBlock ProductStatus;
            Product product = Product.ProductBuilder.aProduct()
                    .withName(name)
                    .withCategoryId(categoryId)
                    .withDescription(description)
                    .withDetail(detail)
                    .withThumbnail(thumbnail)
                    .withPrice(price)
                    .build();
            if (product.isValid()) {
                boolean result = productModel.save(product);
                if (result) {
                    resp.sendRedirect("/admin/product/list");
                } else {
                    throw new Exception("Can save product");
                }
            } else {
                req.setAttribute("error", product.getErrors());
                req.setAttribute("product", productModel.findAll());
                req.getRequestDispatcher("/admin/product/create.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
        }

    }
}