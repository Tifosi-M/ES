package com.es.ServiceImpl.UserManager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.es.IService.UserManager.IUserManagerService;

@Service
public class UserManagerServiceImpl implements IUserManagerService {

	@Override
	public Map<String, String> login(String username, String password) {
		Map map = new HashMap<String, String>();
		if (username.equals("admin") && password.equals("admin"))
			map.put("login", "success");
		else
			map.put("login", "failed");
		return map;
	}

}
