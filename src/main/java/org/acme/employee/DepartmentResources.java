package org.acme.employee;
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
@Tag(name="Departments")
public class DepartmentResources {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createDepartment(DepartmentEntity departmentEntity) {
        departmentEntity.persist();
        return Response.status(Status.CREATED).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllDepartments() {
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
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteDepartment(@PathParam("id") Long id) {
        DepartmentEntity.deleteById(id);
        return Response.noContent().build();
    }


}
