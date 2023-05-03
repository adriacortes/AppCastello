
package Controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Project;
import Util.ConnectorFactory;
/**
 *
 * @author marcelo
 */
public class ProjectController {
    
    public void Save (Project project){
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "createdAt, "
                + "VALUES(?, ?, ?,?) ";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
                //Estabelece uma conexão com o banco
                connection = ConnectorFactory.GetConnection();
                //Cria um PreparedStatement que é uma classe usada p/ executar a query
                statement = connection.prepareStatement(sql);
                //Setando os valores
                statement.setString(1, project.getName());
                statement.setString(2, project.getDescription());
                statement.setDate(3, new Date(project.getCreatedAt().getTime()));
                
                //Executar sql para inserção de dados
                statement.execute();
                   }catch (SQLException ex){
                       throw new RuntimeException ("ERRO AO SALVAR O PROJETO", ex);
                   } finally {
                   ConnectorFactory.closeConnection(connection, statement);
                             }
    }
    
    public void Update (Project project){
        String sql = "UPDATE projects SET"
                + "name = ? "
                + "description = ?"
                + "createdAt = ?"
                + "updateAt = ?"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        
        try{
            //Estabelece uma conexão com o banco
                connection = ConnectorFactory.GetConnection();
                //Cria um PreparedStatement que é uma classe usada p/ executar a query
                statement = connection.prepareStatement(sql);
                
                //Setando os valores
                statement.setString(1, project.getName());
                statement.setString(2, project.getDescription());
                statement.setDate(3, new Date(project.getCreatedAt().getTime()));
                statement.setDate(4, new Date(project.getUpdateAt().getTime()));
                statement.setInt(5, project.getID());
                
                //Executar sql para inserção de dados
                statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException ("ERRO AO ATUALIZAR O PROJETO", ex);
                   } finally {
                   ConnectorFactory.closeConnection(connection, statement);
                             }
        }
    
    
    
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
        try{
        //Estabelece uma conexão com o banco
        connection = ConnectorFactory.GetConnection();
        //Cria um PreparedStatement que é uma classe usada p/ executar a query
        statement = connection.prepareStatement(sql);
        resultSet = statement.executeQuery();
        
        while (resultSet.next()){
            Project project = new Project();
            
            project.setID(resultSet.getInt("ID"));
            project.setName(resultSet.getString("name"));
            project.setDescription(resultSet.getString("description"));
            project.setCreatedAt(resultSet.getDate("CreateAt"));
            project.setUpdateAt(resultSet.getDate("UpdateAt"));
            
            //Adiciona o projeto recuperado para a lista de projetos
            projects.add(project);
        }       
        }catch (SQLException ex){
            throw new RuntimeException ("ERRO AO BUSCAR PROJETO", ex);
                   } finally {
                   ConnectorFactory.closeConnection(connection, statement);
                             }
        return projects;
    }
    
    
    public void RemoveById(int id){
        String sql = "DELETE FROM projects WHERE id = ?";       
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectorFactory.GetConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException ("ERRO AO DELETAR PROJETO", ex);
                   } finally {
                   ConnectorFactory.closeConnection(connection, statement);
                             }
    }
    }
