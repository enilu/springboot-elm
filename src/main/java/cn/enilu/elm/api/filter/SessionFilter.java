package cn.enilu.elm.api.filter;

import cn.enilu.elm.api.vo.Constants;
import cn.enilu.elm.api.vo.Rets;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created  on 2017/12/29 0029.
 *权限控制，未完成，暂时不启用权限认证
 * @author zt
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/img/*", "/admin/login", "/admin/logout", "/register")));
    private Logger logger = LoggerFactory.getLogger(SessionFilter.class);
    public static  final String SESSION_ID="login_user_session";
    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = allowd(path);
        if(1==1){
            //暂时不启用权限控制
            chain.doFilter(request,response);
            return ;
        }
        if (allowedPath) {

            chain.doFilter(request, response);
            return ;
        }
        else {
            HttpSession session = request.getSession();
            if (session.getAttribute(Constants.SESSION_ID) != null) {
                // session存在
                chain.doFilter(request, response);

            } else {
                // session不存在 准备跳转失败
                PrintWriter out = response.getWriter();
                out.println(Json.toJson(Rets.failure("message", "未登录")));

            }

        }




    }
    public boolean allowd(String url){
        if(url.startsWith("/img")){
            return true;
        }
        return ALLOWED_PATHS.contains(url);
    }
    @Override
    public void destroy() {

    }


}