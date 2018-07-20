/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
4 Иерархия классов
Затененные прямоугольники представляют абстрактные классы.
Все животные имеют уникальное имя.
Все animals имеют 4 метода: constructor, moves(), sound(), output().
moves() возвращает “swim” для рыб и морских животных, “fly” – для  птиц и “run” – для земных животных.
Sound() возвращает “nothing” для рыб, “Chirp!” для птиц , а для млекопитающих – в зависимости от конкретного экземпляра объекта.
output() выводит имя и тип класса животного.
Напишите программу, создающую заданную иерархию классов и следующие экземпляры:
- shark  
- eagle
- whale  
- dog
а также проверяет, как работают заданные функции. Продумайте, какие функции к каким классам отнести.
Занесите этих животных в массив и проверьте полиморфизм и динамическое связывание.
 */

package lab1_2.P1;
/**
 *
 * @author marosm
 */

public class P4
{   public static void main(String args[])
    { Bird eagle=new Bird("Lisa");
      Fish shark=new Fish("Rob");
      TerreMammal dog=new TerreMammal("Rex");
      SeaMammal whale=new SeaMammal("Sharik");

      eagle.output();
      System.out.println(eagle.Sound());
      System.out.println(eagle.moves());
      shark.output();
      System.out.println(shark.Sound());
      System.out.println(shark.moves());
      dog.output();
      System.out.println(dog.Sound());
      System.out.println(dog.moves());
      whale.output();
      System.out.println(whale.Sound());
      System.out.println(whale.moves());
    }
}
abstract class Animal   
{   public Animal(String n) 
    {name=n;
    }
    abstract public void output();
    abstract public String moves();
    abstract public String Sound();
       
    protected String name;
}

class Fish extends Animal
{   public Fish(String n) 
    {super(n);}

    public void output()
    {System.out.println("Fish Name:"+name);}

    public String moves()
    {return "swim";} 

    public String Sound()
    {return "nothing";} 
}

class Bird extends Animal
{   public Bird(String n) 
    {super(n);
     }

    public void output()
    {System.out.println("Bird  Name:"+name);}

    public String moves()
    {return "fly";}

    public String Sound()
    {return "Chirp!";}
}

abstract class Mammal extends Animal
{   public Mammal(String n) 
    {super(n);
      sound="";
    }

    public String Sound()
    {return sound;}

    protected String sound;
}

class SeaMammal extends Mammal
{   public SeaMammal(String n) 
    {super(n);
      sound="Uuu";
    }

     public void output()
     {System.out.println("SeaMammal Name:"+name);}

     public String moves()
    {return "swim";} 
}

class TerreMammal extends Mammal
{   public TerreMammal(String n) 
    {super(n);
      sound="Rrr";
    }

     public void output()
     {System.out.println("TerreMammal    Name:"+name);}

     public String moves()
    {return "run";} 
}

