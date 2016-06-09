package com.kxw.util;

import com.kxw.servlet.TestServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.tools.tree.ShiftRightExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kangxiongwei on 16/6/9 上午8:58.
 */
public class TestHttpClientUtil {

    private Server server = null;

    @Before
    public void setUp() throws Exception {
        server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(TestServlet.class, "/");
        context.setContextPath("/test");
        server.setHandler(context);
        server.start();
    }

    @Test
    public void testSendGetRequest() {
        String url = "http://localhost:8080/test";
        String response = HttpClientUtil.sendGetRequest(url, null);
        System.out.println(response);
    }

    @Test
    public void testSendPostRequest() {
        String url = "http://localhost:8080/test";
        Map<String, String> params = new HashMap<>();
        params.put("user", "kang");
        params.put("name", "xiongwei");
        String response = HttpClientUtil.sendPostRequest(url, params);
        System.out.println(response);
    }

    @After
    public void tearDown() throws Exception{
        server.stop();
    }
}
