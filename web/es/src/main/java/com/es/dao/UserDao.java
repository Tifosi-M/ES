package com.es.dao;

import com.es.domain.TUsersEntity;
import com.es.hibernateUtils.BaseImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by szp on 15/8/18.
 */
@Repository
public class UserDao extends BaseImpl<TUsersEntity> {
    @Override
    public TUsersEntity get(Serializable id) {
        return super.get(id);
    }
    public TUsersEntity queryByUername(String username){
        String hql = "from TUsersEntity where username = ?";
        TUsersEntity user = getByHql(hql,username);
        return user;
    }
}
