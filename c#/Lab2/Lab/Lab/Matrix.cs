using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab
{
    class Matrix
    {

        double[][] data;

        public Matrix(int Rows, int Cols)
        {
            data = new double[Rows][];

            for (int i = 0; i < Rows; i++)
                data[i] = new double[Cols];
        }
        public Matrix(double[,] initData)
        {
            int rows = initData.GetLength(0);
            int cols = initData.GetLength(1);
            data = new double[rows][];
            for (int i = 0; i < rows; i++)
            {
                data[i] = new double[cols];
                for (int j = 0; j < cols; j++)
                    data[i][j] = initData[i, j];
            }
        }

        public double this[int i, int j] {
            get
            {
                if (i < this.Rows && j < this.Columns)
                    return data[i][j];
                return double.NaN;
            }
            set
            {               
                data[i][j] = value;
            }
        }
        public int Rows
        {
            get
            {
                return data.Length;
            }
        }
        public int Columns
        {
            get
            {
                return data[0].Length;
            }

        }
        public int? Size
        {
            get
            {
                if (this.Rows == this.Columns)
                    return Rows;
                return null;// не квадратная
            }

        }
        public bool IsSquared
        {
            get
            {
                if (this.Size != null)
                    return true;
                return false;
            }

        }
        public bool IsEmpty
        {
            get
            {

                for (int i = 0; i < data.Length; i++)
                    for (int j = 0; j < data[0].Length; j++)
                        if (data[i][j] > 0)
                            return false;
                return true;
            }

        }
        public bool IsUnity
        {
            get
            {
                if (IsSquared)
                {
                    for (int i = 0; i < data.Length; i++)
                        for (int j = 0; j < data[0].Length; j++)
                            if (((i == j) && (data[i][j] != 1)) || ((i != j) && (data[i][j] != 0))) //if (i==j && data[i][j]!=1 || i != j && data[i][j] != 0)
                                return false;
                    return true;
                }
                return false;
            }

        }
        public bool IsDiagonal
        {
            get
            {
                if (IsSquared)
                {
                    for (int i = 0; i < data.Length; i++)
                        for (int j = 0; j < data[0].Length; j++)
                            if (i != j && data[i][j] != 0)
                                return false;
                    return true;
                }
                return false;
            }

        }
        public bool IsSymmetric
        {
            get
            {
                if (IsSquared)
                {
                    for (int i = 0; i < data.Length; i++)
                        for (int j = 0; j < data[0].Length; j++)
                            if (i != j && data[i][j] !=data[j][i])
                                return false;
                    return true;
                }
                return false;
            }

        }



        public static Matrix operator +(Matrix m1, Matrix m2)
        {
            if (m1.Rows == m2.Rows && m1.Columns == m2.Columns)
            {

                Matrix m3 = new Matrix(m1.Rows, m1.Columns);

                for (int i = 0; i < m1.Rows; i++)                                   
                    for (int j = 0; j< m1.Columns;j++)
                        m3[i,j] = m1[i,j] + m2[i,j];
                return m3;
            }
            return null;///разные размеры не сложить/вычесть;
        }
        public static Matrix operator -(Matrix m1, Matrix m2)
        {
            if (m1.Rows == m2.Rows && m1.Columns == m2.Columns)
            {

                Matrix m3 = new Matrix(m1.Rows, m1.Columns);

                for (int i = 0; i < m1.Rows; i++)
                    for (int j = 0; j < m1.Columns; j++)
                        m3[i, j] = m1[i, j] - m2[i, j];
                return m3;
            }
            return null;///разные размеры не сложить/вычесть;
        }
        public static Matrix operator *(Matrix m1, double d)
        {


            Matrix m2 = new Matrix(m1.Rows, m1.Columns);
            for (int i = 0; i < m1.Rows; i++)
                for (int j = 0; j < m1.Columns; j++)
                    m2[i, j] = m1[i, j] * d;
            return m2;           
        }
        public static Matrix operator *(Matrix m1, Matrix m2)
        {
            if (m1.Columns == m2.Rows )
            {

                double sum;

                Matrix m3 = new Matrix(m1.Rows, m2.Columns);

                for (int i = 0; i < m1.Rows; i++)
                    for (int j = 0; j < m2.Columns; j++)
                    {
                        sum = 0;
                        for (int k = 0; k < m1.Columns; k++)
                            sum += m1[i, k] * m2[k, j];
                        m3[i, j] = sum;
                    }
                        
                return m3;
            }
            return null;///умножить невозможно
        }

        public static explicit operator Matrix(double[,] arr)
        {
            return new Matrix(arr);
        }


        public Matrix Transpose() { 

            Matrix res = new Matrix(this.Columns, this.Rows);

            for (int i = 0; i < res.Rows; i++)
                for (int j = 0; j < res.Columns; j++)
                    res[i, j] = this[j, i];
            return res;

        }
        public double Trace() {

            if (IsSquared)
            {
                double sum = 0;
                for (int i = 0; i < Rows; i++)
                    sum += data[i][i];
                return sum;
            }
            return Double.NaN;  // Матрица не квадратная;
        }
        public override string ToString()
        {
            String resline = "";
            for (int i = 0; i < Rows; i++)
            {
               
                for (int j = 0; j < Columns; j++)
                   resline+= data[i][j].ToString()+' ';
                resline.TrimEnd();
                if((i+1)<Rows )
                    resline += ',';
            }
            
            //resline.TrimEnd(',');
            return resline;  
        }
        public static Matrix GetUnity(int Size) {

            Matrix res = new Matrix(Size, Size);
              for (int i = 0; i < Size; i++)
                for (int j = 0; j < Size; j++)
                    if (i == j)
                        res[i, j] = 1;
                    else
                        res[i, j] = 0;
            return res;

        }
        public static Matrix GetEmpty(int Size) {

            Matrix res = new Matrix(Size, Size);
            for (int i = 0; i < Size; i++)
                for (int j = 0; j < Size; j++)
                     res[i, j] = 0;
            return res;
        }

        
        /// a b c, d f g, e k l   -  формат
        public static Matrix Parse(string s)
        {
            s = s.Trim();
            try
            {
                var Rows = s.Split(',');

                Matrix res = new Matrix(Rows.Length, Rows[0].Split(' ').Length);
                for (int i = 0; i < res.Rows; i++)
                {
                    var col = Rows[i].Trim().Split(' ');
                    for (int k = 0; k < res.Columns; k++)                            
                        res[i, k] = Double.Parse(col[k].Trim());
                   
                }
                return res;
            }
            catch (Exception)
            {

                throw new FormatException("Формат неверен");
            }           

        }
        public static bool TryParse(string s, out Matrix m)
        {
            try
            {
                m = Parse(s);
            }
            catch (Exception)
            {

                m = null;
                return false;
            }

            return true;
        }

    }
}
