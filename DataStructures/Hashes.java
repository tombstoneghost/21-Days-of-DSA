public class Hashes {

    static int hash = 0;

    //Folding Method    
    public static int hashCode(int n, int k) {
        while(n != 0) {
            int rem = n % (int)Math.pow(10, k);
            hash += rem;
            n /= 10;
        }
        return hash;
    }

    //HashCode for String
    public static int hashCode(String s, int g) {
        for(int i = 0; i < s.length(); i++) {
            hash = g * hash + s.charAt(i);
        }
        
        return hash;
    }

    public static void main(String[] args) {
        int n = 632541578;
        int k = 3;

        String s = "Hello World! This is Java";
        int g = 31;
    
        System.out.println("Integer Hash: " + hashCode(n ,k));
        System.out.println("String Hash: " + hashCode(s, g));
    }
}