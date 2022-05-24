package org.acme.employee;

import java.sql.Timestamp;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class Department {
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
