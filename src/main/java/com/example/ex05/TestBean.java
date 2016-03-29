package com.example.ex05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;


@Component("testBean")
@Scope("view")
public class TestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	TestPojo testPojo = new TestPojo();

    boolean edit = false;

    public class TestPojo{
        boolean trueFalse = true;
        String testText = "testing this";

        public boolean isTrueFalse() {
            return trueFalse;
        }

        public void setTrueFalse(boolean trueFalse) {
            this.trueFalse = trueFalse;
        }

        public String getTestText() {
            return testText;
        }

        public void setTestText(String testText) {
            this.testText = testText;
        }
    }

    @PostConstruct
    public void init(){
        System.out.println(testPojo.trueFalse);
    }

    public TestPojo getTestPojo() {
        return testPojo;
    }

    public void setTestPojo(TestPojo testPojo) {
        this.testPojo = testPojo;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void editActionListener(){
        this.edit = true;
    }
}
