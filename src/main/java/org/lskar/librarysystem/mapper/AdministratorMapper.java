package org.lskar.librarysystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorMapper {
    void insertAdmin();
    void deleteAdminByIds(Integer[] ids);
    void updateAdminBy();
    void selectAdminBy();
}
