package com.servlet;

import com.dao.HospitalDAO;
import com.model.Patient;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayPatientsServlet")
public class DisplayPatientsServlet extends HttpServlet {
    private HospitalDAO dao;
    
    @Override
    public void init() {
        dao = new HospitalDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Patient> patients = dao.getAllPatients();
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("patientdisplay.jsp").forward(request, response);
    }
}