using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;
namespace Lab
{
   
    class Program
    {
        static Dictionary<string, Matrix> M;
       
        static void Main(string[] args)
        {


            M = new Dictionary<string, Matrix>();

            bool exitFlag = false;
            char inputKey;

            while (!exitFlag)
            {

                Console.Clear();

                Console.WriteLine("Работа с матрицами Меню:");
                Console.WriteLine("\t  1 - Ввод матрицы");
                Console.WriteLine("\t  2 - Операции между матрицами");
                Console.WriteLine("\t  3 - Информация о матрице");                
                Console.WriteLine("\t  O - Выход");

                inputKey = Console.ReadKey().KeyChar;

                switch (inputKey)
                {
                    case '1': ReadMatrix();break;
                    case '2': Operations(); break;
                    case '3': PrintMatrix(); break;                    
                    case '0': exitFlag=true; break;
                    default: break; 
                }

            }

            Console.WriteLine("\nНажмите любую кнопку для завершения.");
            Console.ReadKey();
        }

        private static void PrintMatrix()
        {
            bool exitFlag = false;
            string input;

            while (!exitFlag)
            {

                Console.Clear();
                Console.WriteLine("Введите имя матрицы:");
                Console.WriteLine("Доступные (ранее созданные)матрицы :");
                Console.WriteLine("\nДля выхода введите quit:");
                foreach (string key in M.Keys)
                {
                    Console.WriteLine(key);
                }

                input = Console.ReadLine();
                if (input == "quit")
                {
                    exitFlag = true;
                }
                else
                {

                    if (M.Keys.Contains(input))
                    {
                        Matrix m = M[input];
                        exitFlag = true;

                        Console.WriteLine("Матрица : " + m.ToString());
                        Console.WriteLine("Колонок : " + m.Columns.ToString());
                        Console.WriteLine("Строк : " + m.Rows.ToString());
                        Console.WriteLine("Матрица пуста : " + m.IsEmpty.ToString());
                        Console.WriteLine("Матрица диагональна   : " + m.IsDiagonal.ToString());
                        Console.WriteLine("Матрица квадратна : " + m.IsSquared.ToString());
                        Console.WriteLine("Матрица симметрична : " + m.IsSymmetric.ToString());
                        Console.WriteLine("След матрицы (если она квадратна)  : " + m.Trace().ToString());
                        Console.WriteLine("Матрица транспонирована : " + m.Transpose().ToString());


                    }
                    else
                    {
                        Console.WriteLine("Такая матрица не существует");
                        Console.WriteLine("\nНажмите любую кнопку для продолжения.");
                        Console.ReadKey();
                    }
                }

            }

            Console.WriteLine("\nНажмите любую кнопку для возврата.");
            Console.ReadKey();
        }

      
        private static void Operations()
        {
            bool exitFlag = false;
            string input;
            string[] args;
            Matrix res=null;
            while (!exitFlag)
            {
                Console.Clear();
                Console.WriteLine(@"Для выхода введите ""quit"":");
                Console.WriteLine("Доступные (ранее созданные )матрицы :");
                foreach (string key in M.Keys)
                {
                    Console.WriteLine(key);
                }

                Console.WriteLine("доступны операции  +/-/* и умножить на число" );
                Console.WriteLine("Пример: m0*m1, m1+m2, m0*8" );
                res = null;

                input = Console.ReadLine().Trim();
                if (input == "quit")
                    exitFlag = true;
                else
                {

                    args = input.Split('*');
                    if (args.Length == 2)
                    {
                      res=  Multiply(args[0], args[1]);
                        

                    }
                    else
                    {
                        args = input.Split('+');
                        if (args.Length == 2)
                        {
                           res= Sum(args[0], args[1]);
                        }
                        else
                        {
                            args = input.Split('-');
                            if (args.Length == 2)
                            {
                               res=  Div(args[0], args[1]);
                            }
                            else
                            {

                                if (M.Keys.Contains(input))
                                {
                                    Matrix m = M[input];
                                    Console.WriteLine("Матрица " + input + ": " + m.ToString());
                                }
                                else
                                {
                                    Console.WriteLine("Формат неверен");
                                }
                            }
                        }
                    }

                    if (res != null)
                    {
                        Console.WriteLine("Результат операции: " + res.ToString());
                        string MatrixName = "m" + M.Keys.Count.ToString();
                        M.Add(MatrixName, res);
                        Console.WriteLine("Результат сохранен как :  " + MatrixName + "\n");
                    }

                    Console.WriteLine("\nНажмите любую кнопку для продолжения.");
                    Console.ReadKey();

                }
                ////

            }

            Console.WriteLine("\nНажмите любую кнопку для возврата.");
            Console.ReadKey();
        }

