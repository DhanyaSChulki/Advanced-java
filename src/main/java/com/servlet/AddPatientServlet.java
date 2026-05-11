package com.servlet;

import com.dao.HospitalDAO;
import com.model.Patient;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPatientServlet")

public class AddPatientServlet extends HttpServlet {

    private HospitalDAO dao;

    @Override
    public void init(){

        dao = new HospitalDAO();

        System.out.println("AddPatientServlet Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        int nextId = dao.getNextPatientId();

        request.setAttribute("nextId", nextId);

        request.getRequestDispatcher("patientadd.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        try{

            int patientId =
            Integer.parseInt(
            request.getParameter("patientId"));

            String patientName =
            request.getParameter("patientName");

            int age =
            Integer.parseInt(
            request.getParameter("age"));

            String gender =
            request.getParameter("gender");

            String ailment =
            request.getParameter("ailment");

            if("Other".equals(ailment)){

                ailment =
                request.getParameter("otherAilment");
            }

            String assignedDoctor =
            request.getParameter("assignedDoctor");

            Date admissionDate =
            Date.valueOf(
            request.getParameter("admissionDate"));

            Patient patient = new Patient();

            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
            patient.setAge(age);
            patient.setGender(gender);
            patient.setAdmissionDate(admissionDate);
            patient.setAilment(ailment);
            patient.setAssignedDoctor(assignedDoctor);

            boolean status =
            dao.addPatient(patient);

            if(status){

                request.setAttribute(
                "message",
                "Patient Added Successfully!");

            }
            else{

                request.setAttribute(
                "message",
                "Failed to Add Patient!");
            }

        }
        catch(Exception e){

            e.printStackTrace();

            request.setAttribute(
            "message",
            "Error : " + e.getMessage());
        }

        int nextId = dao.getNextPatientId();

        request.setAttribute("nextId", nextId);

        request.getRequestDispatcher("patientadd.jsp")
               .forward(request, response);
    }
}
