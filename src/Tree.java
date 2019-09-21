import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Tree {

    int nodeNumber =0;
    int nodeSymbol =0;
    NodeValue nodeValue;
    ArrayList<Node> post = new ArrayList<Node>();
    ArrayList<Node> pre = new ArrayList<Node>();
    Node root;

    public Node getRoot(){
        return root;
    }

    public Tree(){
        root=null;
    }


    public void insert(String s)throws IOException{
        Conversion c = new Conversion(s);
        s = c.inToPost();

        Stack stk = new Stack();
        s = s + "#";

        int i = 0;
        char symbol = s.charAt(i);

        Node newNode;
        while (symbol != '#') {

            if (symbol >= '0' && symbol <= '9' || symbol >= 'A'
                    && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') {

                newNode = new Node(symbol);

                stk.push(newNode);

                //System.out.println("it is simbol first "+newNode);
            } else if (symbol == '+' || symbol == '-' || symbol == '/'
                    || symbol == '*') {
                nodeSymbol++;
                Node ptr1 =(Node) stk.pop();

                Node ptr2 =(Node) stk.pop();



                newNode = new Node(symbol);

                System.out.println("Symbol Node "+nodeSymbol+" " + symbol);

                newNode.leftChild = ptr2;

                String a = ptr2.toString();
                if (!a.equals('+') && !a.equals('-') && !a.equals('/') && !a.equals('*' ) )
                    nodeNumber++;

                System.out.println("Left child from"+ symbol +" Node child "+ (nodeNumber)+" "+ ptr2);



                newNode.rightChild = ptr1;
                a=ptr1.toString();
                if (!a.equals('+') && !a.equals('-') && !a.equals('/') && !a.equals('*' ))
                    nodeNumber++;

                System.out.println("Right child from "+symbol+" Node child "+(nodeNumber)+" " + ptr1);
                stk.push(newNode);

            }

            symbol = s.charAt(++i);

        }

        root = (Node)stk.pop();
        System.out.println("Number nodes" + nodeNumber);
    }
    public void traverse(int type) {

        switch (type) {

            case 1:

                System.out.print("Preorder :-    ");

                preOrder(root);

                break;

            case 2:

                System.out.print("Inorder :-     ");

                inOrder(root);

                break;

            case 3:

                System.out.print("Postorder :-   ");

                postOrder(root);

                break;

            default:

                System.out.println("Invalid Choice");

        }

    }

    private void preOrder(Node localRoot) {

        if (localRoot != null) {

            localRoot.displayNode();

            preOrder(localRoot.leftChild);

            preOrder(localRoot.rightChild);



        }

    }

    private void inOrder(Node localRoot) {

        if (localRoot != null) {

            inOrder(localRoot.leftChild);

            localRoot.displayNode();

            inOrder(localRoot.rightChild);

        }

    }

    private void postOrder(Node localRoot) {

        if (localRoot != null) {

            postOrder(localRoot.leftChild);

            postOrder(localRoot.rightChild);

            localRoot.displayNode();

        }

    }

}
