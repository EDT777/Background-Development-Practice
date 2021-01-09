package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Appointment;
import cn.wolfcode.enums.AppointmentStatusEnum;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IAppointmentService;
import cn.wolfcode.service.IBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private IAppointmentService appointmentService;

    @Autowired
    private IBusinessService businessService;

    @Autowired
    public void setAppointmentService(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("pageInfo", appointmentService.query(qo));
        model.addAttribute("enums", AppointmentStatusEnum.values());
        model.addAttribute("businesses",businessService.listAll());
        return "appointment/list"; // /WEB-INF/views/appointment/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            appointmentService.delete(id);
        }
        return "redirect:/appointment/list";
    }


    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Appointment appointment) {
        if (appointment.getId() == null) {
            //设置状态为履行中
            appointment.setStatus(AppointmentStatusEnum.PREFORM.getValue());
            appointmentService.save(appointment);
        } else {
            appointmentService.update(appointment);
        }
        return "redirect:/appointment/list";
    }

    //互联网首页客户使用的提交预约功能，不需要登录也不需要权限都可以提交
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Appointment appointment) {
        //设置状态为待确认
        appointment.setStatus(AppointmentStatusEnum.PEND.getValue());
        appointmentService.save(appointment);
        return new JsonResult();
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public JsonResult updateStatus(Integer status, Long id) {
        appointmentService.updateStatus(status,id);
        return new JsonResult();
    }

}
