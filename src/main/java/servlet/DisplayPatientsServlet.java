package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import dao.HospitalDAO;

@WebServlet("/DisplayPatientsServlet")
public class DisplayPatientsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HospitalDAO dao = new HospitalDAO();
            ResultSet rs = dao.getAllPatients();

            PrintWriter out = res.getWriter();

            while(rs.next()){
                out.println(rs.getString("PatientName") + "<br>");
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}