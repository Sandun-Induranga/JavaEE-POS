package com.supermarket.pos.controller.servlet;

import com.supermarket.pos.bo.BOFactory;
import com.supermarket.pos.bo.custom.OrderDetailBO;
import com.supermarket.pos.dto.OrderDetailDTO;
import com.supermarket.pos.util.MessageUtil;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@WebServlet(urlPatterns = "/order_detail")
public class OrderDetailServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    private DataSource dataSource;
    OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER_DETAILS);
    MessageUtil messageUtil = new MessageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonArrayBuilder allOrderDetails = Json.createArrayBuilder();

        try (Connection connection = dataSource.getConnection()) {

            ArrayList<OrderDetailDTO> all = orderDetailBO.getAllOrderDetails(connection);

            for (OrderDetailDTO detailDTO : all) {
                JsonObjectBuilder detail = Json.createObjectBuilder();

                detail.add("orderId", detailDTO.getOrderId());
                detail.add("code", detailDTO.getItemCode());
                detail.add("price", detailDTO.getPrice());
                detail.add("qty", detailDTO.getQty());

                allOrderDetails.add(detail.build());
            }

            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Loaded", allOrderDetails).build());

        } catch (SQLException | ClassNotFoundException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }

    }
}
