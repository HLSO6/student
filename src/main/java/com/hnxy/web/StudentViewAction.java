package com.hnxy.web;

import com.hnxy.entity.Student;
import com.hnxy.service.StudentService;
import com.hnxy.service.ViewService;
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
import java.util.Map;

/**
 * @author 陆辉
 * @create 2020-07-16 22:23
 */
@Controller
public class StudentViewAction {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ViewService viewService;

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

    /**
     * 统计视图区域
     */

    //分数线
    @RequestMapping("showView")
    public ModelAndView showView() {
        ModelAndView mv = new ModelAndView ();
        Map<String, Object> scoreLine = viewService.findScoreLine ();
        mv.addObject ( "scoreLine", scoreLine );
        mv.setViewName ( "showView.jsp" );
        return mv;
    }

    //地区学生人数
    @RequestMapping("findAreaStudents")
    @ResponseBody
    public List findAreaStudents() {
        return viewService.findAreaStudents ();
    }

    //地区学生过线人数
    @RequestMapping("findAreaStudentsByLine")
    @ResponseBody
    public List findAreaStudentsByLine() {
        return viewService.findAreaStudentsByLine ();
    }
}
