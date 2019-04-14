
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

