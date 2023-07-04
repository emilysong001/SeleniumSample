package com.automation.dental.intervietest;

import io.cucumber.java.it.Ma;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) throws Exception{
        //hash map, input some values
        Map<String,Integer> map = new HashMap<>();
        map.put("Emily",100);
        map.put("Azat",100);
        map.put("Arjun",100);
        map.put("Arjun",90);
        map.put("Arjun",80);
        System.out.println(map);

        for(Map.Entry<String,Integer> map1: map.entrySet()){
            System.out.println(map1.getKey()+" "+map1.getValue());
        }

        Map<String,Integer> student = new HashMap<>();
        student.putAll(map);
        System.out.println(student);

        try{
            int i = 10/0;
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("This is successful code.");
        }

    }
}
