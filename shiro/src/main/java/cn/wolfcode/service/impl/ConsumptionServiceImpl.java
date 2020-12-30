package cn.wolfcode.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.wolfcode.domain.Appointment;
import cn.wolfcode.domain.Consumption;
import cn.wolfcode.enums.AppointmentStatusEnum;
import cn.wolfcode.enums.ConsumptionStatusEnum;
import cn.wolfcode.mapper.ConsumptionMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IAppointmentService;
import cn.wolfcode.service.IConsumptionService;
import cn.wolfcode.util.UserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ConsumptionServiceImpl implements IConsumptionService {

    private ConsumptionMapper consumptionMapper;

    @Autowired
    private IAppointmentService appointmentService;

    @Autowired
    public void setConsumptionMapper(ConsumptionMapper consumptionMapper) {
        this.consumptionMapper = consumptionMapper;
    }

    @Override
    @Transactional
    public void save(Consumption consumption) {
        Date date = new Date();
        //设置结算单流水号
        consumption.setCno(DateUtil.format(date,"yyyyMMddHHmmss")+ RandomUtil.randomNumbers(5));
        //设置结算状态为待结算
        consumption.setStatus(ConsumptionStatusEnum.CONSUME.getValue());
        //设置进店时间
        consumption.setCheckinTime(date);
        //设置创建人(当前登录用户)
        consumption.setCreateUser(UserContext.getCurrentUser());
        //设置创建时间
        consumption.setCreateTime(date);
        consumptionMapper.insert(consumption);
    }

    @Override
    @Transactional
    public void update(Consumption consumption) {
        consumptionMapper.updateByPrimaryKey(consumption);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        consumptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Consumption get(Long id) {
        return consumptionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Consumption> listAll() {
        return consumptionMapper.selectAll();
    }

    @Override
    public PageInfo<Consumption> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(),"c.status asc,c.create_time asc");
        List<Consumption> consumptions = consumptionMapper.selectForList(qo);
        return new PageInfo<>(consumptions);
    }

    @Override
    @Transactional
    public Consumption saveByAppointmentAno(String ano) {
        //根据预约单流水号查询预约单信息
        Appointment appointment = appointmentService.getByAppointmentAno(ano);
        //修改预约单状态为消费中
        appointmentService.updateStatus(AppointmentStatusEnum.CONSUME.getValue(),appointment.getId());
        //创建结算单
        Consumption consumption = new Consumption();
        //设置客户姓名
        consumption.setCustomerName(appointment.getContactName());
        //设置客户联系方式
        consumption.setCustomerTel(appointment.getContactTel());
        //关联预约单流水号
        consumption.setAppointmentAno(ano);
        //设置消费门店
        consumption.setBusiness(appointment.getBusiness());
        //保存到数据库中
        this.save(consumption);
        return consumption;
    }
}
