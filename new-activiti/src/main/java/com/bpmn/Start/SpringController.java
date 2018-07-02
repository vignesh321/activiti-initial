package com.bpmn.Start;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

	@Autowired
	RuntimeService runTimeService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ProcessEngine processEngine;
	
	@Autowired
	IdentityService identityService;
	
	
	//@CrossOrigin(origins = "*")
	@GetMapping (value = "/test/{name}" , produces=MediaType.TEXT_PLAIN_VALUE)
	public String testMapping(@PathVariable (name = "name") String name ) {
		
		System.out.println("Hello, " + name);
		return "Hello, " + name ;
	}
	
	@GetMapping (value = "/startProcess")
	//@GetMapping (value = "/startProcess/{processKey}")
	public String startNewProcess() {
		
		Map<String, Object> paramsMap = new HashMap<>();
		
		paramsMap.put("assignee", "kermit");
		paramsMap.put("assignee1", "kermit");
		
        runTimeService.startProcessInstanceByKey("simpleProcess",  paramsMap);
        			
		return "Process initiated";
	}
	
	@GetMapping (value = "/startProcess2")
	//@GetMapping (value = "/startProcess/{processKey}")
	public String startNewProcess2() {
		
		Map<String, Object> paramsMap = new HashMap<>();
		
		paramsMap.put("assignee", "admin");
			
        runTimeService.startProcessInstanceByKey("simpleProcess2",  paramsMap);
        			
		return "Process 2 initiated";
	}
	
	
	
	/*This is for uploading the process bpmn20.xml 
	public void uploadProces() {
		
		
	}*/
	
	
}
