package pl.coderslab.controller;

import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/** Obsługa strony głównej */
@WebServlet("")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numbersSolution = getServletContext().getInitParameter("number-solutions");
        //List<Solution> recentSolutions = SolutionDAO.findRecent(Integer.valueOf(numbersSolution));
        List<Solution> recentSolutions = SolutionDAO.findRecent(2);

        req.setAttribute("recentSolutions", recentSolutions);

        try {

           Connection connection = DbUtil.getConn();
           //Connection connection = SchoolConn.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM solutions");


            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int a = rs.getInt("solutuion_id");
                int b = rs.getInt("author_id");
                String c = rs.getString("body");

                System.out.println("id solution: " + a + " , id author: " + b + " , solution is: " + c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}

