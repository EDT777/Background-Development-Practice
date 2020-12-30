package cn.wolfcode.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.wolfcode.domain.Appointment;
import cn.wolfcode.mapper.AppointmentMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IAppointmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private AppointmentMapper appointmentMapper;

    @Autowired
    public void setAppointmentMapper(AppointmentMapper appointmentMapper) {
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    @Transactional
    public void save(Appointment appointment) {
        //设置创建时间
        appointment.setCreateTime(new Date());
        //设置预约单流水号(年月日时分秒+5位随机数组成)，如2020102308515905427
        String ano = DateUtil.format(new Date(), "yyyyMMddHHmmss")
                + RandomUtil.randomNumbers(5);
        appointment.setAno(ano);
        appointmentMapper.insert(appointment);
    }

    @Override
    @Transactional
    public void update(Appointment appointment) {
        appointmentMapper.updateByPrimaryKey(appointment);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        appointmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Appointment get(Long id) {
        return appointmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Appointment> listAll() {
        return appointmentMapper.selectAll();
    }

    @Override
    public PageInfo<Appointment> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(),"status asc,appointment_time asc");
        List<Appointment> appointments = appointmentMapper.selectForList(qo);
        return new PageInfo<>(appointments);
    }

    @Override
    public void updateStatus(Integer status, Long id) {
        appointmentMapper.updateStatus(status,id);
    }

    @Override
    public Appointment getByAppointmentAno(String ano) {
        return appointmentMapper.selectByAppointmentAno(ano);
    }
}
