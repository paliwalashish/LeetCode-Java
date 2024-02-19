package com.ap.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LC: https://leetcode.com/problems/clone-graph/description/
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        Map<Node, Node> nodeMapping = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        Node newRoot = new Node(node.val);
        nodeMapping.put(node, newRoot);

        queue.offer(node);

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            Node clonedNode = nodeMapping.get(n);
            for(Node n1: n.neighbors) {
                if(!nodeMapping.containsKey(n1)) {
                    Node newNode = new Node(n1.val);
                    nodeMapping.put(n1, newNode);
                    queue.offer(n1);
                }
                clonedNode.neighbors.add(nodeMapping.get(n1));
            }
        }
        return newRoot;
    }
}
