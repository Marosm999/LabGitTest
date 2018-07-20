
//import javax.swing.JOptionPane;
//
///*2 Напишите следующую программу:
//1. Вводится с клавиатуры целое число
//2. В соответствии с введенным числом, строится двумерный массив целых чисел такого вида:
//Количество строчек и столбцов равно введенному числу. Для данной картинки = 6.
//Внимание! Верхний «треугольник» - это не неиспользующаяся часть прямоугольной матрицы. Его нет в принципе. То есть, например, элемент[0][1] не существует.
//3. Этот двумерный массив заполняется числами, вводящимися с клавиатуры.
//4. Массив распечатывается на экране
//5. Массив передается функции, которая находит элемент, наиболее близкий к 10.
//6. Программа выводит на экран индекс и значение найденного элемента.
//*/
///**
// *
// * @author marosm
// */
//public class P2 {
//	public static void main(String[] args) {
//		String aaa, bbb, ccc;
//		int a;
//		aaa = JOptionPane.showInputDialog("Input an integer rang matrix");
//		a = Integer.parseInt(aaa);
//		int[][] mas = new int[a][];
//		
//		for (int i = 0; i < a; i++) {
//			mas[i] = new int[i+1];
//			for (int j = 0; j <= i; j++) {
//				bbb = JOptionPane.showInputDialog("Imput an integer");
//				mas[i][j] = Integer.parseInt(bbb);
//				System.out.print(mas[i][j] + "  ");
//			}
//			System.out.println();
//		}
//		int curar[]=closetoten(mas);
//		System.out.print("Closer to 10: mas[" + curar[1] + "][" + curar[2] + "]=" + curar[0]);
//		System.exit(0);
//
//	}
//
//	static int[] closetoten(int[][] ar) { 
//	int[] temp=new int[3];
//	temp[0] = ar[0][0]; temp[1] = 0; temp[2]= 0;
//	for (int i = 1; i < ar.length; i++) {
//		for (int j = 0; j <= i; j++) {
//			if (10 - temp[0] > 10 - ar[i][j]) {
//				temp[0] = ar[i][j];
//				temp[1] = i;
//				temp[2] = j;
//			}
//		}
//		System.out.println();
//	}
//	return temp;
//}
//}

    
