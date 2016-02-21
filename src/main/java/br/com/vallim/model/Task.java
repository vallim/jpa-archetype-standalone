package br.com.vallim.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_task_seq")
    @SequenceGenerator(name = "id_task_seq", sequenceName = "id_task_seq", allocationSize = 1)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.OPEN;

    @Column(name = "created_date")
    private LocalDate createdOn = LocalDate.now();

    public void setDescription(String description) {
        this.description = description;
    }

    public void inProgress() {
        status = TaskStatus.IN_PROGRESS;
    }

    public void done() {
        status = TaskStatus.DONE;
    }

    public enum TaskStatus {
        OPEN("Open"),
        IN_PROGRESS("In progress"),
        DONE("Done");

        private final String label;

        TaskStatus(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
