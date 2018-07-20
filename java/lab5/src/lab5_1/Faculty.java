/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5_1;

/**
 *
 * @author Maria
 */

public class Faculty extends Human {
    private String degree;

    public Faculty(String name, String degree) {
        super(name);
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String newDegree) {
        degree = newDegree;
    }

    public String toString(){
        return "Faculty: " + getName() + "       Degree: " + degree;
    }
}