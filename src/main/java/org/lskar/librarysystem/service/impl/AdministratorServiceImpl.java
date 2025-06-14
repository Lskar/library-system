package org.lskar.librarysystem.service.impl;

import org.lskar.librarysystem.entity.Administrator;
import org.lskar.librarysystem.exception.NotFoundException;
import org.lskar.librarysystem.mapper.AdministratorMapper;
import org.lskar.librarysystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public void update(Administrator administrator) {
        int result = administratorMapper.updateAdminBy(administrator);
        if (result == 0) {
            throw new NotFoundException("更新数据失败");
        }
    }

    @Override
    public void insert(Administrator administrator) {

        int result = administratorMapper.insertAdmin(administrator);
        if (result == 0) {
            throw new NotFoundException("插入数据失败");
        }
    }

    @Override
    public void delete(List<String> ids) {
        int result = administratorMapper.deleteAdminByIds(ids);
        if (result == 0) {
            throw new NotFoundException("批量删除数据失败");
        }
    }

    @Override
    public Administrator selectById(String id) {
        Administrator administrator = administratorMapper.selectAdminById(id);
        if(administrator == null){
            throw new NotFoundException("未找到编号为"+id+"的管理员");
        }
        return administrator;
    }

}

