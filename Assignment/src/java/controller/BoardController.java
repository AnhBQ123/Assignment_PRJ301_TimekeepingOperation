/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AbsenceDBContext;
import dal.AccountDBContext;
import dal.DaysLeaveDBContext;
import dal.OverTimeDBContext;
import dal.SyntaxDbContext;
import dal.TimeSheetDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Account;
import helper.TimeHelper;
import java.sql.Date;
import java.util.Calendar;
import model.Absence;
import model.LeaveDays;
import model.Syntax;

/**
 *
 * @author BuiQuangAnh_HE141637
 */
public class BoardController extends HttpServlet {
   AccountDBContext adb = new AccountDBContext();
   TimeSheetDBContext tsdb = new TimeSheetDBContext();
   TimeHelper th = new TimeHelper();
   AbsenceDBContext a = new AbsenceDBContext();
   SyntaxDbContext s = new SyntaxDbContext();
    DaysLeaveDBContext dldb = new DaysLeaveDBContext();
    OverTimeDBContext otdb = new OverTimeDBContext();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BoardController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BoardController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ArrayList<Syntax>syntaxes = s.getSyntax();
         
        request.setAttribute("listSyntax", syntaxes);
        if(request.getParameter("month") == null && request.getParameter("year") == null){
            ArrayList<Account>accounts = adb.getListAccount();
     
            Calendar cal = Calendar.getInstance();
            if(accounts != null && accounts.size()>0){
                for(Account account : accounts){
                    Absence ab = a.getAbsence(account.getUsername(),cal.get(Calendar.MONTH)+1, cal.get(Calendar.MONTH)+1);
                    ArrayList<Date>absenceDate = a.getListDateAbsence(account.getUsername(),cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR));
                    account.setTimesheets(tsdb.getListTimeSheetByMonth(account.getUsername(),th.getMonth(new java.util.Date())+1));
                    account.setAbsences(ab);
                    account.setAbsenceDates(absenceDate);
                    account.setLeavedays(dldb.getDaysLeaveByMY(account.getUsername(),cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR)));
                    account.setOvertime(otdb.getOverTimeByMY(account.getUsername(),cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR)));
                    
                }
                Calendar cal1 = Calendar.getInstance();
                cal1.set(cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH),1);
                
                request.setAttribute("days",cal1.getActualMaximum(Calendar.DAY_OF_MONTH));
                request.setAttribute("listAccount",accounts );
                request.getRequestDispatcher("view/board.jsp").forward(request, response);
            }else{
                try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<h1>There isn't any data</h1>");
                out.println("</body>");
                out.println("</html>");
                }
            }
        }
       
        else if(request.getParameter("month") != null && request.getParameter("year") != null){
            ArrayList<Account>accounts = adb.getListAccount();
     
            Calendar cal = Calendar.getInstance();
            if(accounts != null && accounts.size()>0){
                for(Account account : accounts){
                    Absence ab = a.getAbsence(account.getUsername(),cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR));
                    ArrayList<Date>absenceDate = a.getListDateAbsence(account.getUsername(),Integer.parseInt(request.getParameter("month")),Integer.parseInt(request.getParameter("year")));
                    account.setTimesheets(tsdb.getListTimeSheetByMonth(account.getUsername(),Integer.parseInt(request.getParameter("month"))));
                    account.setAbsences(ab);
                    account.setAbsenceDates(absenceDate);
                    account.setLeavedays(dldb.getDaysLeaveByMY(account.getUsername(),Integer.parseInt(request.getParameter("month")), Integer.parseInt(request.getParameter("year"))));
                    account.setOvertime(otdb.getOverTimeByMY(account.getUsername(),Integer.parseInt(request.getParameter("month")), Integer.parseInt(request.getParameter("year"))));
                    
                }
                cal.set(Integer.parseInt(request.getParameter("year")),Integer.parseInt(request.getParameter("month"))-1,1);
                
                request.setAttribute("days",cal.getActualMaximum(Calendar.DAY_OF_MONTH));   
                request.setAttribute("listAccount",accounts );
                request.getRequestDispatcher("view/board.jsp").forward(request, response);
            }else{
                try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<h1>There isn't any data</h1>");
                out.println("</body>");
                out.println("</html>");
                }
            }
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
