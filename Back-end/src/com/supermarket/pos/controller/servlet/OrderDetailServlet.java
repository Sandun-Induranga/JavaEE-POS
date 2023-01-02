package com.supermarket.pos.controller.servlet;

import com.supermarket.pos.bo.BOFactory;
import com.supermarket.pos.bo.custom.OrderDetailBO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
@WebServlet(urlPatterns = "/order_detail")
public class OrderDetailServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    private DataSource dataSource;
    OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER_DETAILS);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
