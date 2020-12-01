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
        boolean withShed, isCustomer;
        double shedLenght, shedWidth;

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

        if(roof.equals("skrot")){
            shedLenght = 225;
            if(shedSize.equals("hel")){
                shedWidth = width - 40;
            } else {
                shedWidth = (width / 2) - 40;
            }
        } else {
            shedLenght = 210;
            if(shedSize.equals("hel")){
                shedWidth = width - 75;
            } else {
                shedWidth = (width / 2) - 75;
            }
        }

        if(kunde.equals("ja")){
            isCustomer = true;
        } else {
            isCustomer = false;
        }

        Shed shed = new Shed(shedLenght, shedWidth);

        Carport carport = new Carport(length, width, roof, withShed, shed);

        SVGSide svgSide = new SVGSide(carport, isCustomer);
        SVGTop svgTop = new SVGTop(carport, isCustomer);

        request.setAttribute("svgSide", svgSide.getSvgSide());
        request.setAttribute("svgTop", svgTop.getSvgTop());

        render("Index", "/WEB-INF/pages/index.jsp", request, response);
    }
}
