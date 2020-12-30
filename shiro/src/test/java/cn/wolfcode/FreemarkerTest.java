package cn.wolfcode;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class FreemarkerTest {
    @Test
    public void test2()  {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("erewrew");
        objects.add("gfgfdg");
        objects.add("tretert");
        System.out.println(objects.toString());
        System.out.println(JSON.toJSONString(objects));

    }

    @Test
    public void test() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        // 指定模板文件从何处加载的数据源，这里设置文件目录位置。
        cfg.setDirectoryForTemplateLoading(new File("templates"));
        // 设置默认编码类型
        cfg.setDefaultEncoding("utf-8");
        // 提供数据
        Map root = new HashMap();
        //root.put("domain", "Department");
        // 获取模板文件
        Template temp = cfg.getTemplate("test.ftl");
        // 设置输出为新的文件
        Writer out = new OutputStreamWriter(new FileOutputStream("DepartmentMapper.java"));
        // 执行输出
        temp.process(root, out);
        out.flush();
        out.close();
    }
}
