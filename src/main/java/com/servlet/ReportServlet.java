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

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private HospitalDAO dao;
    
    @Override
    public void init() {
        dao = new HospitalDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String reportType = request.getParameter("reportType");
        List<Patient> patients = null;
        String reportTitle = "";
        
        if ("dateRange".equals(reportType)) {
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            patients = dao.getPatientByDateRange(startDate, endDate);
            reportTitle = "Patients Admitted from " + startDate + " to " + endDate;
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
        } else if ("ailment".equals(reportType)) {
            String ailment = request.getParameter("ailment");
            if ("Other".equals(ailment)) {
                ailment = request.getParameter("otherAilment");
            }
            patients = dao.getPatientByAilment(ailment);
            reportTitle = "Patients with Ailment: " + ailment;
            request.setAttribute("ailment", ailment);
        } else if ("doctor".equals(reportType)) {
            String doctor = request.getParameter("doctor");
            if ("Other".equals(doctor)) {
                doctor = request.getParameter("otherDoctor");
            }
            patients = dao.getPatientByDoctor(doctor);
            reportTitle = "Patients assigned to: " + doctor;
            request.setAttribute("doctor", doctor);
        }
        
        request.setAttribute("patients", patients);
        request.setAttribute("reportTitle", reportTitle);
        request.setAttribute("reportType", reportType);
        request.getRequestDispatcher("report_result.jsp").forward(request, response);
    }
}