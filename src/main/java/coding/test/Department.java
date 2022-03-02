package coding.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/3/1 11:06 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/1 11:06 上午     liuzhaolu       firstVersion
 */
public class Department {
    /**
     * id
     */
    private int id;
    /**
     * parent id
     */
    private int pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 子部门
     */
    private List<Department> child;


    public Department(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }

    public void addChild(Department department) {
        List<Department> child = department.getChild();
        if(this.child == null){
            this.child = new ArrayList<>();
        }
        if(child != null){
            this.child.addAll(child);
        }
        this.child.add(department);
    }


    public List<Department> getChild() {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        return child;
    }

}
