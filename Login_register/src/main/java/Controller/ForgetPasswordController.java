package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Service.UserService;
import Service.UserServiceImpl;
import Model.User;

@WebServlet(urlPatterns="/forget-password")
public class ForgetPasswordController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/forgetPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        User user = userService.findByUsernameAndEmail(username, email);
        if (user != null) {
            String newPass = "123456";
            userService.updatePassword(username, newPass);
            req.setAttribute("msg", "Mật khẩu mới của bạn là: " + newPass);
        } else {
            req.setAttribute("msg", "Thông tin không đúng, vui lòng thử lại!");
        }
        req.getRequestDispatcher("/views/web/forgetPassword.jsp").forward(req, resp);
    }
}
