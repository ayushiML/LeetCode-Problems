public class checkDefaultInterfaceWorking implements InterfaceOne,InterfaceTwo {
    //I just want to add that even if the method in I1 is abstract, and default in I2, you cannot implement both of them
    @Override
    public String getGreeting()
    {
        System.out.println("afternoon");
        InterfaceOne.super.getGreeting();
        return null;
    }
    

//If a class implements 2 interfaces both of which have a java-8 default 
//method with the same signature (as in your example) the implementing class 
//is obliged to override the 
//method. The class can still access the default method using I1.super.getGreeting();
    public static void main(String[] args) {
        System.out.println(new checkDefaultInterfaceWorking().getGreeting());
    }
}
