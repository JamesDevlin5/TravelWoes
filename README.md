
# CS 3000 Programming Challenge: Travel Woes

[URL](http://hr.gs/CS3000Spring2019)

## Input

Lines of String to **STDIN**:

* [*The number of cities total*] [*The number of flight routes total*]
* [*src*] [*dst*] [*cost*]
* *...*
* [*origin*] [*target*]

## Output

To **STDOUT**, the minimum cost to travel from the origin to the target using the flights listed, or -1 if there is no possible route.

## Constraints

An efficient algorithm for this problem should run in **O((|*cities*| + |*flights*|) \* log|*cities*|)** time.
**Do not** import, include, or use any additional libraries that are not already defined and provided by the head, except Scanner to read input.
Additionally, it is given that the following rules will be followed on input:

    * 1 <= |cities|                 <= 50000
    * 1 <= |flights|                <= 600000
    * 1 <= origin, src, dst, target <= |cities|
    * 1 <= target                   <= 5000

## Psuedocode

Using an adjacency list, we may implement a min-heap to store the value of the shortest path so far to any node in the graph as we traverse away from the source.
Once the destination node is located, the search may halt as there is no more information to gather.
The psuedocode for this process is as follows:

	1. Create min-heap of size |V|, such that key(i) = minimum cost path to vertex i
	2. Initialize:
		for i := 1 ... |V|:
			key(i) := infinity
		key(source) := 0
	3. Iterate edges:
		while key is not empty:
			next := key.remove()
			for neighbors of next:
				if neighbor is in key:
					if key(neighbor) > key(next) + cost(next -> neighbor):
						key(neighbor) := key(next) + cost(next -> neighbor)


This algorithm will be easy to implement, assuming that we have access to a min-heap data structure that can guarantee a min-key extract time of O(log|V|).
In a min-heap, the key of the root must be minimum among the keys present in all children, which must be recursively true for all its sub-trees.

## Implementation

In this implementation of the travel woes solution, I attempted to stay away from abstraction and general object oriented paradigms, in order to ensure that the correct run time is achieved.
The modularity of the program is structured as follows:

### Solution

1. Constructor: The constructor of a solution object accepts an input stream as a parameter, which it then uses to extract the following:
	* The total number of nodes and edges: |V| and |E|
	* The information describing each edge: E
	* The source and destination nodes: v0 and vn

2. Shortest Path: The function which provides a means of creating a heap and determining the shortest path between the two provided points:
	* Initialize heap
	* Iterate edges, selecting the next lowest-possible cost route each time, until the target is reached

### Cons List

This inner-class is used to represent an adjacency list of all reachable vertices for any given vertex.
This implementation allows for O(V + E) time traversal of the graph.

The properties of each cons list object, and their associated roles, are as follows:

* *vertex:* The vertex that is reachable via this edge
* *weight:* The weight or cost to traverse this edge
* *rest:* The rest of the cons list, used to access elements in the linked list in linear time

### Min Heap

This inner-class is used to represent the lowest-possible route thus far to any node whose optimal route is still being determined.
This implementation is partially ordered, such that the root element is the smallest contained in the heap which is also recursively true for subtrees.


The functions included in this data structure class are as follows:

* *size():* The number of elements remaining in the heap
* *getKey(key):* Getter for the value associated with the key in the heap
* *updateKey(src, dst, cost):* Updates the value of the *dst* key to be *key[src] + cost* if this is less than the current key
	* *swap(index0, index1):* self-contained (private) function to swap two elements in the tree
* *extractMin():* Removes the current root of the tree
* *initHeap(int src):* Initializes the heap for our requirements, setting the value of each vertex := infinity and source := 0
