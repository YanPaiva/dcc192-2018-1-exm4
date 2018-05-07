package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TarefaDAO {

    private static Connection conexao;
    private static TarefaDAO instancia;

    public static TarefaDAO getInstance() {
        if (instancia == null) {
            instancia = new TarefaDAO();
        }
        return instancia;
    }

    public TarefaDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/dcc192-2018-1", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> listAll() {
        List<String> tarefas = new ArrayList<>();
        try {
            tarefas.add("Comprar ovos");
            tarefas.add("Comprar farinha");
            tarefas.add("Comprar açúcar");
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT titulo from tarefas");
            while (resultado.next()) {
                tarefas.add(resultado.getString("titulo"));

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefas;
    }

}
