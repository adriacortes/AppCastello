
package Model;
import java.util.Date;
/**
 *
 * @author marcelo
 */
public class Task {
    private int ID;
    private int id_project;
    private String name_project;
    private String description;
    private String notes;
    private boolean isCompleted;
    private Date deadline;
    private Date createdAt;
    private Date updateAt;

    
    //Construtor
    public Task(int ID, int id_project, String name_project, String description, String notes, boolean isCompleted, Date deadline, Date createdAt, Date updateAt) {
        this.ID = ID;
        this.id_project = id_project;
        this.name_project = name_project;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    
    public Task (){
    this.createdAt = new Date();
    }

    //Métodos acessores
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
    
    //Método de exibição
    @Override
    public String toString() {
        return "Task{" + "ID=" + ID + ", id_project=" + id_project + ", name_project=" + name_project + ", description=" + description + ", notes=" + notes + ", isCompleted=" + isCompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updateAt=" + updateAt + '}';
    }
    
}
