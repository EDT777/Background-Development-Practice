package cn.wolfcode.service;

import cn.wolfcode.domain.Appointment;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAppointmentService {
    void save(Appointment appointment);
    void update(Appointment appointment);
    void delete(Long id);
    Appointment get(Long id);
    List<Appointment> listAll();
    // 分页查询的方法
    PageInfo<Appointment> query(QueryObject qo);
    //修改预约单状态
    void updateStatus(Integer status, Long id);

    Appointment getByAppointmentAno(String ano);
}