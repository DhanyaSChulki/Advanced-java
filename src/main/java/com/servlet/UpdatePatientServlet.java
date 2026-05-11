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

@WebServlet("/UpdatePatientServlet")

public class UpdatePatientServlet extends HttpServlet {

    private HospitalDAO dao;

    // INITIALIZE DAO

    @Override
    public void init() {

        dao = new HospitalDAO();

        System.out.println("UpdatePatientServlet Initialized");
    }

    // OPEN UPDATE PAGE

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id =
            Integer.parseInt(
            request.getParameter("id"));

            Patient patient =
            dao.getPatientById(id);

            request.setAttribute(
                    "patient",
                    patient);

            request.getRequestDispatcher(
                    "patientupdate.jsp")
                    .forward(request, response);

        }
        catch (Exception e) {

            e.printStackTrace();

            response.getWriter()
            .println("Error : " + e.getMessage());
        }
    }

    // UPDATE PATIENT

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // GET FORM VALUES

            int id =
            Integer.parseInt(
            request.getParameter("patientId"));

            String name =
            request.getParameter("patientName");

            int age =
            Integer.parseInt(
            request.getParameter("age"));

            String gender =
            request.getParameter("gender");

            String ailment =
            request.getParameter("ailment");

            // OTHER AILMENT

            if ("Other".equals(ailment)) {

                ailment =
                request.getParameter("otherAilment");
            }

            String assignedDoctor =
            request.getParameter("assignedDoctor");

            // OTHER DOCTOR

            if ("Other".equals(assignedDoctor)) {

                assignedDoctor =
                request.getParameter("otherDoctor");
            }

            Date admissionDate =
            Date.valueOf(
            request.getParameter("admissionDate"));

            // SET VALUES TO MODEL

            Patient patient =
            new Patient();

            patient.setPatientID(id);

            patient.setPatientName(name);

            patient.setAge(age);

            patient.setGender(gender);

            patient.setAilment(ailment);

            patient.setAssignedDoctor(
                    assignedDoctor);

            patient.setAdmissionDate(
                    admissionDate);

            // UPDATE

            boolean success =
            dao.updatePatient(patient);

            if (success) {

                response.sendRedirect(
                "DisplayPatientsServlet?message=updated");
            }
            else {

                response.getWriter()
                .println("Update Failed");
            }

        }
        catch (Exception e) {

            e.printStackTrace();

            response.getWriter()
            .println("Error : " + e.getMessage());
        }
    }
}