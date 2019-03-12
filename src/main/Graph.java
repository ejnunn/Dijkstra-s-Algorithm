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
	ArrayList<String> vertexList;
	HashMap<String, ArrayList<Edge>> edgeList;
	
	/**
	 * 
	 */
	public Graph() {
		this.vertexList = new ArrayList<>();
		this.edgeList = new HashMap<>();
	} // end constructor
	
	/**
	 * Add a new Edge to the given vertex. If the vertex doesn't have any edges yet,
	 * create a new key in the HashMap with the name of the given vertex.
	 * @param vertex_from	vertex with outgoing edge
	 * @param vertex_to		vertex with incoming edge
	 * @param weight		weight of the edge
	 */
	public void addEdge(String vertex_from, String vertex_to, Integer weight) {
		if (!this.vertexList.contains(vertex_from)) {
			this.vertexList.add(vertex_from)
;		}
		if (!this.vertexList.contains(vertex_to)) {
			this.vertexList.add(vertex_to)
;		}
		if (this.edgeList.get(vertex_from) == null) { 
			this.edgeList.put(vertex_from, new ArrayList<>());
		}
		this.edgeList.get(vertex_from).add(new Edge(vertex_from, vertex_to, weight));
	} // end addEdge
	
	/**
	 * Add a new Edge to the given vertex. Default weight value is 1.
	 * @param vertex_from	vertex with outgoing edge
	 * @param vertex_to		vertex with incoming edge
	 */
	public void addEdge(String vertex_from, String vertex_to) { 
		this.addEdge(vertex_from, vertex_to, 1);
	} // end addEdge
	
	/**
	 * 
	 * @param vertex
	 * @return
	 */
	public ArrayList<Edge> outgoing(String vertex) {
		ArrayList<Edge> outgoing = new ArrayList<>();
		for (Edge e : this.edgeList.get(vertex)) {
			outgoing.add(e);	
		}
		return outgoing;
	} // end outgoing
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> vertices() {
		return vertexList;
	} // end vertices
	
	
	/**
	 * 
	 * @author ericnunn
	 *
	 */
	public class Edge {
		private String v_from;
		private String v_to;
		private Integer weight;
		
		/**
		 * 
		 * @param v_from
		 * @param v_to
		 * @param w
		 */
		public Edge(String v_from, String v_to, Integer w) {
			this.v_from = v_from;
			this.v_to = v_to;
			this.weight = w;
		} // end constructor
		
		/**
		 * 
		 * @return
		 */
		public String getVertexFrom() {
			return v_from;
		} // end getVertexFrom
		
		/**
		 * 
		 * @return
		 */
		public String getVertexTo() {
			return v_to;
		} // end getVertexTo
		
		/**
		 * 
		 * @return
		 */
		public Integer getWeight() {
			return this.weight;
		} // end getWeight
	} // end Edge
} // end Graph