package main;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


/**
 * 
 * @author ericnunn
 *
 */
public class Graph {
	private Map<String, Map<String, Integer>> adjList;
	
	/**
	 * 
	 */
	public Graph() {
		this.adjList = new HashMap<>();
	} // end constructor
	
	/**
	 * 
	 * @param vertex_from
	 * @param vertex_to
	 * @param weight
	 */
	public void addEdge(String vertex_from, String vertex_to, Integer weight) {
		this.adjList.get(vertex_from).put(vertex_to, weight);
	} // end addEdge
	
	/**
	 * 
	 * @param vertex_from
	 * @param vertex_to
	 */
	public void addEdge(String vertex_from, String vertex_to) {
		Integer weight = 1;
		this.adjList.get(vertex_from).put(vertex_to, weight);
	} // end addEdge
	
	/**
	 * 
	 * @param vertex
	 * @return
	 */
	public ArrayList<String> outgoing(String vertex) {
		return new ArrayList<>(this.adjList.get(vertex).keySet());
	} // end outgoing
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> vertices() {
		return new ArrayList<>(this.adjList.keySet());
	} // end vertices
} // end Graph