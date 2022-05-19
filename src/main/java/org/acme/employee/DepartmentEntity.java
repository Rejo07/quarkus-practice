package org.acme.employee;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name="department")
public class DepartmentEntity extends PanacheEntity {
    public Long id;

    public String code;

    public String name;

    public String shortName;

    public String details;

    public String notes;

    public String createdBy;
    public String updatedBy;
    public String createdAt;
    public String updatedAt;

}
