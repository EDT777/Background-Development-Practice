package com.edt.many_one_Test;

import com.edt.mybatis_demo.utils.MybatisUtil;
import com.edt.one2many2one.many2many.domain.Student;
import com.edt.one2many2one.many2many.domain.Teacher;
import com.edt.one2many2one.many2many.mapper.StudentMapper;
import com.edt.one2many2one.many2many.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class many2manyTest {

    //根据id 删除学生
    @Test
    public void testDelete(){
        SqlSession session = MybatisUtil.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.delete(5L);
        studentMapper.deleteRelation(5L);
        session.commit();
        session.close();
    }


    //    根据id 查询学生,并查询其老师
    @Test
    public void testGet() {
        SqlSession session = MybatisUtil.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.get(5L));
//    使用额外SQL方式
//        让mybatis 帮我们发送额外sql,最终把查询的结果封装到学生对象的teachers

        session.close();
    }

    //保存两个学生和两个老师,且这两个老师都教了这两个学生
    @Test
    public void testSave() {
        Student s1 = new Student();
        s1.setName("小红");
        Student s2 = new Student();
        s2.setName("大红");

        Teacher teacher = new Teacher();
        teacher.setName("谭老师");
        Teacher teacher2 = new Teacher();
        teacher2.setName("陈老师");

        SqlSession session = MybatisUtil.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        teacherMapper.save(teacher);
        teacherMapper.save(teacher2);

        studentMapper.save(s1);
        studentMapper.save(s2);
        //在student实体类中关联了teacher 就用studentMapper 操作
        studentMapper.insertRelation(teacher.getId(), s1.getId());
        studentMapper.insertRelation(teacher.getId(), s2.getId());
        studentMapper.insertRelation(teacher2.getId(), s1.getId());
        studentMapper.insertRelation(teacher2.getId(), s2.getId());
        session.commit();
        session.close();
    }
}
