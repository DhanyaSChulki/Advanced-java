package com.servlet;

import com.dao.HospitalDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeletePatientServlet")
public class DeletePatientServlet extends HttpServlet {
    private HospitalDAO dao;
    
    @Override
    public void init() {
        dao = new HospitalDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = dao.deletePatient(id);
        
        if (success) {
            response.sendRedirect("DisplayPatientsServlet?message=deleted");
        } else {
            response.sendRedirect("DisplayPatientsServlet?error=1");
        }
    }
}