import java.util.*;

public class Solution {
    static class Node {
        int index;
        Node prev, next;
        Node(int index) {
            this.index = index;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
                nodes[i - 1].next = nodes[i];
            }
        }

        Stack<Node> removedNodes = new Stack<>();
        Node current = nodes[k];

        for (String c : cmd) {
            char command = c.charAt(0);
            if (command == 'U') {
                int x = Integer.parseInt(c.substring(2));
                while (x-- > 0 && current.prev != null) current = current.prev;
            } else if (command == 'D') {
                int x = Integer.parseInt(c.substring(2));
                while (x-- > 0 && current.next != null) current = current.next;
            } else if (command == 'C') {
                removedNodes.push(current);
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                current = (current.next != null) ? current.next : current.prev;
            } else if (command == 'Z') {
                Node node = removedNodes.pop();
                if (node.prev != null) node.prev.next = node;
                if (node.next != null) node.next.prev = node;
            }
        }

        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!removedNodes.isEmpty()) {
            Node node = removedNodes.pop();
            answer.setCharAt(node.index, 'X');
        }

        return answer.toString();
    }
}