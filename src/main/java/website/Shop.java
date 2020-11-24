package website;

import core.Carport;
import core.Shed;
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
        double degrees, shedLength, shedWidth;

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        String roof = request.getParameter("roof");
        String shed = request.getParameter("shed");

        if(roof.equals("skråt")){
            degrees = 30;
        } else {
            degrees = 0;
        }

        if(roof.equals("hel")){
            shedLength = 100;
            shedWidth = (width - 30) / 2;
        } else {
            shedLength = 100;
            shedWidth = width;
        }

        Shed carportShed = new Shed(0, shedLength, shedWidth);
        Carport carport = new Carport(length, width, degrees, roof, "", 0, 0, 0);

        SVGTop SVGTop = new SVGTop(carport, carportShed);

        double height = 400;

        SVGSide SVGSide = new SVGSide(carport, carportShed, height);

        request.setAttribute("svgTop", SVGTop.getMySVG());

        request.setAttribute("svgSide", SVGSide.getMySVG());

        render("Index", "/WEB-INF/pages/index.jsp", request, response);
    }
}
