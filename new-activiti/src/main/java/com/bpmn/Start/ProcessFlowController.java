package com.bpmn.Start;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessFlowController {

	
	@Autowired
	RuntimeService runTimeService;
	
	
	@PostMapping (value = "/processInstance/indicate/{signal}/{pid}")
	public String getUserDetails(@PathVariable ( name= "signal") String signal,
			@PathVariable ( name= "pid") String pid ) {
		
		System.out.println("The signal/ output provided by the user is : " + signal);
		System.out.println("ProcessInstance ID : " + pid);
		return "Response sent succerssfully";
        
	}
}
