package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorMapper {
    void insertAdmin();
    void deleteAdminByIds(List<Integer> ids);
    void updateAdminBy();
    void selectAdminBy();
}
