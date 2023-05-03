
package Model;
import java.util.Date;
/**
 *
 * @author marcelo
 */
public class Project {
    //atributos da tabela project no BD
    private int ID;
    private String name;
    private String description;
    private Date createdAt;
    private Date updateAt;

    //Métodos
    //Construtor
    public Project(int ID, String name, String description, Date createdAt, Date updateAt) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    
    public Project (){
        this.createdAt = new Date();
    }
    //Métodos de acesso

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    //Métodos especiais
    //to string (Exibe dados na tela

    @Override
    public String toString() {
        return "Project{" + "ID=" + ID + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt + ", updateAt=" + updateAt + '}';
    }
    
    
    
}
