package fpt.aptech.t2009m1helloworld.controller.category;

import fpt.aptech.t2009m1helloworld.entity.Category;
import fpt.aptech.t2009m1helloworld.model.CategoryModel;
import fpt.aptech.t2009m1helloworld.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategory extends HttpServlet {
    private CategoryModel categoryModel;
    public CreateCategory() {
        this.categoryModel = new MySqlCategoryModel();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Category category = Category.CategoryBuilder.aCategory()
                .withName(name)
                .build();
        if(!category.isValid()){
            req.setAttribute("category", category);
            req.getRequestDispatcher("/admin/category/form.jsp").forward(req, resp);
            return;
        }
        categoryModel.save(category);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req, resp);
    }
}
