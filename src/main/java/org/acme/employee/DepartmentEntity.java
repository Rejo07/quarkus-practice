package org.acme.employee;

import java.sql.Timestamp;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name = "department")
public class DepartmentEntity extends PanacheEntity {
    public Long id;

    public String code;

    public String name;

    public String shortName;

    public String details;

    public String notes;

    public String createdBy;
    public String updatedBy;
    public Timestamp createdAt;
    public Timestamp updatedAt;

}
