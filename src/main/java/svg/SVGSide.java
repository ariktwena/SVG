package svg;

import core.Carport;

public class SVGSide {

    private final Carport carport;
    private double length;
    private double width;
    private double height;
    private String roof;
    private boolean withShed;
    private String shedSize;
    private StringBuilder sb;
    private String SVGside;

    public SVGSide(Carport carport) {
        this.carport = carport;
        this.length = carport.getCarport_length();
        this.width = carport.getCarport_width();
        this.height = getCarport_height(carport.getRoof());
        this.withShed = carport.isWithShed();
        this.shedSize = carport.getShedSize();
        this.roof = carport.getRoof();
        this.sb = new StringBuilder();
        this.SVGside = null;
    }

    private double getCarport_height(String roof){
        if(roof.equals("skrot")){
            return 305;
        } else {
            return 230;
        }
    }

    public String getSvgSide() {
        sb.append(createHeader());
        sb = sb.append(fixedSize());
        sb = sb.append(vandretSpær());
        if(withShed){
            sb = sb.append(skur());
        }
        sb = sb.append(carportHeader());
        sb = sb.append(carportStolper());
        sb = sb.append(carportTag());
        sb = sb.append(carporFooter());
        sb = sb.append(footer());
        SVGside = sb.toString();
        return SVGside;
    }

    private String createHeader(){
        // først " og så ).append().append("
        // først " og så  + () + "
        String svgText;
        double headerHeight = height + 100;
        double headerLength = length + 150;

        if(roof.equals("skrot")){
            svgText = "";

        } else {
            svgText = "<svg version=\"1.1\"\n" +
                    "     xmlns=\"http://www.w3.org/2000/svg\"\n" +
                    "     height=\"" + headerHeight + "\"  width=\""+ headerLength + "\" viewBox=\"0 0 "+ headerLength + " "+ headerHeight + "\"\n" +
                    "     preserveAspectRatio=\"xMinYMin\">\n" +
                    "\n" +
                    "    <!--    Hvid ramme (heøjde + 100 og bredde +150)-->\n" +
                    "    <rect x=\"0\" y=\"0\" height=\""+ headerHeight + "\" width=\""+ headerLength + "\"\n" +
                    "          style=\"stroke:#000000; fill: #fff\"/>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    <defs>\n" +
                    "        <marker\n" +
                    "                id=\"beginArrow\"\n" +
                    "                markerWidth=\"12\"\n" +
                    "                markerHeight=\"12\"\n" +
                    "                refX=\"0\"\n" +
                    "                refY=\"6\"\n" +
                    "                orient=\"auto\">\n" +
                    "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                    "        </marker>\n" +
                    "        <marker\n" +
                    "                id=\"endArrow\"\n" +
                    "                markerWidth=\"12\"\n" +
                    "                markerHeight=\"12\"\n" +
                    "                refX=\"12\"\n" +
                    "                refY=\"6\"\n" +
                    "                orient=\"auto\">\n" +
                    "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                    "        </marker>\n" +
                    "    </defs>";
        }

        return svgText;
    }

    private String fixedSize(){
        String svgText;
        double fixedLength = length + 150;

        if(roof.equals("skrot")){
            svgText = "";

        } else {
            svgText = "   <!--    Lodret måling-->\n" +
                    "    <line x1=\"20\"  y1=\"10\" x2=\"20\"   y2=\"250\"\n" +
                    "          style=\"stroke: #000000;\n" +
                    "\tmarker-start: url(#beginArrow);\n" +
                    "\tmarker-end: url(#endArrow);\"/>\n" +
                    "\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(15,135) rotate(-90)\">230 cm</text>\n" +
                    "\n" +
                    "\n" +
                    "    <!--    Lodret måling-->\n" +
                    "    <line x1=\"50\"  y1=\"30\" x2=\"50\"   y2=\"250\"\n" +
                    "          style=\"stroke: #000000;\n" +
                    "\tmarker-start: url(#beginArrow);\n" +
                    "\tmarker-end: url(#endArrow);\"/>\n" +
                    "\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(45,135) rotate(-90)\">210 cm</text>\n" +
                    "\n" +
                    "    <!--    Lodret måling-->\n" +
                    "    <line x1=\"" + (fixedLength - 30) + "\"  y1=\"20\" x2=\"" + (fixedLength - 30) + "\"   y2=\"250\"\n" +
                    "          style=\"stroke: #000000;\n" +
                    "\tmarker-start: url(#beginArrow);\n" +
                    "\tmarker-end: url(#endArrow);\"/>\n" +
                    "\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(" + (fixedLength - 40) + ",135) rotate(-90)\">220 cm</text>";
        }


        return svgText;
    }


