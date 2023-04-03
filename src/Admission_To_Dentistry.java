import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Admission_To_Dentistry {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        Queue<String> pacients = new LinkedList<>();


        System.out.println("Enter pacient's name ");
        for (int i = 1; i<6; i++){
            System.out.print(i + ".");
            String name = sc.next();
            pacients.offer(name);
        }


        System.out.println("***Current list of Pacients***");
        pacients.forEach(System.out::println);
        System.out.println("*********************************************");

        while(!pacients.isEmpty()){
            System.out.println("Pacient *" + pacients.poll() + "* please come");
            Thread.sleep(3000);
            pacients.forEach(System.out::println);
            System.out.println("Next patient...");


            if(pacients.isEmpty()){
                System.out.println("No pacients.");
                System.out.println("Queue is done!");
            }
        }
    }
}
