public class Node {
    public char data;
    public Node leftChild;
    public Node rightChild;

    public Node(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public void displayNode(){
        System.out.print(data);
    }
}
