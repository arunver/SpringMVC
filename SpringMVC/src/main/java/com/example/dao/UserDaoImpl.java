package com.example.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	private static List<User> userList= new ArrayList<User>();
	//private static Map<String, User> userList= new HashMap<String, User>();
	
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		System.out.println(userList.size());

		Iterator<User> it= userList.iterator();
		while(it.hasNext())
		{
			User obj=it.next();
			if(obj.getId()== id)
				return obj;
			else
				return null;
		}
		
		return null;		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		//userList.put(user.getName(), user);
		userList.add(user);
	}

	@Override
	public void update(User user) {
		
		User obj= findById(user.getId());
		obj.setAddress(user.getAddress());
		obj.setPassword(user.getPassword());
		obj.setCountry(user.getCountry());
		obj.setEmail(user.getEmail());
		obj.setSex(user.getSex());
		obj.setSkill(user.getSkill());		
		
	}

	@Override
	public void delete(Integer id) {
		for(Iterator<User> user= userList.iterator();user.hasNext();)
		{
			User userObj= user.next();
			if(userObj.getId() == id)
			{
				user.remove();
			}
		}
		
	}

}
