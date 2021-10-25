package leetcode.History.MvcController.controller;

import leetcode.History.MvcController.model.Student;
import leetcode.History.MvcController.view.StudentView;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-25 10:22
 * @desc:
 */
public class StudentController {
    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView view){
        this.student = student;
        this.studentView = view;
    }

    public void setStudentName(String name){
        student.setName(name);
    }

    private String getStudentName(){
        return student.getName();
    }

    private void setStudentNum(String no){
        student.setNo(no);
    }

    private String getStudentNo(){
        return student.getNo();
    }

    public void updateView(){
        studentView.ShowView(student);
    }
}
