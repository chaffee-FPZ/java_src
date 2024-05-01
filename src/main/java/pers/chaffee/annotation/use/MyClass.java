package pers.chaffee.annotation.use;


import pers.chaffee.annotation.MyBaseAnnotation;

@MyBaseAnnotation
public interface MyClass {
    @MyBaseAnnotation
    String field = "hello world";

    @MyBaseAnnotation
    default String getField(){
        return field;
    }
}