    private String vandretSpær(){
        String svgText;
        double headerLength = length + 150;

        if(roof.equals("skrot")){
            svgText = "";
        }else {
            double startsp = 75;
            double sp1 = 100;
            double sp3 = 130;
            double sp4 = 210;
            double sp5 = 30;
            double sp2 = length - (sp1 + sp3 + sp4 + sp5);

            svgText = "<line x1=\""+ startsp + "\"  y1=\"290\" x2=\"" + (startsp + sp1) + "\"  y2=\"290\" style=\"stroke: #000000; marker-start: url(#beginArrow);marker-end: url(#endArrow);\"/>\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(" + (startsp + 50) + ",280) rotate(0)\">"+ (sp1) + " cm</text>\n" +
                    "\n" +
                    "    <line x1=\"" + (startsp + sp1) + "\"  y1=\"290\" x2=\"" + (startsp + sp1 + sp2) + "\"  y2=\"290\" style=\"stroke: #000000; marker-start: url(#beginArrow);marker-end: url(#endArrow);\"/>\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(" + (startsp + sp1 + (sp2/2)) + ",280) rotate(0)\">"+ (sp2) + " cm</text>\n" +
                    "\n" +
                    "    <line x1=\"" + (startsp + sp1 + sp2) + "\"  y1=\"290\" x2=\"" + (startsp + sp1 + sp2 +sp3 ) + "\"  y2=\"290\" style=\"stroke: #000000; marker-start: url(#beginArrow);marker-end: url(#endArrow);\"/>\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(" + (headerLength - 380) + ",280) rotate(0)\">"+ (sp3) + " cm</text>\n" +
                    "\n" +
                    "    <line x1=\"" + (startsp + sp1 + sp2 + sp3 ) + "\"  y1=\"290\" x2=\"" + (startsp + sp1 + sp2 + sp3 + sp4 ) + "\"  y2=\"290\" style=\"stroke: #000000; marker-start: url(#beginArrow);marker-end: url(#endArrow);\"/>\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(" + (headerLength - 210) + ",280) rotate(0)\">"+ (sp4) + " cm</text>\n" +
                    "\n" +
                    "    <line x1=\"" + (startsp + sp1 + sp2 + sp3 + sp4 ) + "\"  y1=\"290\" x2=\"" + (startsp + sp1 + sp2 + sp3 + sp4 + sp5) + "\"  y2=\"290\" style=\"stroke: #000000; marker-start: url(#beginArrow);marker-end: url(#endArrow);\"/>\n" +
                    "    <text style=\"text-anchor: middle\" transform=\"translate(" + (headerLength - 90) + ",280) rotate(0)\">"+ (sp5) + " cm</text>";

        }

        return svgText;
    }



    private String skur(){
        String svgText;

        if(roof.equals("skrot")){
            svgText = "";
        }else {
            svgText = "<svg version=\"1.1\"\n" +
                    "         xmlns=\"http://www.w3.org/2000/svg\"\n" +
                    "         xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                    "         x=\"75\"\n" +
                    "         y=\"10\"\n" +
                    "         width=\""  + (length) + "\"\n" +
                    "         height=\"" + (height) + "\"\n" +
                    "         viewBox=\"0 0 "+ (length) + " " + (height) + "\"\n" +
                    "         preserveAspectRatio=\"xMinYMin\">";


            for(double x = 0 ; x < 210 ; x = x + 10){
                svgText = svgText + "<rect x=\"" + ((length - 240) + x) + "\" y=\"30\" height=\"200\" width=\"10\"\n" +
                        "style=\"stroke:#000000; \" fill=\"none\"/>";
            }

            svgText = svgText + "</svg>";
        }
        return svgText;
    }


    private String carportHeader() {
        String svgText;

        if (roof.equals("skrot")) {
            svgText = "";
        } else {
            svgText = "<svg version=\"1.1\"\n" +
                    "         xmlns=\"http://www.w3.org/2000/svg\"\n" +
                    "         xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                    "         x=\"75\"\n" +
                    "         y=\"10\"\n" +
                    "         width=\""  + (length) + "\"\n" +
                    "         height=\"" + (height) + "\"\n" +
                    "         viewBox=\"0 0 "+ (length) + " " + (height) + "\"\n" +
                    "         preserveAspectRatio=\"xMinYMin\">";

        }

        return svgText;
    }


    private String carportStolper() {
        String svgText;

        if (roof.equals("skrot")) {
            svgText = "";

        } else {
            svgText = "<rect x=\"100\" y=\"10\" height=\"220\" width=\"10\"\n" +
                    "              style=\"stroke:#000000; fill: #fff\"/>\n" +
                    "\n" +
                    "        <rect x=\"" + (length - 370) + "\" y=\"20\" height=\"210\" width=\"10\"\n" +
                    "              style=\"stroke:#000000; fill: #fff\"/>\n" +
                    "\n" +
                    "        <rect x=\"" + (length - 30) + "\" y=\"20\" height=\"210\" width=\"10\"\n" +
                    "              style=\"stroke:#000000; fill: #fff\"/>";

        }

        return svgText;
    }


    private String carportTag() {
        String svgText;

        if (roof.equals("skrot")) {
            svgText = "";
        } else {
            //minus 1 pixel da rammen er for lille pga tag drejning
            svgText = "<rect x=\"1\" y=\"0\" height=\"20\" width=\"" + (length - 1) + "\"\n" +
                    "              style=\"stroke:#000000; fill: #fff\" transform=\"rotate(1)\"/>\n" +
                    "\n" +
                    "        <rect x=\"1\" y=\"20\" height=\"20\" width=\"" + (length - 1) + "\"\n" +
                    "              style=\"stroke:#000000; fill: #fff\" transform=\"rotate(1)\"/>";
        }

        return svgText;
    }



    private String carporFooter() {
        String svgText;

        svgText = "</svg>";

        return svgText;
    }


    private String footer(){
        String svgText;

        svgText = "</svg>";

        return svgText;
    }
}
