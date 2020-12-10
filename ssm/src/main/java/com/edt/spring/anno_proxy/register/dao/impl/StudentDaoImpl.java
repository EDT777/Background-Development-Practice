package com.edt.spring.anno_proxy.register.dao.impl;

import com.edt.spring.anno_proxy.register.dao.IStudentDao;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class StudentDaoImpl implements IStudentDao {

    private DataSource dataSource;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public void save(String username, String password) throws Exception {
        @Cleanup
        Connection connection = dataSource.getConnection();
        @Cleanup //此注解判断connection等 去释放资源
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student3(username, password)  values (?,?)");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.executeUpdate();
    }
}
