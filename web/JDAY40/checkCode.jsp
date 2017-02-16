<%--
  Created by IntelliJ IDEA.
  User: qy
  Date: 2017/2/16
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查验证码</title>
    <script type="text/javascript" src="js/creatAJAX.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
</head>
<body>
    验证码:
    <input type="text" maxlength="4" size="4"/>
    <img src="01_image.jsp"/>
    <br>
    <input type="button" value="看不清" size="2">
    <br>
    <br>
    <span></span>


    <script type="text/javascript">
        //1.定位按钮
        $("input:button").click(function () {
            document.images[0].src = "01_image.jsp?id="+new Date().getTime();
            //清空span标签中的内容
            var spanElement = document.getElementsByTagName("span")[0];
            spanElement.innerHTML = "";
            //清空文本框中的内容
            document.getElementsByTagName("input")[0].value = "";

        })
    </script>
    <script type="text/javascript">
        //2.定位文本框
        $("input:text").keyup(function () {
            var code = $(this).val();

            var ajax = createAJAX();
            var method = "POST";
            var url = "${pageContext.request.contextPath}/CheckCodeServlet?time=" + new Date().getTime();
            ajax.open(method,url);
            ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
            var content = "code="+code;
            ajax.send(content);

            ajax.onreadystatechange = function(){
                if(ajax.readyState==4){
                    if(ajax.status == 200){
                        $("span").empty();
                        var src = ajax.responseText;
                        $("span").append("<img id='flag' width='12px' height='12px'/>");
                        $("#flag").attr("src",src);
                    }
                }
            }
        })


    </script>
</body>
</html>
