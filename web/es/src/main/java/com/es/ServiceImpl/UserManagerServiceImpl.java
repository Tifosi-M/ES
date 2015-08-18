package com.es.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import com.es.dao.UserDao;
import com.es.domain.TUsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.IService.UserManager.IUserManagerService;

@Service
public class UserManagerServiceImpl implements IUserManagerService {
	@Autowired
	private UserDao userDao;
	@Override
	public Map<String, String> login(String username, String password,String authkey) {
		Map map = new HashMap<String, String>();
		TUsersEntity user = userDao.queryByUername(username);
		if (user!=null&&password.equals(user.getPassword())) {
			map.put("status", "OK");
			map.put("nickName",user.getNickname());
			map.put("userUnReadMessage","暂空");
			map.put("userId",user.getUserId());
			map.put("userIcon",user.getImgpath());
			map.put("activeValue",user.getActivevalue());
			map.put("medalNum","暂空");

		}
		else
			map.put("returnCode", "ERROR");
		return map;
	}

}
