<%--
  Created by IntelliJ IDEA.
  User: Tweny
  Date: 24/11/2020
  Time: 10.52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SVG</title>
</head>
<body>

<div style="text-align: center;">
<h1>SVG</h1>
</div>

<div>
    <form action="Shop" method="post">

        <div class="form-group">
            <label for="exampleFormControlSelect1">Længde carport</label>
            <select class="form-control" id="exampleFormControlSelect1" name="length">
                <option value="510">510</option>
                <option value="540">540</option>
                <option value="570">570</option>
                <option value="600">600</option>
                <option value="630">630</option>
                <option value="660">660</option>
                <option value="690">690</option>
                <option value="720">720</option>
                <option value="730">730</option>
                <option value="750">750</option>
                <option value="780">780</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect2">Bredde carport</label>
            <select class="form-control" id="exampleFormControlSelect2" name="width">
                <option value="300">300</option>
                <option value="330">330</option>
                <option value="360">360</option>
                <option value="390">390</option>
                <option value="420">420</option>
                <option value="450">450</option>
                <option value="480">480</option>
                <option value="510">510</option>
                <option value="540">540</option>
                <option value="570">570</option>
                <option value="600">600</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect4">Tag</label>
            <select class="form-control" id="exampleFormControlSelect4" name="roof">
                <option value="flat">Fladt tag</option>
                <option value="skrot">Skråt tag</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect5">Skur?</label>
            <select class="form-control" id="exampleFormControlSelect5" name="shedOption">
                <option value="ja">Ja</option>
                <option value="nej">Nej</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect3">Skur mål</label>
            <select class="form-control" id="exampleFormControlSelect3" name="shedSize">
                <option value="hel">Hel</option>
                <option value="halv">Halv</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect7">Kunde?</label>
            <select class="form-control" id="exampleFormControlSelect7" name="kunde">
                <option value="ja">Ja</option>
                <option value="nej">Nej</option>
            </select>
        </div>

        <input type="submit" value="Send">

    </form>
</div>


<div>
<%--<div style="width: 800px">--%>
    <div>
<%--    <div style="width: 1200px">--%>
        ${requestScope.svgSide}
    </div>
    <div>
<%--    <div style="width: 1200px">--%>
        ${requestScope.svgTop}
    </div>
</div>

</body>
</html>
