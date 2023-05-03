package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author marcelo
 * Fazendo a conex�o da aplica��o com o BD
 */
public class ConnectorFactory {
    //Estipular qual ser� o driver de conex�o
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    //Adicionar o jdbc nas dependencias
    //Caminho da conex�o com o banco (caminho)
    public static final String URL = "jdbc:mysql://localhost:3306/db_todoapp";
    //Definir usuario q ir� utilizar o BD
    public static final String USER = "root";
    //Definir senha do usuario
    public static final String PASS = "root";

    
    //Criar 3 m�todos: 1 p/ iniciar a sessao com o BD e 2 para encerra-la
    public static Connection GetConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER,PASS);
        }catch (ClassNotFoundException | SQLException ex){
            throw new RuntimeException ("ERRO NA CONEX�O COM O BANCO DE DADOS", ex);
        }
    }
    //Encerra a conex�o
    public static void closeConnection (Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        }catch (SQLException ex) {
            throw new RuntimeException ("ERRO AO FECHAR A CONEX�O COM O BANCO DE DADOS", ex);

        }
    }
    //Encerra a conex�o e o statement
    public static void closeConnection(Connection connection, PreparedStatement statement){
        closeConnection(connection);
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException ex){
            throw new RuntimeException ("ERRO AO ENCERRAR A CONEX�O COM O BANCO DE DADOS", ex);
    
        }
    }
    
     public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        closeConnection(connection);
        try{
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        }catch (SQLException ex){
            throw new RuntimeException ("ERRO AO ENCERRAR A CONEX�O COM O BANCO DE DADOS", ex);
    
        }
    }
}
