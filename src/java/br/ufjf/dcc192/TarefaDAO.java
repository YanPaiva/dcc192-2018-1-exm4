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

    public List<Tarefa> listAll() {
        List<Tarefa> tarefas = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,titulo from tarefa");
            while (resultado.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultado.getLong("id"));
                tarefa.setTitulo(resultado.getString("titulo"));
                tarefas.add(tarefa);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefas;
    }

    void create(String titulo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO tarefa(titulo) VALUES('%s')", titulo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM tarefa WHERE id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
