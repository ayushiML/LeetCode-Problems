public class FuctionalInteferce {

    //lamda expression is express instance of functional interfaces
    public static void main(String[] args) {
        new Thread(()->{
System.out.println("lamda expression");
        }).start();
    }
}
