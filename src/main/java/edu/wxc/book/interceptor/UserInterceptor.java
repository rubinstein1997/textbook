//package edu.wxc.book.interceptor;
//
//import edu.wxc.book.domain.User;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.logging.Logger;
//
//public class UserInterceptor implements HandlerInterceptor {
//    private static final String[] IGNORE_URI = {"/login","/404.html","/js","/css","/images","/logout"};
//
//    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        /*默认用户没有登录 */
//        boolean flag = false;
//        /*获得请求的ServletPath */
//        String servletPath = request.getServletPath();
//        /*判断请求是否需要拦截 */
//        if(servletPath.contains("login"))
//            return true;
//        logger.info(servletPath);
////        for(String s : IGNORE_URI) {
//////            logger.info("s : " + s);
////            logger.info(servletPath + "是否包含" + s + ":" + servletPath.contains(s));
////            if(servletPath.contains(s)) {
////
////                logger.info("login" + s);
////
////
////
////
////                return true;
////
////            }
////        }
//        /*拦截请求 */
////        if(!flag) {
//            /*获取session中的用户 */
//            User user = (User) request.getSession().getAttribute("user");
//
//            //待完善逻辑,teacher user 会通过下面逻辑,但由于没有admin权限,会被拦截,但无法跳转
//            if(user == null) {
//                request.setAttribute("message","请先登录再访问网站!");
//                response.sendRedirect("login");
////                request.getRequestDispatcher("login").forward(request, response);
////                return true;
//            } else {
//                switch (user.getRole()) {
//                    case "secretary":
//                        logger.info("secretary拦截");
//                        return servletPath.contains("secretary");
//                    case "auditor":
//
//                        logger.info("auditor拦截");
//                        return servletPath.contains("auditor");
//
//                }
//            }
//        return true;
//        }
//
////        return true;
////    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
