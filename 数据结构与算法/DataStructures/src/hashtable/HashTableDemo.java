package hashtable;

import java.util.Scanner;

/**
 * @Description hashtable
 * @ClassName HashTableDemo
 * @Author zzq
 * @Date 2020/8/4 17:37
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        Scanner scanner = new Scanner(System.in);
        char c;
        while (true) {
            System.out.println("a: 添加雇员");
            System.out.println("s: 显示雇员");
            System.out.println("f: 查找雇员");
            System.out.println("e: 退出系统");
            c = scanner.next().charAt(0);
            switch (c) {
                case 'a':
                    System.out.print("输入id：");
                    int id = scanner.nextInt();
                    System.out.print("输入名字：");
                    String name = scanner.next();
                    Employee emp = new Employee(id, name);  //根据输入的id，姓名创建对象
                    hashTable.add(emp);
                    break;
                case 's':
                    hashTable.show();
                    break;
                case 'f':
                    System.out.print("请输入要查找的id：");
                    id = scanner.nextInt();
                    hashTable.find(id);
                    break;
                case 'e':
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class HashTable {
    private int size;   //数组的大小
    private EmployeeLinkedList[] employeeLinkedListArray;

    public HashTable(int size) {
        this.size = size;
        this.employeeLinkedListArray = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {    //给数组每个索引位置创建一个新的链表
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    /**
     * @Description hashtable：增加
     * @Param [emp]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 18:04
     */
    public void add(Employee emp) {
        int listId = hashFun(emp.id);   //得到应该放入那条链表
        employeeLinkedListArray[listId].add(emp);   //将emp加到索引为listId的链表中
    }

    /**
     * @Description hashtable：遍历
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 18:12
     */
    public void show() {
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i].show(i);
        }
    }

    /**
     * @Description hashtable：查找
     * @Param [id]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 18:55
     */
    public void find(int id) {
        int listId = hashFun(id);
        try {
            Employee employee = employeeLinkedListArray[listId].find(id);
            if (employee == null) {
                System.out.println("链表没有此数据");
            } else {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @Description 得到散列值
     * @Param [id]
     * @Return int
     * @Author zzq
     * @Date 2020/8/4 18:08
     */
    public int hashFun(int id) {
        return id % size;
    }

}

class EmployeeLinkedList {
    private Employee head;

    /**
     * @Description 链表：增
     * @Param [emp]
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 17:46
     */
    public void add(Employee emp) {
        if (head == null) {    //如果添加的是第一个员工
            head = emp;
            return;
        }
        Employee temp = head;
        while (temp.next != null)   //遍历链表找到最后一个元素
            temp = temp.next;
        temp.next = emp;    //加入链表的最后
    }

    /**
     * @Description 链表：打印
     * @Param null
     * @Return void
     * @Author zzq
     * @Date 2020/8/4 17:58
     */
    public void show(int i) {
        if (head == null) {   //如果链表为空，提示并退出
            System.out.println("第" + (i + 1) + "链表为空");
            return;
        }
        System.out.print("第" + (i + 1) + "链表信息=>");
        Employee temp = head;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * @Description 链表：查找
     * @Param [id]
     * @Return hashtable.Employee
     * @Author zzq
     * @Date 2020/8/4 18:45
     */
    public Employee find(int id) {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        Employee temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}


class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
