/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5_1;

import lab5_1.Human;

/**
 *
 * @author Maria
 */

public class Student extends Human {
    private int age;
    public Student(String name, int age) {
        super(name);
        if ((age > 18) && (age < 50)) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }
    
    @Override

    public String toString(){
        return "Student: " + getName() + "       Age: " + age;
    }
}


