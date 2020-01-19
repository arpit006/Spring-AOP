package com.arpit.aop.dynamic_proxy_java;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class Jio implements ISP {

    @Override
    public String getResource(String inUrl) {
        switch (inUrl) {
            case "www.codechef.com":
                return "Welcome to Codechef.";
            case "www.hackerrank.com":
                return "Welcome to Hackerrank.";
            case "www.hackerearth.com":
                return "Welcome to HackerEarth.";
            case "www.codeforces.com":
                return "Welcome to CodeForces";
            case "www.interviewbit.com":
                return "Welcome to InterviewBit.";
            case "www.scaler.com":
                return "Welcome to Scaler";
            default:
                return "Resource not found";
        }
    }
}
