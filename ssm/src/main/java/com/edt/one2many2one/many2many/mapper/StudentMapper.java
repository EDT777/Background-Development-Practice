package com.edt.one2many2one.many2many.mapper;

import com.edt.one2many2one.many2many.domain.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    void save(Student student);

    void insertRelation(@Param("teacherId") Long teacherId, @Param("studentId") Long studentId);

    Student get(Long id);
    void delete(Long id);

    void deleteRelation(Long studentId);
}
