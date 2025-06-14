package org.lskar.librarysystem.service.impl;

import org.lskar.librarysystem.entity.LoginInfo;
import org.lskar.librarysystem.entity.Reader;
import org.lskar.librarysystem.exception.NotFoundException;
import org.lskar.librarysystem.mapper.BorrowRecordMapper;
import org.lskar.librarysystem.mapper.ReaderMapper;
import org.lskar.librarysystem.service.ReaderService;
import org.lskar.librarysystem.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Override
    public List<Reader> list() {
        List<Reader> readers = readerMapper.selectAllReader();
        if(readers == null){
            throw new NotFoundException("没有找到数据");
        }
        return readers;
    }

    @Override
    public Reader getReaderById(String id) {
        Reader reader = readerMapper.selectReaderById(id);
        if (reader == null) {
            throw new NotFoundException("查询不到id为" + id + "的读者信息");
        }
        return reader;
    }

    @Override
    public void insert(Reader reader) {
        int result = readerMapper.insertReader(reader);
        if (result == 0) {
            throw new NotFoundException("插入数据失败");
        }
    }

    @Override
    public void update(Reader reader) {
        int result = readerMapper.updateReader(reader);
        if (result == 0) {
            throw new NotFoundException("更新数据失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String id) {
        int result = readerMapper.deleteReaderById(id);
        if (result == 0) {
            throw new NotFoundException("删除数据失败");
        }
        borrowRecordMapper.deleteRecordByReaderId(id);
    }

    @Override
    public LoginInfo login(Reader reader) {

        Reader readerImpl = readerMapper.selectReaderByIdAndPassword(reader);
        if(readerImpl == null){
            throw new NotFoundException("用户id或密码错误");
        }
        Map<String, Object> claims = Map.of("userId",readerImpl.getUserId(),"name",readerImpl.getName());
        String token = JwtUtils.generateToken(claims);
        return new LoginInfo(readerImpl.getUserId(),readerImpl.getName(),token);
    }



}
