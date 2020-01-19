package com.arpit.aop.dynamic_proxy_java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class InternetProxy implements InvocationHandler {

    private ISP isp;

    public InternetProxy(ISP isp) {
        this.isp = isp;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String url = String.valueOf(args[0]);
        if(isUrlBlocked(url)) {
            return "This URL is blocked by your organisation. Please contact your manager.";
        }
        return method.invoke(isp, url);
    }

    public boolean isUrlBlocked(String inUrl) {
        switch (inUrl) {
            case "www.codechef.com":
                return false;
            case "www.hackerrank.com":
                return false;
            case "www.hackerearth.com":
                return false;
            case "www.codeforces.com":
                return false;
            case "www.interviewbit.com":
                return false;
            case "www.scaler.com":
                return false;
            default:
                return true;
        }
    }
}
