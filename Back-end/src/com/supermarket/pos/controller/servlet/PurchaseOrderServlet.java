package com.supermarket.pos.controller.servlet;

import com.supermarket.pos.bo.BOFactory;
import com.supermarket.pos.bo.custom.PurchaseOrderBO;
import com.supermarket.pos.dto.CustomerDTO;
import com.supermarket.pos.dto.ItemDTO;
import com.supermarket.pos.dto.OrderDTO;
import com.supermarket.pos.dto.OrderDetailDTO;
import com.supermarket.pos.util.MessageUtil;

import javax.annotation.Resource;
import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@WebServlet(urlPatterns = "/")
public class PurchaseOrderServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    private DataSource dataSource;
    private final PurchaseOrderBO purchaseOrderBO = (PurchaseOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    MessageUtil messageUtil = new MessageUtil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String option = req.getParameter("option");
        try (Connection connection = dataSource.getConnection()) {

            switch (option) {
                case "customer":

                    CustomerDTO customerDTO = purchaseOrderBO.searchCustomer(connection, req.getParameter("cusId"));

                    if (customerDTO != null) {
                        System.out.println("come");
                        JsonObjectBuilder obj = Json.createObjectBuilder();
                        obj.add("cusId", customerDTO.getCusId());
                        obj.add("cusName", customerDTO.getCusName());
                        obj.add("cusAddress", customerDTO.getAddress());
                        obj.add("cusSalary", customerDTO.getSalary());

                        resp.setStatus(200);
                        resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Loaded..!", obj).build());

                    } else {
                        throw new SQLException("No Such Customer ID");
                    }
                    break;
                case "item":

                    ItemDTO itemDTO = purchaseOrderBO.searchItem(connection, req.getParameter("code"));

                    if (itemDTO != null) {
                        JsonObjectBuilder obj = Json.createObjectBuilder();
                        obj.add("code", itemDTO.getCode());
                        obj.add("name", itemDTO.getName());
                        obj.add("qty", itemDTO.getQtyOnHand());
                        obj.add("price", itemDTO.getPrice());

                        resp.setStatus(200);
                        resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Loaded..!", obj).build());

                    } else {
                        throw new SQLException("No Such Customer ID");
                    }
                    break;
            }

        } catch (SQLException | ClassNotFoundException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonReader reader = Json.createReader(req.getReader());

        JsonObject details = reader.readObject();
        String cusId = details.getString("cusId");
        double total = Double.parseDouble(details.getString("total"));
        JsonArray items = details.getJsonArray("items");

        try (Connection connection = dataSource.getConnection()) {

            String orderId = purchaseOrderBO.generateNewOrderID(connection);
            List<OrderDetailDTO> orderDetails = new ArrayList<>();

            for (JsonValue item : items) {

                JsonObject jsonObject = item.asJsonObject();
                orderDetails.add(new OrderDetailDTO(orderId, jsonObject.getString("code"), Double.parseDouble(jsonObject.getString("unitPrice")), Integer.parseInt(jsonObject.getString("qty"))));

            }

            if (purchaseOrderBO.purchaseOrder(connection, new OrderDTO(orderId, cusId, total, LocalDate.now().toString(), orderDetails))) {

                resp.setStatus(200);
                resp.getWriter().print(messageUtil.buildJsonObject("OK", "Order Placed", "").build());

            }

        } catch (ClassNotFoundException | SQLException e) {

            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }

    }

}
