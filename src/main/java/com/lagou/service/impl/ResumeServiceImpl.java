package com.lagou.service.impl;

import com.lagou.dao.ResumeDao;
import com.lagou.pojo.Resume;
import com.lagou.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> findAll() {
        return resumeDao.findAll();
    }

    @Override
    public Resume findById(Long id) {
        Optional<Resume> byId = resumeDao.findById(id);
        return byId.get();
    }

    @Override
    public boolean insert(Resume resume) {
        resumeDao.save(resume);
        return true;
    }

    @Override
    public boolean edit(Resume resume) {
        resumeDao.saveAndFlush(resume);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        resumeDao.deleteById(id);
        return true;
    }
}
