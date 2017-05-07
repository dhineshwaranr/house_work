package com.house.work.helpers;

import org.apache.commons.logging.Log;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.house.work.repository.UserRepository;
import com.mysql.jdbc.log.LogFactory;

@Component
public class DefaultDataInitializer implements InitializingBean{

	private static final Log logger = org.apache.commons.logging.LogFactory.getLog(DefaultDataInitializer.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		defaultAdmin();
		//defaultUser();
		//defaultLabour();
	}
	
	private void defaultAdmin() {
		
	}
	
}
