<%--
  Created by IntelliJ IDEA.
  User: qy
  Date: 2017/2/16
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="js/creatAJAX.js"></script>
</head>
<body>
    <select class="combo-box" id="province">
        <option>请选择</option>
        <option>江苏</option>
        <option>广东</option>
    </select>
    <select class="combo-box" id="city">
        <option>请选择</option>
    </select>

<script type="text/javascript">
    //1. 定位所选择的省份
    $("#province").change(function () {

       var name =  $("#province option:selected").text();

           //2.创建ajax对象
           $("#city").empty();
           var ajax = createAJAX();
           if (ajax ==null){alert("未创建ajax对象");}

           //3.准备发送
           var method = "POST";
           var url = "${pageContext.request.contextPath}/MyCityServlet?time=" + new Date().getTime();
           ajax.open(method,url);
           //4.设置AJAX请求头为POST，他会将请求体中的汉字自动进行UTF-8的编码
           ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
           var content = "name=" + name;
           //5.发送
           ajax.send(content);

            //6.准备接受相应
           ajax.onreadystatechange = function () {
               if(ajax.readyState==4){
                   if(ajax.status==200){
                       //7.解析XML
                       var XML = ajax.responseXML;
                       var eles = XML.getElementsByTagName("option");
                       for(var i = 0 ; i<eles.length;i++){
                           var ele = eles[i];
                           var city = ele.firstChild.nodeValue;

                           $('#city').append("<option></option>");
                           $("#city option:last").text(city);
                       }
                   }
               }
           }


    })
</script>
</body>
</html>
