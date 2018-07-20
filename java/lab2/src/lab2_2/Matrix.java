/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Maria
 */
public class Matrix {
    private final int[][] arr;

    public Matrix(int[][] arr) {
        this.arr = arr;
    }
    

    public void output() {
        write (System.out);
    };
    
    public Matrix add (Matrix mtrx) throws MatrixException {
        int n = arr.length;
        int m = arr[0].length;
        
        int [][] arr2 = mtrx.getArr();
        
        if (n != arr2.length || m != arr2[0].length) {
            throw new MatrixException("Array size missmatch [n1=" + n 
                + ", n2=" + arr2.length + ", m1=" + m + ", m2=" 
                + arr2[0].length + ']');
        }
        
        int [][] res = new int [n][m];
        
        for (int i = 0; i < arr.length; i++ ){
            for (int j = 0; j < arr[i].length; j++) {
                res [i][j] = arr [i][j] + arr2 [i][j];
            }
        }
       
        return new Matrix(res);
    };
    
    public static Matrix read (File file) throws IOException, MatrixException {
        BufferedReader in = null;
            try {
            in = new BufferedReader(new FileReader(file));

            String s = in.readLine();

            int maxColumns = 0;

            List<String[]> lst = new ArrayList();

            while (s != null){
                String[] strArr = s.split(",");

                lst.add(strArr);

                if (strArr.length > maxColumns){
                    maxColumns = strArr.length;
                }

                s = in.readLine(); 
            }

            int[][] array = new int[lst.size()][maxColumns];

            for(int i=0; i < array.length; i++){
                String[] strRow = lst.get(i);

               // array[i] = new int [maxColumns];

                for(int j=0; j < strRow.length; j++){
                    try {
                        array[i][j] = Integer.valueOf(strRow[j].trim());
                    }
                    catch(NumberFormatException e) {
                        throw new MatrixException("Invalid number: " + strRow[j],e);
                    }
                }
            }
             if(array.length!=1)
              {
            return new Matrix(array);
              }
              else
               {
               return new Vector(array[0]);
               }
        }
        finally {
            if (in != null){
                in.close();
            }
        }
    };
    
    public void write (File file) throws FileNotFoundException {
        PrintStream out = null;
        
        try {
            out = new PrintStream (file);
            
            write (out);
        }
        finally {
            if (out != null) {
                out.close();
            }
        }
   };
    
    public boolean equal (Matrix mtrx) {
        int[][] otherArr = mtrx.getArr();
        
        if (arr.length != otherArr.length){
            return false;
        }
        
        for (int i=0; i <arr.length; i++) {
            int[] row = arr[i];
            int[] otherRow = otherArr [i]; 
            
           if (row.length != otherRow.length) {
               return false;
           }
           
           for (int j = 0; j< row.length; j++) {
               if (row[j] != otherRow[j]) {
                   return false;
               }
           }
        }
        
        return true;

    };
    
    private void write (PrintStream out){
        for (int i = 0; i<arr.length;i++){ 
            for(int j = 0; j< arr[i].length; j++){
                int k = arr[i][j];
                
                out.print(k);
                
                if (j < arr[i].length - 1) {
                    out.print(',');
                }
            }

            out.println();
        }
    };

    public int[][] getArr() {
        return arr;
    }
    
};

