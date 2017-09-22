package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		
		List<Module> moduleList = moduleService.findAll();
		
		model.addAttribute("moduleList", moduleList);
		//返回模块列表页面
		return "/sysadmin/module/jModuleList";
	}
	
	
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		
		int state = 1;
		moduleService.updateState(moduleIds,state);
		
		//跳转到列表页面   重定向到请求
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		
		int state = 0;
		moduleService.updateState(moduleIds,state);
		
		//跳转到列表页面   重定向到请求
		return "redirect:/sysadmin/module/list";
	}
	
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		
		//准备上级模块列表信息
		List<Module> parentList = moduleService.findAll();
		model.addAttribute("parentList", parentList);
		
		
		//转向新增页面
		return "/sysadmin/module/jModuleCreate";
	}
	
	
	@RequestMapping("/save")
	public String saveModule(Module module){
		
		moduleService.saveModule(module);
		
		return "redirect:/sysadmin/module/list";
	}
	
	//跳向查看详细页面
	@RequestMapping("/toview")
	public String toview(String moduleId,Model model){
		
		Module module = moduleService.findModuleById(moduleId);
		
		model.addAttribute("module", module);
		
		return "/sysadmin/module/jtoView";
	}
	
	//跳向修改页面
	@RequestMapping("/toupdate")
	public String toupdate(String moduleId,Model model){
		
		List<Module> allModule = moduleService.findAll();
		Module module = moduleService.findModuleById(moduleId);
		
		model.addAttribute("allModule", allModule);
		model.addAttribute("module", module);
		
		return "/sysadmin/module/jtoUpdate";
	}
	
	//保存修改信息
	@RequestMapping("/update")
	public String updateModule(Module module){	
		moduleService.updateModule(module);
		return "redirect:/sysadmin/module/list";
	}
	
	
	
	
}
