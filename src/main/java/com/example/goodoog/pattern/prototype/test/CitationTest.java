package com.example.goodoog.pattern.prototype.test;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation();
        Student stu = new Student();
        stu.setName("张三");
        citation.setStu(stu);

        Citation clone1 = citation.clone();
        clone1.getStu().setName("李四");

//        citation.setName("张三");
//        clone1.setName("李四");

        citation.show();
        clone1.show();
    }
}
