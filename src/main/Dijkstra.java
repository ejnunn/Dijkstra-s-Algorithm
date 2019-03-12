package main;

import java.util.Set;

import javafx.util.Pair;
import main.Graph.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Dijkstra's shortest path algorithm.
 * Input: 	graph g
 * 			start vertex
 * Output:	HashMap of shortest path cost from start to each other vertex
 * 			HashMap of shortest path for each vertex in g (except start)
 * @author ericnunn
 *
 */
public class Dijkstra {
	public static Pair<HashMap<String, Integer>, HashMap<String, String>> dijkstra(Graph g, String start) { // FIXME - return two HashMaps
		Integer n = g.vertices().size(); // n is |V|, number of vertices in the graph
		HashMap<String, String> path = new HashMap<>();
		Set<String> found = new HashSet<>();
		HashMap<String, Integer> shortest = new HashMap<>();
		for (String v : g.vertices()) {
			path.put(v, null);
			shortest.put(v, Integer.MAX_VALUE);
		}
		shortest.put(start, 0);
		Heap unsolved = new Heap(shortest);
		
		// get shortest path to every other vertex
		while (found.size() < n) {
			// find closest unsolved vertex
			Pair<String, Integer> cdPair = unsolved.dequeue();
			String closest = cdPair.getKey();
			Integer distance = cdPair.getValue();
			
			// closest vertex is now solved, we know that no other shorter path exists
			found.add(closest);
			
			// update paths to other vertices via closest
			// FIXME - translate to java from Python
			for (Edge k : g.outgoing(closest)) {
				String vertexTo = k.getVertexTo();
				if (!found.contains(vertexTo)) {
					Integer newPathToK = shortest.get(closest) + k.getWeight();
					if (newPathToK < unsolved.weights.get(vertexTo)) {
						unsolved.enqueue(vertexTo, newPathToK); // fix weight in priority queue
						shortest.put(vertexTo, newPathToK);
						path.put(vertexTo, closest);
					}
				}
			}
		}
		
		// report results (not officially part of Dijkstra's--we wouldn't count this in time analysis)
		HashMap<String, String> paths = new HashMap<>();
		for (String v : g.vertices()) {
			if (v != start) {
				ArrayList<String> thisPath = new ArrayList<>(); // collect the previously-found shortest path edges from start to v
				String w = v;
				while (w != start) {
					thisPath.add(w); // w is previous vertex in shortest path
					w = path.get(w);
				}
				thisPath.add(start);
				Collections.reverse(thisPath);
				String listToString = "";
				for (String s : thisPath) {
					listToString += s;
				}
				paths.put(v, listToString);
			}
		}
		shortest.remove(start); // take out shortest[start] which is zero
		
		return new Pair<HashMap<String, Integer>, HashMap<String, String>>(shortest, paths);
	} // end dijkstra
} // end Dijkstra class
