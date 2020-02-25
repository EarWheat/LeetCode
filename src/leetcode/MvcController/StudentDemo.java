package leetcode.MvcController;

import leetcode.MvcController.controller.StudentController;
import leetcode.MvcController.model.Student;
import leetcode.MvcController.view.StudentView;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-25 10:27
 * @desc:
 */
public class StudentDemo {
    public static void main(String[] args) {

        //从数据库获取学生记录
        Student model  = retrieveStudentFromDatabase();

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //更新模型数据
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Robert");
        student.setNo("10");
        return student;
    }
}
