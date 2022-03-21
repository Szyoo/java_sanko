package jp.co.sss.crud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountCheckInterceptor {
    @Autowired
    HttpSession session;

    @Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;
}
