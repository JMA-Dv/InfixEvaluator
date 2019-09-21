public class NodeValue {
    Node node;
    int value;
    public NodeValue(Node node, int value){
        this.node= node;
        this.value = value;
    }
    public Node getNode(){
        return node;
    }
    public int getValue(){
        return  value;
    }
}
