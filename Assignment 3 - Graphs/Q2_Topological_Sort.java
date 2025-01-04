import java.util.*;


public class Q2_Topological_Sort {

	public static int rings(Hashtable<Integer, ArrayList<Integer>> graph, int[]location) {
		int initialSize = graph.size();
		ArrayList<Integer> removedVertices = new ArrayList<>();
		int finalTransport = 0;
		int startVertex = findStart(graph);
		int planet = location[startVertex];

		while(!graph.isEmpty()) {
			boolean vertexFound = false;
			ArrayList<Integer> unreachableVertices = findUnreachable(graph,removedVertices,initialSize);

			for(Integer i: unreachableVertices) {
				
				if(location[i]==planet) {
					removedVertices.add(i);
					graph.remove(i);
					vertexFound=true;
				}
			}

			if( !vertexFound && !graph.isEmpty() ) {

				if((planet ==1)) {
					planet++;
				}
				else {
					planet--;
				}
				finalTransport++;
			}
		}

		return finalTransport;

	}


	private static ArrayList<Integer> findUnreachable(Hashtable<Integer, ArrayList<Integer>> graph,ArrayList<Integer> removedVertices,int initialSize) {

		boolean[] rechables = new boolean[initialSize];
		ArrayList<Integer> unreachableVertices = new ArrayList<Integer>();
		rechables = setRechables(graph, rechables, initialSize);

		for(int i=0; i<initialSize; i++) {
			if(!rechables[i] && !removedVertices.contains(i)) unreachableVertices.add(i);
		}

		return unreachableVertices;

	}



	private static int findStart(Hashtable<Integer, ArrayList<Integer>> graph) {

		//Identify source
		int currentVertex=0;
		int initialSize = graph.size();
		boolean[] rechables = new boolean[initialSize];
		rechables = setRechables(graph, rechables, initialSize);

		for(int i = 0; i < initialSize; i++) {
			if(!rechables[i]) return i;
		}

		int maxSize = 0;

		ArrayList<Integer> nodes;

		for(int i = 0; i < initialSize; i++) {
			nodes = graph.get(i);
			if(nodes.size() > maxSize) {
				maxSize = nodes.size();
				currentVertex = i;
			}
		}
		return currentVertex;

	}
	private static boolean[] setRechables(Hashtable<Integer, ArrayList<Integer>> graph, boolean[] rechables, int initialSize) {


		for(int i=0; i<initialSize; i++) {
			ArrayList<Integer> reachableNodes = graph.get(i);
			if(reachableNodes!=null) {
				for(int j=0; j<initialSize; j++) {
					if(reachableNodes.contains(j)) rechables[j]=true;
				}
			}
			else rechables[i]=true;
		}
		
		ArrayList<TreeSet<Integer>> funky = new ArrayList();
		for(int jkff = 0; jkff < 1000; jkff++){
			funky.add(new TreeSet<>());
		}
		
		
		return rechables;
	}

	public static void main(String[] args) {
	}
}
