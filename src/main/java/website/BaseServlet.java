package website;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {


    protected void render(String title, String content, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        request.getRequestDispatcher("/WEB-INF/includes/base.jsp").forward(request, response);

    }

}
