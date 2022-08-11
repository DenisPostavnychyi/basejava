package main.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static test.TestData.*;

@WebServlet("/resume")
public class ResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        response.getWriter().write(name == null ? "Hello Resumes!" : "Hello " + name + '!');*/


        PrintWriter pw = response.getWriter();
        pw.println("<html>");

        pw.println("<style>table, th, td {border:1px solid black;}</style>");

        pw.println("<h2>Resume Table</h2>");

        pw.println("<table style=\"width:50%\">");
        pw.println("<tr>");
        pw.println("<th>" + R1.getUuid() + "</th>");
        pw.println("<th>" + R1.getFullName() + "</th>");
        pw.println("</tr>");

        pw.println("<tr>");
        pw.println("<th>" + R2.getUuid() + "</th>");
        pw.println("<th>" + R2.getFullName() + "</th>");
        pw.println("</tr>");

        pw.println("<tr>");
        pw.println("<th>" + R3.getUuid() + "</th>");
        pw.println("<th>" + R3.getFullName() + "</th>");
        pw.println("</tr>");
        pw.println("</table>");

        pw.println("</html>");
    }
}
