### **Learning Objectives**
- **Graph Traversal:** Understand breadth-first search (BFS) for shortest path problems in 3D spaces.
- **Topological Sorting:** Learn to sort directed acyclic graphs (DAGs) for dependency resolution while minimizing specific constraints.
- **Flow Networks:** Explore the Ford-Fulkerson algorithm to calculate maximum flow in weighted directed graphs.
- **Algorithm Design:** Enhance skills in implementing and optimizing graph algorithms for real-world problems.

---

### **Computer Science Concepts Covered**
- **Graph Algorithms:**
  - BFS for shortest paths in 3D grids.
  - Topological sorting for dependency resolution.
  - Ford-Fulkerson for maximum flow in flow networks.
- **Data Structures:**
  - Graphs (adjacency lists and matrices).
  - Hashtable for graph representation and dependencies.
  - ArrayLists for managing paths and edges.
- **Algorithmic Thinking:**
  - Efficiently finding paths in complex graph structures.
  - Dependency management in directed graphs.
  - Optimizing flows in networks using residual graphs.

---

### **Problem and Question Summary**
#### **Question 1: Graph Traversal**  
- **Problem:** Help Dr. Bruce Banner escape a 3D jail represented as a grid of unit cubes.
- **Task:** Implement a BFS-based algorithm to determine the shortest path from the start ("S") to the exit ("E"). Return the shortest time required or `-1` if escape is not possible.

#### **Question 2: Topological Sort**  
- **Problem:** Minimize the transportation of a ring between planets while respecting dependencies among repair stages.
- **Task:** Implement a topological sort-based algorithm to find the optimal sequence of repair stages in a DAG and minimize interplanetary transfers.

#### **Question 3: Flow Network**  
- **Problem:** Compute the maximum flow in a directed, weighted graph.
- **Task:** Use the Ford-Fulkerson algorithm to calculate the maximum flow and update the graph to reflect the flow values. Implement DFS to find paths in the residual graph.
