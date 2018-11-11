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
import java.util.List;

@Slf4j
@WebServlet("/list")
public class ListDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            List<Department> departmentList = DepartmentTable.selectFromTable();
            req.setAttribute("departmentList", departmentList); // Will be available as ${departmentList} in JSP
            req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error("Error: {}", e);
        }
    }
}