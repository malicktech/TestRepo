package com.example.ex04;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "book", eager = true)
//@RequestScoped
@SessionScoped
public class BookView extends Book {

	private static final long serialVersionUID = 1L;

	public BookView() { }
}
