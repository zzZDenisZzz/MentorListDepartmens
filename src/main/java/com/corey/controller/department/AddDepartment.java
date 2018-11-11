package com.corey.controller.department;

import com.corey.dao.DepartmentTable;
import com.corey.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/add")
public class AddDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error("Error: {}", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            Department department = new Department(name);
            DepartmentTable.insertIntoTable(department);
            resp.sendRedirect("/list");
        } catch (IOException e) {
            try {
                req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
            } catch (Exception ex) {
                log.error("Error add department: {} " + ex.getMessage());
            }
        }
    }
}