package com.bpmn.process;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SimpleService2  implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("This is OUTPUT from Simple Service 2 ");
		
		System.out.println("Current Activiti Name : " + execution.getCurrentActivityName());
		System.out.println("Id : " + execution.getId() );
	}

}
