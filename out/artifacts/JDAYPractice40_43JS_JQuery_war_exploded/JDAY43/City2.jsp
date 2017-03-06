<%--
  Created by IntelliJ IDEA.
  User: qy
  Date: 2017/2/18
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城市</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>

</head>
<body>
    <div>省市区三级联动</div>
    <div>
        省：<select class="combo-box" id="province">
            <option>请选择</option>
            <option>广东</option>
            <option>湖南</option>
        </select>
        市：<select class="combo-box" id="city">
            <option>请选择</option>
        </select>
        区：<select class="combo-box" id="district">
            <option>请选择</option>
        </select>
    </div>
    <script type="text/javascript">
        $("#province").change(function () {

            $("#city option:gt(0)").remove();
            var $province = $("#province option:selected").text();
            $.ajax({
                "type":"POST",
                "url":"${pageContext.request.contextPath}/struts2/findCityByProvinceRequest?time="+new Date().getTime(),
                "data":{"province":$province},
                //返回成功后的回调函数
                "success": function(backData,textStatus,ajax){
                    var $city = $(backData.setCity);
                    $city.each(function () {
                        var $option = $("<option>"+this+"<option>");
                        $("#city").append($option);
                    });

                }
            });


        })
    </script>
    <script type="text/javascript">
        $("#city").change(function () {

            $("#district option:gt(0)").remove();
            var $city = $("#city option:selected").text();
            $.ajax({
                "type":"POST",
                "url":"${pageContext.request.contextPath}/struts2/findDisByCityRequest?time="+new Date().getTime(),
                "data":{"city":$city},
                //返回成功后的回调函数
                "success": function(backData,textStatus,ajax){
                    var $dis = $(backData.setDis);
                    $dis.each(function () {
                        var $option = $("<option>"+this+"<option>");
                        $("#district").append($option);
                    });

                }
            });


        })
    </script>
</body>
</html>
