package se.ecutb.hala.jpa_boot_project.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class TodoItem {
    private String todoId;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean done = false;

    public TodoItem(String title, String description, LocalDateTime deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    TodoItem(){

    }

    public String getTodoId() {
        return todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void toggleDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return done == todoItem.done &&
                Objects.equals(todoId, todoItem.todoId) &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(description, todoItem.description) &&
                Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, title, description, deadline, done);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TodoItem{");
        sb.append("todoId='").append(todoId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", deadline=").append(deadline);
        sb.append(", done=").append(done);
        sb.append('}');
        return sb.toString();
    }
}
