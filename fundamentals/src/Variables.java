public class Variables {
    public static void main(String[] args) {
        /*
         * Three types: static, instance and local
         * Static: just like C++, lives outside class instance and is allocated when class is loaded
         * Local: will live inside int4 class method and its scope;
         * Instance: lives by the object instance and is available for all methods.
         */

        // Examples:

        System.out.println("Java Variable Example: Add Two Numbers");
        int int1 = 10;
        int int2 = 10;
        int result1 = int1 + int2;
        System.out.println(result1);

        System.out.println("\nJava Variable Example: Widening");

        int int3 = 10;
        float float1;
        float1 = int3;
        System.out.println(int3);
        System.out.println(float1);

        System.out.println("\nJava Variable Example: Narrowing (Typecasting)");

        float float2 = 10.50f;
        //int int4=f;//Compile time error
        int int4 = (int) float2;
        System.out.println(float2);
        System.out.println(int4);

        System.out.println("\nJava Variable Example: Overflow");
        // happens when casting variable can't hold entire value of the previous one
        int int5 = 130;
        byte byte1 = (byte) int5;
        System.out.println(int5);
        System.out.println(byte1);

        System.out.println("\nJava Variable Example: Adding Lower Type");
        byte byte2 = 10;
        byte byte3 = 10;
        //byte c=byte2+byte3;//Compile Time Error: because byte2+byte3=20 will be int
        byte c = (byte) (byte2 + byte3);
        System.out.println(c);


    }
}
