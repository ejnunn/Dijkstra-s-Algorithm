package main;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;
import main.Graph.Edge;

public class Main {

	public static void main(String[] args) {
		System.out.println("Testing Heap class.");
		Pair<String, Integer> keyValuePair;
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("a", 1);
		hm.put("b", 10);
		hm.put("c", -3);
		
		Heap h = new Heap(hm);
		
		System.out.println(h.empty() + " expect false");
		keyValuePair = h.dequeue();
		System.out.println(keyValuePair.getKey() + " " + keyValuePair.getValue() + " expect c -3");
		keyValuePair = h.dequeue();
		System.out.println(keyValuePair.getKey() + " " + keyValuePair.getValue() + " expect a 1");
		keyValuePair = h.dequeue();
		System.out.println(keyValuePair.getKey() + " " + keyValuePair.getValue() + " expect b 10");
		System.out.println(h.empty() + " expect true");
		
		
		
		System.out.println("\nTesting Graph class.");
		Graph g = new Graph();
		g.addEdge("a", "b", 12);
		g.addEdge("a", "c", 13);
		g.addEdge("b", "a", 12); // if we want an undirected graph we have to put identical edges in both directions
		g.addEdge("c", "a", 13);
		g.addEdge("a", "d", 5);
		g.addEdge("d", "b", 3);
		
		
		ArrayList<String> vertices = g.vertices();
		for (String vertex : vertices) {
			System.out.println("Vertex: " + vertex);
			
			ArrayList<Edge> edges = g.outgoing(vertex);
			for (Edge edge : edges) {
				System.out.println("\t" + edge.getVertexFrom() + "->" + edge.getVertexTo() + " (" + edge.getWeight() + ")");
			}
		}
		
		
		
		System.out.println("\nTesting Dijkstra class");
		Dijkstra d = new Dijkstra();
		Pair<HashMap<String, Integer>, HashMap<String, String>> result = d.dijkstra(g, "a");
		System.out.println(result.getKey().toString());
		System.out.println(result.getValue().toString());
		
	} // end main
} // end Main
