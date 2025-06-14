package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lskar.librarysystem.entity.Administrator;

import java.util.List;

@Mapper
public interface AdministratorMapper {
    int insertAdmin(Administrator administrator);
    int deleteAdminByIds(List<String> ids);
    int updateAdminBy(Administrator administrator);
    Administrator selectAdminById(String id);
}
