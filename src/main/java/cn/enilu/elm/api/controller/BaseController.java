package cn.enilu.elm.api.controller;

import com.google.common.base.Strings;
import org.nutz.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created on 2017/12/29 0029.
 * @author zt
 */
public class BaseController {

    protected  String getRequestPayload(HttpServletRequest request){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    protected  <T>T getRequestPayload(HttpServletRequest request, Class<T> klass)     {
        String json = getRequestPayload(request);
        try {
            T result = null;
            if(klass==Map.class||klass==null){
                result = (T) Json.fromJson(json);
            }else {
               result = Json.fromJson( klass,json);
            }
            return result;
        }catch (Exception e){

        }
        return null;
    }

    protected  void setSession(HttpServletRequest request,String key,Object val){
        request.getSession().setAttribute(key,val);
    }

    public String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(Strings.isNullOrEmpty(ip)){
            //测试ip
            ip = "101.81.121.39";
        }
        return ip;

    }
}
