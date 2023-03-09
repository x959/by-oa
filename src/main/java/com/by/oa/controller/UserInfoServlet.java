package com.by.oa.controller;

import com.by.oa.entity.Employee;
import com.by.oa.entity.Node;
import com.by.oa.service.EmployeeService;
import com.by.oa.service.RbacService;
import com.by.oa.utils.ResponseUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/user_info")
public class UserInfoServlet extends HttpServlet {
    private RbacService rbacService = new RbacService();
    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String eid = request.getParameter("eid");
        List<Node> nodes = rbacService.selectNodeByUserId(Long.parseLong(uid));
        List<Map> treeList = new ArrayList<>();
        Map module = null;
        for (Node node : nodes) {
            if (node.getNodeType() == 1){
                module = new LinkedHashMap();
                module.put("node",node);
                module.put("children",new ArrayList());
                treeList.add(module);
            } else if (node.getNodeType() == 2) {
                List children = (List) module.get("children");
                children.add(node);
            }
        }
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        String json = new ResponseUtils().put("nodeList", treeList).put("employee",employee).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
