package com.octopus.spring1.freemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.filter.config.ConfigFilter;
import com.octopus.spring1.entity.UserInfo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerDemo {
public static void main(String[] args) throws IOException, TemplateException {
	//创建配置
	Configuration config = new Configuration(Configuration.VERSION_2_3_28);
	//设定模板所在的文件夹
	File path = new File("F:\\JAVA_lianxi\\spring1\\src\\main\\resources\\fm");
	config.setDirectoryForTemplateLoading(path);
	//获取模板实例，可以用来实现内容转换(模板引擎)
	Template tpl =config.getTemplate("test.ftl");
	//获取真正转换之前必须提供的数据
	Map<String,Object> data = new HashMap<>();
	data.put("name", "EDT");
	UserInfo user = new UserInfo();
	user.setUserName("EDTT");
	data.put("user", user);
	FileOutputStream fos = new FileOutputStream("d:\\test2.html");
	OutputStreamWriter writer = new OutputStreamWriter(fos);
	tpl.process(data, writer);
	fos.close();
	
}
}
