package com.lagou.controller;

import com.lagou.pojo.Resume;
import com.lagou.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/resume")
public class ResumeController {
     @Autowired
     private ResumeService resumeService;

     @RequestMapping("/query")
     @ResponseBody
     public Object query(HttpServletRequest request, HttpServletResponse response) {
          return resumeService.findAll();
     }

     @RequestMapping("/add")
     @ResponseBody
     public Object add(Resume resume) {
          resumeService.insert(resume);
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("list");
          return modelAndView;
     }

     @RequestMapping("/edit")
     @ResponseBody
     public Object edit(Resume resume) {
          resumeService.edit(resume);
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("list");
          return modelAndView;
     }

     @RequestMapping("/delete")
     @ResponseBody
     public Object delete(Long id) {
          resumeService.deleteById(id);
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("list");
          return modelAndView;
     }

     @RequestMapping("/toAdd")
     @ResponseBody
     public Object toAdd() {
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("add");
          return modelAndView;
     }

     @RequestMapping("/toEdit")
     @ResponseBody
     public Object toEdit(Long id) {
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("edit");
          modelAndView.addObject("resume",resumeService.findById(id));
          return modelAndView;
     }
     
     @RequestMapping("/toList")
     public ModelAndView toList(HttpServletRequest request, HttpServletResponse response) {
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("list");
         return modelAndView;
     }
}
