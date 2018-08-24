package com.connection;

import java.util.List;


public class UserTest {
    private static UserDaoImpl userDao = new UserDaoImpl();

    public static void main(String[] args) {
        //userDao.add();
        //userDao.update(3);
       /*List<Users> list = userDao.queryForList();
        for (Users users : list) {
            System.out.println(users.toString());
        }*/
       Users users = userDao.queryForOne(3);
       System.out.println(users.toString());
    }
}
