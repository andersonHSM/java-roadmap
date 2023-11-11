public class DataTypes {
    public static void main(String[] args) {
        System.out.println("Built in data types: \n");

        System.out.print("Booleans: ");
        boolean one = true;
        boolean two = false; // default value;
        System.out.println(one + " or " + two);


        System.out.println("\nByte Data type:");

        // can replace int. takes only 8 bits, instead of 32 bits for an int.
        byte a = 10;
        byte b = -20;

        System.out.println("a: " + a + " and b: " + b);

        System.out.println("\nShort Data type:");

        // 16 bits integer, also used to save space.
        short minimumShort = -32768;
        short maximumShort = 32767;

        System.out.println("minimum: " + minimumShort + " and maximum: " + maximumShort);

        System.out.println("\nInt Data type:");

        // default integer type if there's no memory issues.
        int minimumInt = -2147483648;
        int maximumInt = 2147483647;

        System.out.println("minimum: " + minimumInt + " and maximum: " + maximumInt);

        // other data types can be reviewed at: https://www.javatpoint.com/java-data-types



    }
}
