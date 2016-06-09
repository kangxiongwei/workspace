package com.kxw.servlet;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by kangxiongwei on 16/6/9 上午11:12.
 */
public class TestJetty {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(TestServlet.class, "/");
        context.setContextPath("/test");
        server.setHandler(context);
        server.start();
    }

}
