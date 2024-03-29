package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Principal extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Integer contador = (Integer) servletContext.getAttribute("cont");
        ++contador;
        servletContext.setAttribute("cont", contador);
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        int matricula = (int) sessao.getAttribute("mat");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Principal</title>");            
            out.println("</head>");
            out.println("<body>");
            switch(matricula){
                case 123:
                    out.println("<h1>Olá, Pedro! :)</h1><br>");
                    out.println("<h2>Acesso número: " + contador + "</h2>");
                    break;
                case 456:
                    out.println("<h1>Olá, Beatriz! :)</h1><br>");
                    out.println("<h2>Acesso número: " + contador + "</h2>");
                    break;
                case 789:
                    out.println("<h1>Olá, Lucas! :)</h1><br>");
                    out.println("<h2>Acesso número: " + contador + "</h2>");
                    break;
                default:
                    out.println("<h1>Acesso negado.</h1>");
                    out.println("<h2>Acesso número: " + contador + "</h2>");
            } 
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        int contador = 0;
        getServletContext().setAttribute("cont", contador);
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