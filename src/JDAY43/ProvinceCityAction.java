package JDAY43;


import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qy on 2017/2/18.
 */
public class ProvinceCityAction extends ActionSupport {
    private String province;
    private  String city;
    public String findCityByProvince() throws Exception{
        setCity = new HashSet<String>();
        if("广东".equals(province)){
            setCity.add("湛江");
            setCity.add("汕头");
        }else if("湖南".equals(province)){
            setCity.add("邵阳");
            setCity.add("浏阳");
        }
        return "success";

    }
    public String findDisByCity() throws  Exception{
        setDis = new HashSet<String>();
        if("汕头".equals(city)){
            setDis.add("汕头1区");
            setDis.add("汕头2区");
        }else if("湛江".equals(city)){
            setDis.add("湛江1区");
            setDis.add("湛江2区");
        }else if("邵阳".equals(city)){
            setDis.add("邵阳1区");
            setDis.add("邵阳2区");
        }else if("浏阳".equals(city)){
            setDis.add("浏阳1区");
            setDis.add("浏阳2区");
        }
        return "success";
    }
    private Set<String> setCity;
    private Set<String> setDis;

    public void setProvince(String province) {
        this.province = province;
    }

    public Set<String> getSetCity() {
        return setCity;
    }

    public Set<String> getSetDis() {
        return setDis;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
