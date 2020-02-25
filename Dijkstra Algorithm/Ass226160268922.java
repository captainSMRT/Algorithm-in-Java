//name: Ong Kai Xuan | SRN: 160268922 | CO2226 cw2

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ass226160268922 {
	static int N;
	static double[][] edges;
	static String airports;
	static String airportsLonLat;
	static String graph;
	static TreeMap<Integer, String> airportNames = new TreeMap<Integer, String>();
	static TreeMap<Integer, Double> airportLon = new TreeMap<Integer, Double>();
	static TreeMap<Integer, Double> airportLat = new TreeMap<Integer, Double>();

	static ArrayList<String> convert(ArrayList<Integer> m) {
		ArrayList<String> z = new ArrayList<String>();
		for (Integer i : m) {
			z.add(airportNames.get(i));
		}
		return z;
	}

	static HashSet<ArrayList<String>> convert(HashSet<ArrayList<Integer>> paths) {
		HashSet<ArrayList<String>> k = new HashSet<ArrayList<String>>();
		for (ArrayList<Integer> p : paths)
			k.add(convert(p));
		return k;
	}

	static ArrayList<Integer> firstElement(HashSet<ArrayList<Integer>> s) {
		return (ArrayList<Integer>) s.toArray()[0];
	}

	static double realDistance(double lat1, double lon1, double lat2, double lon2) {
		int R = 6371;
		// km (change this constant to get miles)
		double dLat = (lat2 - lat1) * Math.PI / 180;
		double dLon = (lon2 - lon1) * Math.PI / 180;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1 * Math.PI / 180)
				* Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

	//This Method is created to compute the initial value of N and Edges based on the Airport ID of airports file
	static void computeNandEdges(String file){
		Scanner s;
		try {
			s = new Scanner(new FileReader(file));
			String z;
			
			//Process of calculating N starts here. Goal is to set N to be the largest airportID + 1
			while (s.hasNext()) {
				z = s.nextLine();
				String[] results = z.split(",");
				if(Integer.parseInt(results[0])>N){
					N = Integer.parseInt(results[0]);
				}
				if(Integer.parseInt(results[1])>N){
					N = Integer.parseInt(results[1]);
				}
			}
			N = N + 1; 
			// Complete calculation of N
			
			//Initializing of edges
			edges = new double[N][N]; 
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					edges[i][j] = 0.0;
			//Complete initialization of edges
			
		} catch (FileNotFoundException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}
	}
	// End of computeNandEdges() Method
	
	//Start of Main here
	public static void main(String[] args) {
		long beginProgram = System.nanoTime();
		System.out.println("Name: Ong Kai Xuan");
		System.out.println("Student ID: 160268922");
		airports = args[0];
		airportsLonLat = args[1];
		graph = args[2];
		
		//Start of Storing every Data from Spreadsheet 
		Scanner s;
		try {
			//Start Storing Data of Routes from Graph
			s = new Scanner(new FileReader(graph + ".csv"));
			computeNandEdges(graph +".csv");
			String z = s.nextLine();
			while (s.hasNext()) {
				z = s.nextLine();
				String[] results = z.split(",");
				edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])] = Double.parseDouble(results[2]);
			}
			//Complete Storing Data of Routes from Graph

			//Start Storing Data for Airports
			s = new Scanner(new FileReader(airports + ".csv"));
			while (s.hasNext()) {
				z = s.nextLine();
				String[] results = z.split(",");
				airportNames.put(Integer.parseInt(results[0]), results[1]);
			}
			//Complete Storing Data for Airports

			//Start Storing Data for both Longitude and Latitude
			s = new Scanner(new FileReader(airportsLonLat + ".csv"));
			while (s.hasNext()) {
				z = s.nextLine();
				String[] results = z.split(",");
				airportLon.put(Integer.parseInt(results[0]), Double.parseDouble(results[1]));
				airportLat.put(Integer.parseInt(results[0]), Double.parseDouble(results[2]));
			} 
			//Complete Storing Data for both Longitude and Latitude
			
		} catch (FileNotFoundException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}
		//End of Storing every Data from Spreadsheet 

		graph G = new Ass226160268922().new graph(edges); 

		// Creating a List to hold Airport Information of ID, 3Digit Code, Longitude and Latitude
		List<Integer> idList = new ArrayList<Integer>();
		List<String> digit3List = new ArrayList<String>();
		List<Double> lonList = new ArrayList<Double>();
		List<Double> latList = new ArrayList<Double>();

		// Assumptions made are:
		// 1) ID(Column 1 of airports file) is the primary key for both airports and airports_lon_lat
		// 2) airports and airports_lon_lat will have the same ID for each tuples even in the future
		//    such that if airports have 500 tuples, airports_lon_lat will also have 500 tuples and each row from both file are correlated to each other
		
		//Storing Airport Information into the list created
		for (int i = airportNames.firstKey(); i <= airportNames.lastKey(); i++) {
			if (airportNames.get(i) != null) {
				idList.add(i);
				digit3List.add(airportNames.get(i));
				lonList.add(airportLon.get(i));
				latList.add(airportLat.get(i));
			}
		}
		//End of Storing Airport Information

		//Start of Question 1
		//initialize st and fin to hold index of ATH and LHR from idList
		int st = 0;
		int fin = 0;
		for (int i = 0; i < digit3List.size(); i++) {
			if (digit3List.get(i).equals("ATH")) {
				st = idList.get(i);
			} else if (digit3List.get(i).equals("LHR")) {
				fin = idList.get(i);
			} else if (st != 0 && fin != 0) {
				break;
			}
		}
		int shortestPathStFinSize = convert(G.shortestPaths(st, fin)).size();
		System.out.println("Question 1: The number of shortest path from " + airportNames.get(st) + " to " + airportNames.get(fin) + " is " + shortestPathStFinSize);
		//End of Question 1
		
		//Start of Question 2, 3 and 4
		//initialize largest to be the number of shortest paths between 2 largest pair (largestPair1 and largestPair2)
		//a double for loop is used to identify the 2 largest pairs
		int largest = 0;
		int largestPair1 = 0;
		int largestPair2 = 0;
		for (int i = 0; i < airportNames.size(); i++) {
			for (int j = 0; j < airportNames.size(); j++) {
				if (G.shortestPaths(idList.get(i), idList.get(j)).size() > largest) {
					largest = G.shortestPaths(idList.get(i), idList.get(j)).size();
					largestPair1 = i;
					largestPair2 = j;

				}
			}
		}
		System.out.println("Question 2: " + idList.get(largestPair1) + " and " + idList.get(largestPair2) + " have the highest number of shortest paths");
		//End of Question 2
		
		System.out.println("Question 3: The number of shortest paths are: " + largest);
		//End of Question 3

		int shortestPathLargestPairSize =  firstElement(G.shortestPaths(idList.get(largestPair1), idList.get(largestPair2))).size();
		System.out.println("Question 4: The length of each shortest path are : " + shortestPathLargestPairSize);
		//End of Question 4

		//Start of Question 5
		//setAirport ArrayList is initialize to hold the id of airports with the furthest number of stops from LAX
		List<Integer> setAirport = new ArrayList<Integer>();
		int furthestNumStop = 0;
		int currentFurthestNumStop;
		int indexLAX = 0;
		int LAX = 0;
		
		//for loop to get the index of LAX from digit3List and then to initialize LAX based on that index using idList
		for (int i = 0; i < digit3List.size(); i++) {
			if (digit3List.get(i).equals("LAX")) {
				indexLAX = i;
			} 
		}
		LAX = idList.get(indexLAX);
		
		//for loop to find the furthest number of stops from LAX
		for (int i = 0; i < airportNames.size(); i++) {
			int temp = idList.get(i);	
			if(!G.shortestPaths(LAX, temp).isEmpty()){
				currentFurthestNumStop = firstElement(G.shortestPaths(LAX, temp)).size();
				if (currentFurthestNumStop >= furthestNumStop) {
					furthestNumStop = currentFurthestNumStop;
				}
			}
		}
		
		//for loop to find all the airports that have the furthest numbers of stops from LAX and store then in setAirport ArrayList
		for (int i = 0; i < airportNames.size(); i++) {
			int temp = idList.get(i);
			if(!G.shortestPaths(LAX, temp).isEmpty()){
				currentFurthestNumStop = firstElement(G.shortestPaths(LAX, temp)).size();
				if (currentFurthestNumStop == furthestNumStop) {
					setAirport.add(idList.get(i));
				}
			}
		}
	
		System.out.println("Question 5: " + setAirport);
		//End of Question 5

		//Start of Question 6
		//initialize st and fin to hold index of LGA and CDG from idList
		st = 0;
		fin = 0;

		for (int i = 0; i < digit3List.size(); i++) {
			if (digit3List.get(i).equals("LGA")) {
				st = idList.get(i);
			} else if (digit3List.get(i).equals("CDG")) {
				fin = idList.get(i);
			} else if (st != 0 && fin != 0) {
				break;
			}
		}

		List<Integer> dijkstraOutput = new ArrayList<Integer>();
		dijkstraOutput = G.dijkstra(st, fin);
		
		double totalWeight = 0;
		for (int i = 0; i < dijkstraOutput.size() - 1; i++) {
			totalWeight = totalWeight + edges[dijkstraOutput.get(i)][dijkstraOutput.get(i + 1)];
		}
		System.out.println("Question 6: The length in terms of sum of the weight of shortest path from " 	+ airportNames.get(st) + " to " + airportNames.get(fin) + " is " + totalWeight);
		//End of Question 6

		//Start of Question 7
		//Restart Storing Data of Routes from Graph this time based on real distance
		try {
			s = new Scanner(new FileReader(graph + ".csv"));
			String z = s.nextLine();
			while (s.hasNext()) {
				z = s.nextLine();
				String[] results = z.split(",");
				edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])] = realDistance(airportLat.get(Integer.parseInt(results[0])), airportLon.get(Integer.parseInt(results[0])), airportLat.get(Integer.parseInt(results[1])), airportLon.get(Integer.parseInt(results[1])));
			}
			G = new Ass226160268922().new graph(edges); 
			
		}catch(FileNotFoundException e){
			System.out.println("File is not found");
		}
		//Complete restoring Data of Routes from Graph
		
		//initialize st and fin to hold index of SIN and FCO from idList
		st = 0;
		fin = 0;
		
		
		for (int i = 0; i < digit3List.size(); i++) {
			if (digit3List.get(i).equals("SIN")) {
				st = idList.get(i);
			} else if (digit3List.get(i).equals("FCO")) {
				fin = idList.get(i);
			} else if (st != 0 && fin != 0) {
				break;
			}
		}

		dijkstraOutput = new ArrayList<Integer>();
		dijkstraOutput = G.dijkstra(st, fin);

		double totalKm = 0;
		for (int i = 0; i < dijkstraOutput.size() - 1; i++) {
			totalKm = totalKm + realDistance(airportLat.get(dijkstraOutput.get(i)), airportLon.get(dijkstraOutput.get(i)), airportLat.get(dijkstraOutput.get(i + 1)), airportLon.get(dijkstraOutput.get(i + 1)));
		}
		
		System.out.println("Question 7: The length in terms of Km of shortest path from " + airportNames.get(st) + " to " + airportNames.get(fin) + " is " + totalKm);
		// End of Question 7

		long endProgram = System.nanoTime() - beginProgram;
		System.out.println("Execution Time: " + endProgram / 1000000 + " milliseconds");
	}
	// End of Main

	//Graph Class is created here
	public class graph {
		double[][] adj;

		graph(double[][] a) {
			adj = new double[a.length][a.length];
			for (int i = 0; i < a.length; i++)
				for (int j = 0; j < a.length; j++)
					adj[i][j] = a[i][j];
		}

		public HashSet<Integer> neighbours(int v) {
			HashSet<Integer> h = new HashSet<Integer>();
			for (int i = 0; i < adj.length; i++)
				if (adj[v][i] != 0)
					h.add(i);
			return h;
		}

		public HashSet<Integer> vertices() {
			HashSet<Integer> h = new HashSet<Integer>();
			for (int i = 0; i < adj.length; i++)
				h.add(i);
			return h;
		}

		ArrayList<Integer> addToEnd(int i, ArrayList<Integer> path)
		// returns a new path with i at the end of path
		{
			ArrayList<Integer> k;
			k = (ArrayList<Integer>) path.clone();
			k.add(i);
			return k;
		}

		//Changes has been made to this given method. Changes made is to prevent direct link between two airports
		public HashSet<ArrayList<Integer>> shortestPaths1(HashSet<ArrayList<Integer>> sofar, HashSet<Integer> visited,
				int end) {
			HashSet<ArrayList<Integer>> more = new HashSet<ArrayList<Integer>>();
			HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
			HashSet<Integer> newVisited = (HashSet<Integer>) visited.clone();
			boolean done = false;
			boolean carryon = false;
			for (ArrayList<Integer> p : sofar) {
				for (Integer z : neighbours(p.get(p.size() - 1))) {
					if (!visited.contains(z)) {
						carryon = true;
						//this block of codes below is to check if there is a direct link. if start and end is direct, it will not be added to newVisited
						if (z == end) { 
							if (p.size() > 1) {
								done = true;
								result.add(addToEnd(z, p));
							} 
						} else{
							newVisited.add(z);
							more.add(addToEnd(z, p));
						}//block of codes to check stops here
						
					}
				}
			}
			if (done)
				return result;
			else if (carryon)
				return shortestPaths1(more, newVisited, end);
			else
				return new HashSet<ArrayList<Integer>>();
		}

		public HashSet<ArrayList<Integer>> shortestPaths(int first, int end) {
			HashSet<ArrayList<Integer>> sofar = new HashSet<ArrayList<Integer>>();
			HashSet<Integer> visited = new HashSet<Integer>();
			ArrayList<Integer> starting = new ArrayList<Integer>();
			starting.add(first);
			sofar.add(starting);
			if (first == end)
				return sofar;
			visited.add(first);
			return shortestPaths1(sofar, visited, end);
		}

		int findSmallest(HashMap<Integer, Double> t) {
			Object[] things = t.keySet().toArray();
			double val = t.get(things[0]);
			int least = (int) things[0];
			Set<Integer> k = t.keySet();
			for (Integer i : k) {
				if (t.get(i) < val) {
					least = i;
					val = t.get(i);
				}
			}
			return least;
		}

		public ArrayList<Integer> dijkstra(int start, int end) {
			int N = Ass226160268922.N;
			HashMap<Integer, Double> Q = new HashMap<Integer, Double>();
			ArrayList<Integer>[] paths = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				Q.put(i, Double.POSITIVE_INFINITY);
				paths[i] = new ArrayList<Integer>();
				paths[i].add(start);
			}
			HashSet<Integer> S = new HashSet();
			S.add(start);
			Q.put(start, 0.0);
			while (!Q.isEmpty()) {
				int v = findSmallest((Q));
				if (v == end && Q.get(v) != Double.POSITIVE_INFINITY)
					return paths[end];
				double w = Q.get(v);
				S.add(v);
				for (int u : neighbours(v))
					if (!S.contains(u)) {
						double w1 = adj[v][u] + w;
						if (w1 < Q.get(u)) {
							Q.put(u, w1);
							paths[u] = addToEnd(u, paths[v]);
						}
					}
				adj[start][end] = Double.POSITIVE_INFINITY; //this single line of code is added here to ensure no direct link between 2 airports
				Q.remove(v);
			}
			return new ArrayList<Integer>();
		}

	}
	// End of Graph Class
}
// End of Program

