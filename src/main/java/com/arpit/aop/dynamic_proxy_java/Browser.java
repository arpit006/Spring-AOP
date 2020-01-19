package com.arpit.aop.dynamic_proxy_java;

import javax.swing.*;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class Browser {

    public void execute() {
        String url = JOptionPane.showInputDialog("Enter the url :: ");

        Jio jio = new Jio();
        InternetProxy ip = new InternetProxy(jio);
        //Proxy of ISP
        ISP isp = (ISP) Proxy.newProxyInstance(ip.getClass().getClassLoader(),
                new Class[]{ISP.class},
                ip);
        String output = isp.getResource(url);
        this.loadResponse(output, url);
    }

    public void loadResponse(String output, String url) {
        System.out.println("The URL :- " + url + " was accessed at time : " + new Date());
        System.out.println("Output :: " + output);
    }
}
