package exer;

import Bean.Student;
import org.junit.jupiter.api.Test;
import util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @author zzq
 * @creat 2020-07-24 9:39
 */
public class Test2 {
    @Test
    public void testInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("四级/六级：");
        int type = scanner.nextInt();
        System.out.print("身份证号：");
        String IDCard = scanner.next();
        System.out.print("准考证号：");
        String examCard = scanner.next();
        System.out.print("学生姓名：");
        String studentName = scanner.next();
        System.out.print("所在城市：");
        String location = scanner.next();
        System.out.print("考试成绩：");
        int grade = scanner.nextInt();

        String sql = "insert into examstudent(`Type`,`IDCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) value(?,?,?,?,?,?)";
        int update = update(sql, type, IDCard, examCard, studentName, location, grade);

        if (update > 0)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
    }


    @Test
    public void testSelect() {
        System.out.println("请选择您要输入的类型：");
        System.out.println("a.准考证号");
        System.out.println("b.身份证号");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        if ("a".equalsIgnoreCase(choose)) {
            System.out.print("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select FlowID as flowID,Type as type,IDCard,ExamCard as examCard,StudentName as name,Location as location,Grade as grade from examstudent where examCard = ?";
            Student student = getInstance(Student.class, sql, examCard);
            if(student !=null)
                System.out.println(student);
            else
                System.out.println("输入有误");
        } else if ("b".equalsIgnoreCase(choose)) {
            System.out.print("请输入身份证号：");
            String IDCard = scanner.next();
            String sql = "select FlowID as flowID,Type as type,IDCard,ExamCard as examCard,StudentName as name,Location as location,Grade as grade from examstudent where IDCard = ?";
            Student student = getInstance(Student.class, sql, IDCard);
            if(student !=null)
                System.out.println(student);
            else
                System.out.println("输入有误");
        } else
            System.out.println("输入有误，请重新进入程序");
    }


    @Test
    public void testDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生的考号：");
        String examCard = scanner.next();
        String sql="delete from examstudent where examCard = ?";
        int delete = update(sql, examCard);
        if(delete>0)
            System.out.println("删除成功");
        else
            System.out.println("查无此人，请重新输入");
    }


    public int update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
        return 0;
    }


    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field declaredField = clazz.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
