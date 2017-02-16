/**
 * Created by qy on 2017/2/16.
 */
function createAJAX() {
    var ajax = null;
    try{
        ajax = new ActiveXObject("microsoft.xmlhttp");
    }catch(e1) {
        try{

            ajax = new XMLHttpRequest();
        }catch(e2) {
            alert("不支持Ajax,请升级浏览器");
        }
        }
        return ajax;

}