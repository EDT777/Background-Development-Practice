package com.octopus.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octopus.common.service.GeneratorService;
import com.octopus.common.utils.GenUtils;
import com.octopus.common.utils.R;

@RequestMapping("/common/generator")
@Controller
public class GeneratorController {
	String prefix = "common/generator";
	@Autowired
	GeneratorService generatorService;

	@GetMapping("/ui")
	String generator() {
		return prefix + "/list";
	}

	@ResponseBody
	@GetMapping("/list")
	List<Map<String, Object>> list() {
		List<Map<String, Object>> list = generatorService.list();
		return list;
	};

	@RequestMapping("/code/{tableName}")
	public void code(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("tableName") String tableName) throws IOException {
		String[] tableNames = new String[] { tableName };
		byte[] data = generatorService.generatorCode(tableNames);
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + tableName + ".zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");

		IOUtils.write(data, response.getOutputStream());
	}

	@RequestMapping("/batchCode")
	public void batchCode(HttpServletRequest request, HttpServletResponse response, String tables) throws IOException {
		String[] tableNames = tables.split(",");
		byte[] data = generatorService.generatorCode(tableNames);
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");

		IOUtils.write(data, response.getOutputStream());
	}

	@GetMapping("/edit")
	public String edit(Model model) {
		Configuration conf = GenUtils.getConfig();
		Map<String, Object> property = new HashMap<>(16);
		property.put("author", conf.getProperty("author"));
		property.put("email", conf.getProperty("email"));
		property.put("package", conf.getProperty("package"));
		property.put("autoRemovePre", conf.getProperty("autoRemovePre"));
		property.put("tablePrefix", conf.getProperty("tablePrefix"));
		model.addAttribute("property", property);
		return prefix + "/edit";
	}

	@ResponseBody
	@PostMapping("/update")
	R update(@RequestParam Map<String, Object> map) {
		try {
			PropertiesConfiguration conf = new PropertiesConfiguration(new File("generator.properties"));
			conf.setProperty("author", map.get("author"));
			conf.setProperty("email", map.get("email"));
			conf.setProperty("package", map.get("package"));
			conf.setProperty("autoRemovePre", map.get("autoRemovePre"));
			conf.setProperty("tablePrefix", map.get("tablePrefix"));
			conf.setProperty("tinyint", "Integer");
			conf.setProperty("smallint", "Integer");
			conf.setProperty("int", "Integer");
			conf.setProperty("mediumint", "Integer");
			conf.setProperty("integer", "Integer");
			conf.setProperty("bigint", "Long");
			conf.setProperty("float", "Float");
			conf.setProperty("double", "Double");
			conf.setProperty("decimal", "BigDecimal");
			conf.setProperty("bit", "Boolean");
			conf.setProperty("char", "String");
			conf.setProperty("varchar", "String");
			conf.setProperty("tinytext", "String");
			conf.setProperty("text", "String");
			conf.setProperty("mediumtext", "String");
			conf.setProperty("longtext", "String");
			conf.setProperty("date", "Date");
			conf.setProperty("datetime", "Date");
			conf.setProperty("timestamp", "Date");
			conf.save();
		} catch (ConfigurationException e) {
			return R.error("保存配置文件出错");
		}
		return R.ok();
	}
}
