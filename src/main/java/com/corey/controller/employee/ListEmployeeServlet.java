package com.corey.controller.employee;

import com.corey.dao.EmployeeTable;
import com.corey.model.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet("/listEmployees")
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            Long id = Long.parseLong(req.getParameter("id"));
            List<Employee> employeeList = EmployeeTable.selectEmployees(id);
            req.setAttribute("employeeList",employeeList);
            req.setAttribute("departId" , id);
            req.getRequestDispatcher("jsp/listEmployees.jsp").forward(req,resp);

        } catch (ServletException | IOException e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}