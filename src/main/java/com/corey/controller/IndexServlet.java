package com.corey.controller;

import com.corey.dao.DepartmentTable;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            DepartmentTable.createTable();
            resp.sendRedirect("/list");
        } catch (IOException e) {
            log.error("Error: {}", e);
            DepartmentTable.dropTable();
        }
    }
}