import com.zzq.mapper.StudentMapper;
import com.zzq.mapper.TeacherMapper;
import com.zzq.pojo.Student;
import com.zzq.pojo.Teacher;
import com.zzq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description TODO
 * @ClassName MyTest
 * @Author zzq
 * @Date 2021/6/25 20:51
 */
public class MyTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getAllTeacher();
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getAllStudent();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudentAndTeacher();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherAndStudent();
        System.out.println(teacher);
    }
}
