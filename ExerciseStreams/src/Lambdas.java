import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Lambdas {


    public static void main(String[] args) {

        Predicate<String> stringLength = (s) -> s.length() > 3;
        System.out.println("String is longer than 3: " + stringLength.test("abcd"));
        List<String> navne = new ArrayList<>();
        navne.add("anna");
        navne.add("jens");
        navne.add("peter");
        navne.add("poul");
        navne.add("bo");
        navne.add("ib");
        navne.stream()
                .filter(stringLength)
                .forEach(System.out::println); // :: = angiver metode uden at kalde den


        //Predicate<Student> predicate = student -> student.isActive ;
        //System.out.println("Student " + navne + " er activ " + predicate);





        Function<Integer, String> convertToString = (number) -> Integer.toString(number);
        System.out.println("Convert " + 5 + " to String: " + convertToString.apply(5));

        BinaryOperator<Double> doubleAdder = (denenedouble, denandendouble) -> denenedouble + denandendouble;
        System.out.println("3.0 + 5.1 = " + doubleAdder.apply(3.0, 5.1));

        UnaryOperator<Double> squared = (number) -> Math.pow(number,2);
        System.out.println("5.1 squared = " + squared.apply( 5.1));

        UnaryOperator<String> navn = s -> new StringBuilder(s).reverse().toString();
        System.out.println("Reverse string " + navn.apply("desrever si ecnetnes sihT"));


    }

    @FunctionalInterface
    interface GiveGrade{
        public boolean grade(int grade);

    }
}