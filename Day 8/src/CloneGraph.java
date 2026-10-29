import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Wire the neighbors together
        node1.neighbors.add(node2); node1.neighbors.add(node4);
        node2.neighbors.add(node1); node2.neighbors.add(node3);
        node3.neighbors.add(node2); node3.neighbors.add(node4);
        node4.neighbors.add(node1); node4.neighbors.add(node3);

        System.out.println("--- Original Graph ---");
        printGraph(node1, new HashSet<>());

        // Run the cloning process

        Node clonedRoot = cloneGraph(node1);

        System.out.println("\n--- Cloned Graph ---");
        printGraph(clonedRoot, new HashSet<>());

        System.out.println("\n--- Memory Reference Check ---");
        System.out.println("Original Node 1 HashCode: " + node1.hashCode());
        System.out.println("Cloned Node 1 HashCode:   " + clonedRoot.hashCode());
        System.out.println("Are they the same object in memory? " + (node1 == clonedRoot));
    }
    public static void printGraph(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) {
            return;
        }
        visited.add(node.val);

        System.out.print("Node " + node.val + " neighbors: [");
        for (int i = 0; i < node.neighbors.size(); i++) {
            System.out.print(node.neighbors.get(i).val);
            if (i < node.neighbors.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
     static Map<Node,Node> oldtonew=new HashMap<>();
    public static Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        if(oldtonew.containsKey(node)){
            return oldtonew.get(node);
        }
        Node copy=new Node(node.val);
        oldtonew.put(node,copy);
        for(Node neighbour: node.neighbors){
            copy.neighbors.add(cloneGraph(neighbour));
        }
        return copy;
    }

}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}