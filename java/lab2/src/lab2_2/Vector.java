/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2_2;

/**
 *
 * @author Maria
 */
public class Vector  extends Matrix 
{
        public Vector(int[] arr)throws MatrixException 
        {
        super(new int[][]{arr});
        }
        public Vector(Matrix arr)throws MatrixException 
        {
          super( arr.getArr());
        }

    public double Length(){        
        int result = 0;
        
        for (int i=0; i < getArr()[0].length; i++) {        
           result += Math.pow(getArr()[0][i], 2);           
        } 
            return Math.sqrt(result);
    }
}
