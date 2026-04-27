package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import dao.HospitalDAO;
import model.Patient;

@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Patient p = new Patient();

            p.setPatientID(Integer.parseInt(req.getParameter("id")));
            p.setPatientName(req.getParameter("name"));
            p.setAge(Integer.parseInt(req.getParameter("age")));
            p.setGender(req.getParameter("gender"));
            p.setAdmissionDate(req.getParameter("date"));
            p.setAilment(req.getParameter("ailment"));
            p.setAssignedDoctor(req.getParameter("doctor"));

            HospitalDAO dao = new HospitalDAO();
            dao.createTable();
            dao.addpatient(p);

            res.getWriter().println("Patient Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}