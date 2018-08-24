package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl extends DB implements  UserDao{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs =null;
    @Override
    public void add() {
       // Users users = null;
        conn =testConnetion();
        String sql ="insert into users(name,age) values(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"YIIBAI");
            ps.setInt(2,45);
            ps.executeUpdate();
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Users queryForOne(Integer id) {
        conn = testConnetion();
        Users users = null;
        try {
            String sql ="select * from users where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                users = new Users();
                //System.out.println(users.getId()+"========"+users.getName()+"========="+users.getAge());
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setAge(rs.getInt("age"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  users;
    }

    @Override
    public List<Users> queryForList() {
        conn = testConnetion();
        List<Users> list = null;
        //Users users = null;
        try {
            String sql ="select * from users";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Users users = new Users();
                //System.out.println(users.getId()+"========"+users.getName()+"========="+users.getAge());
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setAge(rs.getInt("age"));
                list.add(users);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  list;
    }

    @Override
    public void update(Integer id) {
        conn =testConnetion();
        try {
            String sql ="update users set name =?,age =? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"BBBBBBBBB");
            ps.setInt(2,450);
            ps.setInt(3,id);
            ps.executeUpdate();
            System.out.println("修改成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        conn =testConnetion();
        try {
            String sql ="DELETE * FROM users where id =?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("删除成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
