package com.test.peisong;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;

public class TestSample extends AbstractSampler {

	@Override
	public SampleResult sample(Entry arg0) {
		// TODO Auto-generated method stub
		
		SampleResult res=new SampleResult();
		
		res.sampleStart();
		res.sampleEnd();
		res.setSuccessful(true);
		
		return res;
		
		
		
		
		
	}
	
	
	
	

}
