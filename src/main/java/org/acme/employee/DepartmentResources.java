package org.acme.employee;

import java.util.Objects;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/departments")
@Tag(name = "departments")
public class DepartmentResources {
    @Inject
    DepartmentTransformer departmentTransformer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createDepartments(DepartmentEntity departmentEntity) {
        departmentEntity.persist();
        return Response.status(Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllDepartment() {
        return Response.ok(DepartmentEntity.listAll()).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentById(@PathParam("id") Long id) {
        DepartmentEntity departmentEntity = DepartmentEntity.findById(id);
        return Response.ok(departmentEntity).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateDepartment(@PathParam("id") Long id, Department department) {
        DepartmentEntity departmentEntity = DepartmentEntity.findById(id);

        if (Objects.nonNull(department.getCode())) {
            departmentEntity.code = department.getCode();
        }
        if (Objects.nonNull(department.getName())) {
            departmentEntity.name = department.getName();
        }
        if (Objects.nonNull(department.getShortName())) {
            departmentEntity.shortName = department.getShortName();
        }

        if (Objects.nonNull(department.getNotes())) {
            departmentEntity.notes = department.getNotes();
        }

        if (Objects.nonNull(department.getCreatedBy())) {
            departmentEntity.createdBy = department.getCreatedBy();
        }
        if (Objects.nonNull(department.getUpdatedBy())) {
            departmentEntity.updatedBy = department.getUpdatedBy();
        }
        if (Objects.nonNull(department.getCreatedAt())) {
            departmentEntity.createdAt = department.getCreatedAt();
        }
        if (Objects.nonNull(department.getUpdatedAt())) {
            departmentEntity.updatedAt = department.getUpdatedAt();
        }
        return Response.noContent().build();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteDepartment(@PathParam("id") Long id) {
        DepartmentEntity.deleteById(id);
        return Response.noContent().build();
    }

}
