public class RecursionType {
    public static void main(String[] args) {
        System.out.println(normalRecursion(5));
        System.out.println(tailRecursion(5,0));
    }

    private static int normalRecursion(int k) {
        if(k == 0 )
        return 0;
        return k+ normalRecursion(k-1);
    }

    private static int tailRecursion(int k , int i) {
        if( k == 0)
          return i;
        return tailRecursion(k-1, i +k);
          
    }
}
