package br.ufjf.dcc192;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TarefaDAO {

    private static TarefaDAO instancia;
    private static Connection conexao;

    public static TarefaDAO getInstace() {
        if (instancia == null) {
            instancia = new TarefaDAO();
        }
        return instancia;
    }

    public TarefaDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/dcc-192-2018-1"
                                , "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Tarefa> listAll() {
        List<Tarefa> tarefas = new ArrayList<>();
        try {
            Statement comando =  conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,titulo from tarefa");
            while(resultado.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setTitulo(resultado.getString("titulo"));
                tarefa.setId(resultado.getLong("id"));
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
        try{
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO tarefa(titulo) VALUES('%S')", 
                    titulo));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void delete(Long id) {
        try{
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM tarefa WHERE id=%d", 
                    id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
