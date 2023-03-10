package com.supermarket.pos.controller.servlet;

import com.supermarket.pos.bo.BOFactory;
import com.supermarket.pos.bo.custom.ItemBO;
import com.supermarket.pos.dto.ItemDTO;
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
import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource dataSource;

    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    MessageUtil messageUtil = new MessageUtil();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");
        String name = req.getParameter("itemName");
        int qty = Integer.parseInt(req.getParameter("qtyOnHand"));
        double price = Double.parseDouble(req.getParameter("price"));

        try (Connection connection = dataSource.getConnection()) {

            if (itemBO.saveItem(connection, new ItemDTO(code, name, qty, price))) {

                resp.setStatus(200);
                resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Added", "").build());

            }

        } catch (SQLException | ClassNotFoundException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonArrayBuilder allItems = Json.createArrayBuilder();

        try (Connection connection = dataSource.getConnection()) {

            ArrayList<ItemDTO> items = itemBO.getAllItems(connection);

            for (ItemDTO item : items) {
                JsonObjectBuilder jsonItem = Json.createObjectBuilder();

                jsonItem.add("code", item.getCode());
                jsonItem.add("name", item.getName());
                jsonItem.add("qty", item.getQtyOnHand());
                jsonItem.add("price", item.getPrice());

                allItems.add(jsonItem.build());
            }

            resp.setStatus(200);
            resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Loaded..!", allItems).build());

        } catch (SQLException | ClassNotFoundException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = dataSource.getConnection()) {

            String code = req.getParameter("code");

            if (itemBO.deleteItems(connection, code)) {

                resp.setStatus(200);
                resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Deleted..!", "").build());

            } else {
                throw new SQLException("No Such Item Code..!");
            }

        } catch (SQLException | ClassNotFoundException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonReader reader = Json.createReader(req.getReader());
        JsonObject item = reader.readObject();

        String code = item.getString("code");
        String name = item.getString("itemName");
        int qty = item.getInt("qtyOnHand");
        double price = Double.parseDouble(item.getString("price"));

        try (Connection connection = dataSource.getConnection()) {

            if (itemBO.updateItem(connection, new ItemDTO(code, name, qty, price))) {

                resp.setStatus(200);
                resp.getWriter().print(messageUtil.buildJsonObject("OK", "Successfully Updated", "").build());

            } else {
                throw new SQLException("No Such Item Code");
            }

        } catch (SQLException | ClassNotFoundException e) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().print(messageUtil.buildJsonObject("Error", e.getLocalizedMessage(), "").build());

        }
    }
}
