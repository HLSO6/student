package com.hnxy.web;

import com.hnxy.entity.Student;
import com.hnxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 陆辉
 * @create 2020-07-16 22:23
 */
@Controller
public class StudentViewAction {

    @Autowired
    private StudentService studentService;


    @InitBinder
    public void dateBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor ( java.util.Date.class, new CustomDateEditor ( new SimpleDateFormat ( "yyyy-MM-dd" ), true ) );
    }


    @RequestMapping("findStudentsByPage")
    public ModelAndView findStudentsByPage(Integer pageIndex) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        //总条数
        int counts = studentService.findStudentsByPageCount ();

        //一页条数
        int pageSize = 7;

        //总页数
        int pageCount = (counts % pageSize == 0) ? (counts / pageSize) : (counts / pageSize + 1);


        List<Student> students = studentService.findStudentsByPage ( pageIndex - 1, pageSize );

        ModelAndView mv = new ModelAndView ();
        mv.addObject ( "pageIndex", pageIndex );
        mv.addObject ( "counts", counts );
        mv.addObject ( "pageSize", pageSize );
        mv.addObject ( "pageCount", pageCount );
        mv.addObject ( "students", students );
        mv.setViewName ( "showPage.jsp" );
        return mv;
    }
}
