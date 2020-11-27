package website;

import core.Carport;
import svg.SVGSide;
import svg.SVGTop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Shop", urlPatterns = { "/Shop" } )
public class Shop extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        render("Index", "/WEB-INF/pages/index.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean withShed;

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        String roof = request.getParameter("roof");
        String shedOption = request.getParameter("shedOption");
        String shedSize = request.getParameter("shedSize");
        String kunde = request.getParameter("kunde");

        if(shedOption.equals("ja")){
            withShed = true;
        } else {
            withShed = false;
        }

        Carport carport = new Carport(length, width, roof, withShed, shedSize);

        SVGSide svgSide = new SVGSide(carport, kunde);
        SVGTop svgTop = new SVGTop(carport, kunde);

        request.setAttribute("svgSide", svgSide.getSvgSide());
        request.setAttribute("svgTop", svgTop.getSvgTop());

        render("Index", "/WEB-INF/pages/index.jsp", request, response);
    }
}
