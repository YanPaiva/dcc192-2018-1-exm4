/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YanNotebook
 */
public class TarefasListCommand implements Command{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/tarefas/list.jsp");
        List<Tarefa> tarefas = TarefaDAO.getInstace().listAll();
        request.setAttribute("titulo", "Lista de Tarefas");
        request.setAttribute("tarefas",tarefas);
        dispachante.forward(request, response);
    }
    
}
