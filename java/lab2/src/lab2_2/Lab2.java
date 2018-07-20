/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Maria
 */


public class Lab2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws lab2.MatrixException
     */
    public static void main(String[] args) throws FileNotFoundException, MatrixException, IOException {
        int [][] arr = new int [] [] {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix (arr);
        matrix.output();
        matrix.write(new File("test.txt" ));
        
        Matrix res = Matrix.read(new File("test.txt" ));
        
        res.output();
        
        int [][] arr2 = new int [][]{{5,6},{7,8}};
        Matrix matrix2 = new Matrix (arr2);
        Matrix res2 = matrix.add(matrix2);
        res2.output();
        
        int [][] arr3 = new int [][]{{5},{7}};
        Matrix matrix3 = new Matrix (arr3);
  
       System.out.println("Matrix equals matrix2: " + matrix.equal(matrix2));
       System.out.println("Matrix equals matrix3: " + matrix.equal(matrix3));
       System.out.println("Matrix2 equals matrix3: " + matrix2.equal(matrix3)); 
       System.out.println("Matrix equals res: " + matrix.equal(res));
       
       int [] arr7 = new int []{5,6};
        Vector vector01 = new Vector(arr7);
        vector01.output();
        vector01.write(new File("vector.txt"));
        
        Vector vector02 = (Vector) Vector.read(new File("vector.txt"));
        vector02.output();
                  
        System.out.println("Length=sqrt(a11^2+a21^2+a31^2+…+an1^2) is: " + vector01.Length());
    }
}
