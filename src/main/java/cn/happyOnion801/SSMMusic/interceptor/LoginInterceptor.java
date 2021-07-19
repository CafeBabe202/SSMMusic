package cn.happyOnion801.SSMMusic.interceptor;

import cn.happyOnion801.SSMMusic.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-29
 * Blog : https://www.happyOnion801.cn
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Object obj = session.getAttribute("user");
        if (obj instanceof User) {
            return true;
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/toAdminLogin");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
