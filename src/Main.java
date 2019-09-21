import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);

        System.out.println("Infix Expression");
        String exp = read.nextLine();
        Tree tree = new Tree();
        tree.insert(exp);
        tree.traverse(1);
        System.out.println("");
        tree.traverse(3);
        System.out.println("");

        System.out.println("Posfix Expression");
        exp = read.nextLine();
        Tree tree1 = new Tree();
        tree.insert(exp);
        tree.traverse(1);
        System.out.println("");
        tree.traverse(2);
        System.out.println("");

        System.out.println("Prefix Expression");
        exp = read.nextLine();
        tree1 = new Tree();
        tree.insert(exp);
        tree.traverse(2);
        System.out.println("");
        tree.traverse(3);
        System.out.println("");












    }
}
