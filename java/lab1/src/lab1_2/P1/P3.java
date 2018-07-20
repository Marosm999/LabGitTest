/*
3 Создайте класс Employee. 
Public methods: на ваше усмотрение
Private instance field: ID number, name, position, salary.
Напишите перегруженный конструктор. 
Если передается только name, конструктор создает объект {ID#, name, “worker”, 5000}. 
Если передается name и position, конструктор анализирует position и создает один из следующих объектов: {ID#, name, “worker”, 5000} 
если position = “worker”, или {ID#, name, position, 6000} при другом значении position. 
Если передаются три параметра, то создается object: {name, position, salary}.
ID# - порядковый номер: 1, затем 2, затем 3, затем 4, и т.п.. 
ID# назначается автоматически каждому новому работнику. Как параметр не передается.
Напишите программу, которая создает массив из 10 Employees, передавая различное число параметров конструктору. 
Затем с помощью вызова статических функций класса Employee распечатывает всех Employees на экране, рассчитывает суммарную зарплату Employees и 
печатает position с наибольшей зарплатой.

 */

/**
 *
 * @author marosm
 */
//public class P3
//{
//    public static void main(String args[])
//      { 
//
//Employee[] mas={new Employee("Robert","Sales manager",5000),
//new Employee("Anna","Account"),
//new Employee("Sacha","IT"),
//new Employee("Dasha"),
//new Employee("Ivan","worker"),
//new Employee("Petr", "programmist",7000),
//new Employee("Katy","HR manager"),
//new Employee("Nick","boss",10000),
//new Employee("Oleg"),
//new Employee("Boris")};
//
//	Employee.printMas(mas);
//	System.out.println("Position with max salary:"+Employee.MaxSalaryPosition(mas));
//	System.out.println("SumSal="+Employee.SumSalary(mas));
//      }
//}	
//
//
//class Employee                   
//{
//    public Employee(String n, String p,double s) 
//    { name=n;
//     position=p;
//     salary=s;
//     id=nextId;
//     nextId++;}
//
//    public Employee(String n) 
//    { this(n,"worker",5000);
//     id=nextId;
//     nextId++;}
//
//    public Employee(String n, String p) 
//    { //this(n,p
//     name=n;
//     position=p;
//     if(p.equals("worker"))
//     {salary=5000;}
//     else
//     {salary=6000;}
//     id=nextId;
//     nextId++;}
//
//    public String getName()
//    {return name;}
//
//    public String getPosition()
//    {return position;}
//
//    public double getSalary()
//    {return salary;}
//
//    public int getId()
//    {return id;}
//
//    public void printEverything()
//    {
//        System.out.println(name+"  "+position+"  "+salary+"\n");
//    }
//
//    public static void printMas(Employee[] mas)
//    {
//	for (int i=0;i<=mas.length-1;i++)
//        System.out.println(mas[i].name+"  "+mas[i].position+"  "+mas[i].salary+"\n");
//    }
//
//    private static Employee maxSalary(Employee a, Employee b)
//             
//   { 
//       if (a.salary<b.salary)
//          return b;
//       else 
//          return a;
//    }
//
//    public static String MaxSalaryPosition(Employee arr[])
//    {
//        Employee maxSal=arr[0];
//        for (int i=1;i<=arr.length-1;i++)
//            maxSal=maxSalary(maxSal, arr[i]);
//        return maxSal.position;
//    }
//
//public static double SumSalary(Employee arr[])
//    {
//        double sum=arr[0].salary;
//        for (int i=1;i<=arr.length-1;i++)
//            sum=sum+arr[i].salary;
//        return sum;
//    }
//    
//    private String name;
//    private String position;
//    private double salary;
//    private int id;
//    private static int nextId=0;
//}
//
//  
//    
//    
//    
//    
//
