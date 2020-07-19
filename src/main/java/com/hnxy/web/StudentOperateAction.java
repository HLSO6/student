package com.hnxy.web;

import com.hnxy.entity.Student;
import com.hnxy.service.AreaService;
import com.hnxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-17 19:16
 */
@Controller
public class StudentOperateAction {
    @Autowired
    private StudentService studentService;

    @Autowired
    private AreaService areaService;

    @InitBinder
    public void dateBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor ( java.util.Date.class, new CustomDateEditor ( new SimpleDateFormat ( "yyyy-MM-dd" ), true ) );
    }

    @RequestMapping("deleteStudentById")
    public String deleteStudentById(Integer sid) {
        studentService.deleteStudentById ( sid );
        return "findStudentsByPage";
    }

    @RequestMapping("insertStudent")
    public String insertStudent(Student stu) {
        studentService.insertStudent ( stu );
        return "findStudentsByPage";
    }

    @RequestMapping("updateStudent")
    public String updateStudent(Student stu) {
        studentService.updateStudent ( stu );
        return "findStudentsByPage";
    }

    @RequestMapping("findStudentById")
    public ModelAndView findStudentById(Integer id) {
        Student studentById = studentService.findStudentById ( id );
        ModelAndView mv =new ModelAndView ();
        mv.addObject ( "student", studentById);
        mv.setViewName ( "updateStudent.jsp" );
        return mv;
    }

    @RequestMapping("findAllAreas")
    @ResponseBody
    public List findAllAreas() {
        return areaService.findAllAreas ();
    }

    @RequestMapping("findSchoolsById")
    @ResponseBody
    public List findSchoolsById(Integer id) {
        return areaService.findAllSchoolById (id);
    }

}
