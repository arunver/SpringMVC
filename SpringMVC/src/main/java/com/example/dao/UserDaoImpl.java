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
		boolean found=false;
		int indexFound=-1;
		if(userList.size()==0)
			found=false;
		else if(userList.size()>0)
		{
			for(int i=0;i<userList.size();i++)
			{
				if(userList.get(i).getId() == id)
				{
					found = true;
					indexFound = i;
					break;
				}
			}
		}
		if(found)
			return userList.get(indexFound);
		else
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
