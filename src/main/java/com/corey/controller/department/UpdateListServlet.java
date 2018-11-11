package com.corey.controller.department;

import com.corey.dao.DepartmentTable;
import com.corey.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet("/update")
public class UpdateListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            Department department = DepartmentTable.selectOne(id);
            if (department != null) {
                req.setAttribute("department", department);
                req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("jsp/notfound.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            log.error("Error department not found: {}", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            Department department = new Department(id, name);
            DepartmentTable.updateToTable(department);
            resp.sendRedirect("/list");
        } catch (Exception e) {
            log.error("Error not update: {}", e.getMessage());
        }
    }
}