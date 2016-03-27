package com.example.ex02;

import java.util.HashMap;
import java.util.Map;
public class StudentServiceImpl implements StudentService {
	Map<Integer, String> map = new HashMap<Integer, String>();
	{
		map.put(1, "Ram");
		map.put(2, "Shyam");
		map.put(3, "Rahim");
	}
	@Override
	public String getStudent(Integer id) {
		System.out.println("Fetching student for the id:"+ id);
		return map.get(id);
	}
}
