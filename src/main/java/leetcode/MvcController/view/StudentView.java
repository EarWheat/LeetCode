package leetcode.MvcController.view;

import leetcode.MvcController.model.Student;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-25 10:23
 * @desc:
 */
public class StudentView {
    public void ShowView(Student student){
        System.out.println("name:" + student.getName());
        System.out.println("no:" + student.getNo());
    }
}
