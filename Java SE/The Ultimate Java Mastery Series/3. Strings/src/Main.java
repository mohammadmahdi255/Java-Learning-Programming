public class Main {

    public static void main(String[] args) {
        String message = " \\Hello \"World\"" + "!!";
        System.out.println(message);
        System.out.println(message.length());
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message.trim());
        System.out.println(message.indexOf("W"));
        System.out.println(message.replace("!", "*"));
    }
}
