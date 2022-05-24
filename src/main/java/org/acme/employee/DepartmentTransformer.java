package org.acme.employee;

import java.util.List;

import org.acme.util.QuarkusMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface DepartmentTransformer {
    Department toResource(DepartmentEntity departmentEntity);

    List<Department> map(List<DepartmentEntity> departmentEntity);

    DepartmentEntity toEntity(Department department);
}
