import javax.lang.model.util.ElementScanner6;

public class Question {
    //[2:57 PM] M N, Jayanarayanan (DI SW MG IES)
    
//"Write a program that prints the numbers from 1 to 100. 
//But for multiples of three print “Fizz” instead of the number 
//and for the multiples of five print “Buzz”. 
//For numbers which are multiples of both three and five print “FizzBuzz”."

public void fizzBuzzMethod(int n)
{
    
    for(int i = 1; i <= n; i++ )
    {
        if( i % 3 == 0 && i % 5 == 0)
          System.out.println("FizzBuzz");
        else if( i % 3 == 0)
          System.out.println("Fizz");
        else if(i % 5 == 0)
          System.out.println("Buzz");
        else
          System.out.println(i);
    }
}
public static void main(String[] args) {
    Question q = new Question();
    q.fizzBuzzMethod(100);

    System.out.println(" Output :"+ q.simpleFizzBuzz(5));
}

public String simpleFizzBuzz(int i)
{

  if( i % 3 == 0 && i % 5 == 0)
    return ("FizzBuzz");
  else if( i % 3 == 0)
    return ("Fizz");
  else if(i % 5 == 0)
    return  ("Buzz");
  else
    return Integer.toString(i);

}
}
