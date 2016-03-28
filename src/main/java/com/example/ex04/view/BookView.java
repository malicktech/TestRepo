package com.example.ex04.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.example.ex04.domain.Book;

/**
 * Created by Alex on 07/03/2015.
 */

@ManagedBean(name = "book", eager = true)
@RequestScoped
public class BookView extends Book {

    public BookView() { }
}
