
package Controller;
import Model.Task;
import Util.ConnectorFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author marcelo
 */
public class TaskController {
    public void Save (Task task){
        String sql = "INSERT INTO tasks(PROJECT_ID, NAME, DESCRIPTION, STATUS, NOTES, DEADLINE, CREATEDAT, UPDATEDAT)VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectorFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getId_project());
            statement.setString(2, task.getName_project());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date( task.getUpdateAt().getTime()));
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException ("ERRO AO SALVAR A TAREFA" + ex.getMessage(),ex);
        }finally { //garantiir acesso à conexão para sempre fecha-la
            ConnectorFactory.closeConnection(connection, statement);
            //fecha a conexão e o statement 
            
        }
    }
   
    public void Update (Task task){
        String sql = "UPDATE tasks SET" 
                + "id_project = ?,"
                + "name_project = ?,"
                + "description = ?,"
                        + "notes = ?,"
                        + "iscompleted = ?,"
                        + "deadline = ?,"
                        + "createdAt = ?"
                        + "updateAt = ?"
                        +   "WHERE id =?";
                
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //Estabelecendo a conexao com o BD
            connection = ConnectorFactory.GetConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            //Setando todos os valores do statement
            statement.setInt(1, task.getId_project());
            statement.setString(2, task.getName_project());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date( task.getUpdateAt().getTime()));
            statement.setInt(9, task.getID());
            //Executando a query
            statement.execute();
            
            
        } catch (Exception ex){
            throw new RuntimeException ("ERRO AO ATUALIZAR A TAREFA" + ex.getMessage(),ex);
        }finally { //garantiir acesso à conexão para sempre fecha-la
            ConnectorFactory.closeConnection(connection, statement);
            //fecha a conexão e o statement 
            
        }
        
        
    }
    
    public void RemovebyID (int id_Project) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id=?";
        Connection connection = null;
        PreparedStatement statement = null;
       
        try{
            //Estabelece conexão com BD
            connection = ConnectorFactory.GetConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            //Setando os valores
            statement.setInt(1, id_Project);
            //Executando a query
            statement.execute();
            
        }catch (Exception ex){
            throw new RuntimeException ("ERRO AO DELETAR A TAREFA" + ex.getMessage(), ex);
        } finally { 
            ConnectorFactory.closeConnection(connection, statement);
                    }
        
        
    }
    
    public List<Task> getAll (int id_Project){
        String sql = "SELECT * FROM tasks WHERE id_project = ?";
        
        Connection connection = null;
        PreparedStatement statement =  null;
        //variavel q guarda o retorno do BD
        ResultSet resultSet=null;
        //Criar uma lista de tarefas
        List <Task> tasks = new ArrayList<Task>();
        
        try{
            connection= ConnectorFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            
            //Setando o valor q corresponde oa filtro de busca
            statement.setInt(1, id_Project);
            //executeQuery -> Devolve o valor de resposta para o select (execução query)
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){ //enqto houverem valores a ser percorridos
                Task task = new Task();
                task.setID(resultSet.getInt("ID"));
                task.setId_project(resultSet.getInt("id_project"));
                task.setName_project(resultSet.getString("name+project"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("isCompleted"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdateAt(resultSet.getDate("updateAt"));
                
            //Colocar a tarefa dentro da lista de tarefas   
            
            tasks.add(task);
            
            }
        }catch (Exception ex){
            throw new RuntimeException ("ERRO AO INSERIR A TAREFA" + ex.getMessage(), ex);
        } finally { 
            ConnectorFactory.closeConnection(connection, statement, resultSet);
                    }
         
    
        //Lista de tarefas que foi carregada deve ser retornada
            return tasks;
    }
}

