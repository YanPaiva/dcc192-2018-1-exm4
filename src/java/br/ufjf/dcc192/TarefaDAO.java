package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    private static TarefaDAO instancia;

    public static TarefaDAO getInstance() {
        if (instancia == null) {
            instancia = new TarefaDAO();
        }
        return instancia;
    }

    public List<String> listAll() {
        List<String> tarefas = new ArrayList<>();
        tarefas.add("Comprar ovos");
        tarefas.add("Comprar farinha");
        tarefas.add("Comprar açúcar");
        return tarefas;
    }

}
