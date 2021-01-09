package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Business;
import cn.wolfcode.qo.BusinessQueryObject;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IBusinessService;
import cn.wolfcode.util.FileUploadUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/business")
public class BusinessController {

    private IBusinessService businessService;

    @Autowired
    public void setBusinessService(IBusinessService businessService) {
        this.businessService = businessService;
    }

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") BusinessQueryObject qo){
        model.addAttribute("pageInfo", businessService.query(qo));
        return "business/list"; // /WEB-INF/views/business/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            businessService.delete(id);
        }
        return "redirect:/business/list";
    }


    @RequestMapping("/input")
    public String input(Long id,Model model) {
        if (id != null) {
            model.addAttribute("business",businessService.get(id));
        }
        return "business/input";
    }

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Business business, MultipartFile file) throws Exception {
        if(file!=null&&file.getSize()>0){
            //获取webapp的绝对路径
            String realPath = servletContext.getRealPath("/");
            //删除原本的文件(传入图片的绝对路径)
            String licenseImg = business.getLicenseImg();
            if(StringUtils.hasText(licenseImg)){
                FileUploadUtil.deleteFile(realPath+licenseImg);
            }
            //上传新的图片
            String imageUrl = FileUploadUtil.uploadFile(file, realPath);
            //设置到营业执照图片路径
            business.setLicenseImg(imageUrl);
        }

        if (business.getId() == null) {
            businessService.save(business);
        } else {
            businessService.update(business);
        }
        return "redirect:/business/list";
    }

}
