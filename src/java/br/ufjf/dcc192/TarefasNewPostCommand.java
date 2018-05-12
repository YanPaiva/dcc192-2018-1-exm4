package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TarefasNewPostCommand implements Command{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("Nova Tarefa");
        TarefaDAO.getInstace().create(titulo);
        response.sendRedirect("tarefas.html");
        
    }

}
