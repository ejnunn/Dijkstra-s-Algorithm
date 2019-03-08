package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Min heap. Elements are key:weight pairs. Ops are:
 * 1. construct from set of key:value pairs (a hashmap), 0(n)
 * 2. enqueue a new or existing key with its current weight, 0(log n)
 * 3. dequeue the key with the minimum weight, 0(log n)
 * 4. empty tells if the heap is empty, 0(1)
 * 
 * @author ericnunn
 *
 */
public class Heap {
	private Map<String, Integer> weights;
	private Map<String, Integer> place;
	private List<String> heap;
	
	/**
	 * Builds a min heap from an initial HashMap, and keeps track
	 * of the location of each item in the heap so that its wieght
	 * can be changed (and the heap repaired in 0(log n) time.
	 * @param initial HashMap to heapify
	 */
	public Heap(HashMap<String, Integer> initial) {
		this.weights = new HashMap<>();
		this.place = new HashMap<>();
		this.heap = new ArrayList<>();
		
		Integer last = 0;
		for (String key : initial.keySet()) {
			this.heap.add(key);
			this.weights.put(key, initial.get(key));
			this.place.put(key, last);
			last++;
			this.heapConstruct();
		}
	} // end constructor
	
	/**
	 * Returns true if there are no more items in the heap.
	 * @return true if the heap is empty, otherwise false
	 */
	public boolean empty() {
		return this.heap.size() == 0;
	} // end empty
	
	/**
	 * Put key into heap with given weight. If key is already present,
	 * this will change the heap as necessary.
	 * @param key	key of new key:weight pair to add to the heap
	 * @para weight	weight of the key:weight pair to add to the heap
	 */
	public void enqueue(String key, Integer weight) {
		Integer old_w;
		Integer i;
		
		if (this.weights.containsKey(key)) {
			old_w = this.weights.get(key);
			i = this.place.get(key);
		}
		else {
			this.heap.add(key);
			old_w = null;
			i = this.last();
			this.place.put(key, i);
		}
		
		this.weights.put(key, weight);
		
		if (old_w != null || old_w > weight) {
			this.swapUp(i);
		}
		else if (old_w < weight) {
			this.swapDown(i);
		}
	} // end enqueue
	
	
	private void heapConstruct() {
		
	} // end heapConstruct
	
	private Integer last() {
		return this.heap.size() - 1;
	} // end last
	
	private void swapUp(Integer i) {
		
	}
	
	private void swapDown(Integer i) {
		
	}
} // end Heap
