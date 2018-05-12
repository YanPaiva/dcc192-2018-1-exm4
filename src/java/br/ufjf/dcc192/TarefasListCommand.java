package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TarefasListCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/tarefas/list.jsp");
        List<Tarefa> tarefas = TarefaDAO.getInstance().listAll();
        request.setAttribute("titulo", "Lista de Tarefas");
        request.setAttribute("tarefas", tarefas);
        dispacher.forward(request, response);
    }
    
}
