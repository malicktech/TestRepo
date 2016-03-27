package com.example.ex01;

public interface ItemMasterDAO {
	 
    public boolean add(String item_code,String item_name, float mrp, int stock);
 
}