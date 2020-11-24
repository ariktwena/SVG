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
                <option value="700">700</option>
                <option value="720">720</option>
                <option value="750">750</option>
                <option value="780">780</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect2">Bredde carport</label>
            <select class="form-control" id="exampleFormControlSelect2" name="width">
                <option value="570">570</option>
                <option value="600">600</option>
                <option value="630">630</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect4">Tag</label>
            <select class="form-control" id="exampleFormControlSelect4" name="roof">
                <option value="fladt">Fladt tag</option>
                <option value="skråt">Skråt tag</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect3">Skur</label>
            <select class="form-control" id="exampleFormControlSelect3" name="shed">
                <option value="hel">Hel</option>
                <option value="halv">Halv</option>
            </select>
        </div>

        <input type="submit" value="Send">

    </form>
</div>


<div>
    <div>
        ${requestScope.svgTop}
    </div>
    <div>
        ${requestScope.svgSide}
    </div>
</div>

</body>
</html>
