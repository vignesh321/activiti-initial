package com.bpmn.process;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SimpleService implements JavaDelegate{

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("This is OUTPUT from Simple Service 1");
		
	}

}
