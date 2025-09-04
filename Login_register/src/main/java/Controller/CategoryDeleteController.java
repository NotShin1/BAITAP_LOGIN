package Controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Category;
import Service.CategoryService;
import Service.CategoryServiceImpl;
import util.Constant;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            int cateId = Integer.parseInt(id);

            // Lấy category để xoá ảnh cũ
            Category category = cateService.get(cateId);
            if (category != null && category.getIcons() != null) {
                File file = new File(Constant.DIR + "/" + category.getIcons());
                if (file.exists()) {
                    file.delete();
                }
            }

            // Xoá trong DB
            cateService.delete(cateId);

            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Không thể xoá category");
        }
    }
}
