package coding.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/3/1 11:06 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/1 11:06 上午     liuzhaolu       firstVersion
 */
public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");

        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);
        dep4.addChild(dep6);
        dep3.addChild(dep7);
        dep3.addChild(dep4);
        dep1.addChild(dep3);
        dep1.addChild(dep8);
        System.out.println(Object.class.getClassLoader().toString());

        List<Department> subDepartments = DepartmentTest.getSub(3, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门，一直到叶子节点)
     * 要求：不能新增参数，不能增加static变量
     *
     * @param id
     * @return
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        for (Department department: allDepartment) {
            if(department.getId() == id){
                return department.getChild();
            }
        }
        return null;
    }
}