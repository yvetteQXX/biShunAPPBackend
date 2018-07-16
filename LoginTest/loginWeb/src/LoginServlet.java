import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hasee on 2018/7/11.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String username = "";
        String password = "";
        String score = "";
        username = request.getParameter("username");
        password = request.getParameter("password");
        score = request.getParameter("score");

        if (username.equals("admin") && password.equals("123")) {
            out.print("Login succeeded!");
            out.println();
            out.print("username:" + username + " ; password:" + password + " ; score:" + score);
        } else {
            out.print("Login failed!");
            out.println();
            out.print("username:" + username + " ; password:" + password + " ; score:" + score);
        }

        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
