package com.lagou.service;

import com.lagou.pojo.Resume;

import java.util.List;

public interface ResumeService {
    public List<Resume> findAll();

    public Resume findById(Long id);

    public boolean insert(Resume resume);

    public boolean edit(Resume resume);

    public boolean deleteById(Long id);
}
