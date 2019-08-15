package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String senha = request.getParameter("senha");
        
        if (matricula == 000 && senha.equals("000")){ // Para chegar ao resultado "Acesso negado".
            HttpSession sessao = request.getSession();
            sessao.setAttribute("mat", matricula);
            RequestDispatcher rd = request.getRequestDispatcher("/Principal");
            rd.forward(request, response);
        } else if (matricula == 123 && senha.equals("java")){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("mat", matricula);
            RequestDispatcher rd = request.getRequestDispatcher("/Principal");
            rd.forward(request, response);
        } else if (matricula == 456 && senha.equals("servlet")){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("mat", matricula);
            RequestDispatcher rd = request.getRequestDispatcher("/Principal");
            rd.forward(request, response);
        } else if (matricula == 789 && senha.equals("web")){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("mat", matricula);
            RequestDispatcher rd = request.getRequestDispatcher("/Principal");
            rd.forward(request, response);
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Login</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bad Login! :@</h1>");
                out.println("</body>");
                out.println("</html>");
            } 
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}