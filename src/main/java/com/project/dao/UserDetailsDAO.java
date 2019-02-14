package com.project.dao;

import com.project.entity.User;

public interface UserDetailsDAO {
 User getUser(String login);
 Boolean isUserNameAvailable(String name);


}
