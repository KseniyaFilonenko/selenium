package com.itacademy.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before tests!");
    }
    @Test(priority = 1)
    public void testSecond(){
        System.out.println("Hi");
    }
    @Test(dependsOnMethods = {"testSecond"}) // желательно не использовать
    public void testFirst(){
    }
    @DataProvider(name = "data")
    public Object[][] getData(){
        return new Object[][]{
                {"Name", "password", "some message"},
                {"", "password2", "name is empty"},
                {"Name2", "", "password is empty"}
        };
    }
    @Test(dataProvider = "data")
    public void test(String name, String password, String error){
        //page.typeUserName(name);
        //assertEquals(name, error);
        System.out.println(name + password + error);
    }
    @Test(testName = "Login") // удобно, особенно если брать название мануального теста
    public void testTest(){
        System.out.println("Hi");
    }
}
