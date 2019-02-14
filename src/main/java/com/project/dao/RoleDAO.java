package com.project.dao;

import com.project.entity.Role;

public interface RoleDAO {
    Role getRole(int id);
   Role getRole(String role);
}
