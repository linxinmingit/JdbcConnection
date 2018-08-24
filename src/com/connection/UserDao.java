package com.connection;

import java.util.List;

public interface UserDao {
    public void add();
    public  Users queryForOne(Integer id);
    public List<Users> queryForList();
    public  void update(Integer id);
    public  void delete(Integer id);
}
