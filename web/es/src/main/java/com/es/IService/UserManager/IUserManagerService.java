package com.es.IService.UserManager;

import java.util.Map;

import org.springframework.stereotype.Service;


public interface IUserManagerService {
	public Map<String, String> login(String username,String password,String authkey);

}
