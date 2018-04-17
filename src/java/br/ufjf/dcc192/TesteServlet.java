package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
@WebServlet(name = "TesteServlet", urlPatterns = {"/teste.html", "/teste2.html"})
public class TesteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("x");
        Integer idade;
        try{
             idade= Integer.parseInt(request.getParameter("y"));
        }catch(Exception e){
            idade = 0;
        }
        if(nome==null || nome.isEmpty()){
            nome = "Desconhecido";
        }
        request.setAttribute("titulo", "Detalhes de "+nome);
        request.setAttribute("nome", nome);
        request.setAttribute("idade", idade);
        
        if("/teste2.html".equals(request.getServletPath())){
            List<Integer> numeros = new ArrayList<>();
            Random r = new Random();
            for(int i =0; i< 10; i++){
                numeros.add(r.nextInt(100)+1);
            }
            request.setAttribute("numeros", numeros);
        }
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/teste.jsp");
        despachante.forward(request, response);
    }

    
}