        private static Matrix Div(string v1, string v2)
        {
            

            Matrix m1=null, m2=null;
            if (M.Keys.Contains(v1))
            {
                 m1 = M[v1];
            }
            else
            {
                Console.WriteLine("Матрица " +v1 + " не определена");
                return null;
            }
            if (M.Keys.Contains(v2))
            {
                 m2 = M[v2];
            }
            else
            {
                Console.WriteLine("Матрица " + v2 + " не определена");
                return null;
            }


            Matrix res=null;
            res= m1 - m2;

            if (res == null)
            {
                Console.WriteLine("Операция недоступна для данных параметров");
            }


            return res;

            
        }

        private static Matrix Sum(string v1, string v2)
        {
            Matrix m1 = null, m2 = null;
            if (M.Keys.Contains(v1))
            {
                 m1 = M[v1];
            }
            else
            {
                Console.WriteLine("Матрица " + v1 + " не определена");
                return null;
            }
            if (M.Keys.Contains(v2))
            {
                 m2 = M[v2];
            }
            else
            {
                Console.WriteLine("Матрица " + v2 + " не определена");
                return null;
            }


            Matrix res = null;
            res = m1 + m2;

            if (res == null)
            {
                Console.WriteLine("Операция недоступна для данных параметров");
            }


            return res;
        }

        private static Matrix Multiply(string v1, string v2)
        {

            


            Matrix m1 = null, m2 = null;
            double d1 = 0, d2=0;
            if (M.Keys.Contains(v1))
            {
                m1 = M[v1];
            }
            else
            {
                if (!double.TryParse(v1, out d1))
                {
                    Console.WriteLine("Формат неверен");
                    return null;
                }
            }

            if (M.Keys.Contains(v2))
            {
                m2 = M[v2];
            }
            else
            {
                if (!double.TryParse(v2, out d2))
                {
                    Console.WriteLine("Формат неверен");
                    return null;
                }
            }

            if (m1 == null && m2 == null)
            {
                Console.WriteLine("Формат неверен");
                //Console.WriteLine("Результат: " + (d1 * d2).ToString());
                return null;
            }

            Matrix res = null;
            if (m1 != null && m2 != null)
            {
                res = m1 * m2;
                if (res == null)
                {
                    Console.WriteLine("Операция недоступна для данных параметров");
                }

                return res;
            }
            
            if (m1 == null)
                res = m2 * d1;
            else
                res = m1 * d2;


            return res;
        }


        private static void ReadMatrix()
        {

            bool exitFlag = false;
            string input;
            Matrix m;
            while (!exitFlag)
            {

                Console.Clear();

                Console.WriteLine("Введите матрицу в след. формате : a b c,d e f ,g h k ");                
                Console.WriteLine("");

                input = Console.ReadLine();


                if (Matrix.TryParse(input, out m))
                {
                    string MatrixName = "m" + M.Keys.Count.ToString();

                    M.Add(MatrixName, m);

                    Console.WriteLine("Матрица " + MatrixName+ " введена: \n");

                    Console.Write(m.ToString());
                    exitFlag = true;
                }
                else
                Console.WriteLine("Формат неверен");
            }

            Console.WriteLine("\nНажмите любую кнопку для возврата.");
            Console.ReadKey();
        }
    }
}
