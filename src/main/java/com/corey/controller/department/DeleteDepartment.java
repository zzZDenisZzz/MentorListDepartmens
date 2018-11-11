package com.corey.controller.department;

import com.corey.dao.DepartmentTable;
import com.corey.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet("/delete")
public class DeleteDepartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            Department department = new Department(id);
            DepartmentTable.deleteFromTable(department);
            resp.sendRedirect("/list");
        } catch (Exception e) {
            try {
                req.getRequestDispatcher("jsp/notfound.jsp").forward(req, resp);
            } catch (Exception ex) {
                log.error("Not found: {}", ex.getMessage());
            }
        }
    }
}