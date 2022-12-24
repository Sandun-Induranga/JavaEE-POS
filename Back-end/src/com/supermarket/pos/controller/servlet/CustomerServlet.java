package com.supermarket.pos.controller.servlet;

import com.supermarket.pos.bo.BOFactory;
import com.supermarket.pos.bo.SuperBO;
import com.supermarket.pos.bo.custom.CustomerBO;
import com.supermarket.pos.dto.CustomerDTO;

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

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource dataSource;

    private final CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cusId = req.getParameter("cusId");
        String cusName = req.getParameter("cusName");
        String cusAddress = req.getParameter("cusAddress");
        double cusSalary = Double.parseDouble(req.getParameter("cusSalary"));


        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");

            pstm.setString(1, cusId);
            pstm.setString(2, cusName);
            pstm.setString(3, cusAddress);
            pstm.setDouble(4, cusSalary);
            boolean b = pstm.executeUpdate() > 0;

            if (b) {

                JsonObjectBuilder obj = Json.createObjectBuilder();

                obj.add("state", "OK");
                obj.add("message", "Successfully Added");
                obj.add("data", "");
                resp.setStatus(200);

                resp.getWriter().print(obj.build());

            }

        } catch (SQLException e) {
            JsonObjectBuilder obj = Json.createObjectBuilder();

            obj.add("state", "Error");
            obj.add("message", e.getLocalizedMessage());
            obj.add("data", "");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            resp.getWriter().print(obj.build());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonArrayBuilder allCustomers = Json.createArrayBuilder();


        try (Connection connection = dataSource.getConnection()) {

            ArrayList<CustomerDTO> all = customerBO.getAllCustomers(connection);

            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = pstm.executeQuery();

            for (CustomerDTO customerDTO : all) {

                JsonObjectBuilder customer = Json.createObjectBuilder();

                customer.add("id", resultSet.getString(1));
                customer.add("name", resultSet.getString(2));
                customer.add("address", resultSet.getString(3));
                customer.add("salary", resultSet.getDouble(4));
            }

            while (resultSet.next()) {

                JsonObjectBuilder customer = Json.createObjectBuilder();

                customer.add("id", resultSet.getString(1));
                customer.add("name", resultSet.getString(2));
                customer.add("address", resultSet.getString(3));
                customer.add("salary", resultSet.getDouble(4));

                allCustomers.add(customer.build());

            }

            JsonObjectBuilder obj = Json.createObjectBuilder();

            obj.add("state", "OK");
            obj.add("message", "Successfully Loaded..!");
            obj.add("data", allCustomers);
            resp.setStatus(200);

            resp.getWriter().print(obj.build());

        } catch (SQLException | ClassNotFoundException e) {
            JsonObjectBuilder obj = Json.createObjectBuilder();

            obj.add("state", "Error");
            obj.add("message", e.getLocalizedMessage());
            obj.add("data", "");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            resp.getWriter().print(obj.build());
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = dataSource.getConnection()) {

            String cusId = req.getParameter("cusId");

            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE customerId=?");

            pstm.setString(1, cusId);
            boolean b = pstm.executeUpdate() > 0;

            if (b) {

                JsonObjectBuilder obj = Json.createObjectBuilder();

                obj.add("state", "OK");
                obj.add("message", "Successfully Deleted");
                obj.add("data", "");
                resp.setStatus(200);

                resp.getWriter().print(obj.build());

            } else {
                throw new SQLException("No Such Customer ID");
            }

        } catch (SQLException e) {
            JsonObjectBuilder obj = Json.createObjectBuilder();

            obj.add("state", "Error");
            obj.add("message", e.getLocalizedMessage());
            obj.add("data", "");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);  // 500 // Server Side Errors

            resp.getWriter().print(obj.build());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonReader reader = Json.createReader(req.getReader());

        JsonObject customer = reader.readObject();

        String cusId = customer.getString("id");
        String cusName = customer.getString("name");
        String cusAddress = customer.getString("address");
        String cusSalary = customer.getString("cusSalary");

        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET customerName=?, address=?, salary=? WHERE customerId=?");

            pstm.setString(1, cusName);
            pstm.setString(2, cusAddress);
            pstm.setString(3, cusSalary);
            pstm.setString(4, cusId);
            boolean b = pstm.executeUpdate() > 0;

            connection.close();

            if (b) {
                JsonObjectBuilder obj = Json.createObjectBuilder();

                obj.add("state", "OK");
                obj.add("message", "Successfully Updated");
                obj.add("data", "");
                resp.setStatus(200);

                resp.getWriter().print(obj.build());
            } else {
                throw new SQLException("No Such Customer ID");
            }

        } catch (SQLException e) {
            JsonObjectBuilder obj = Json.createObjectBuilder();

            obj.add("state", "Error");
            obj.add("message", e.getLocalizedMessage());
            obj.add("data", "");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            resp.getWriter().print(obj.build());
        }

    }

}
