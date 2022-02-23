package ASM3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	int[][] matrix = new int[7][7];
	MyBSTree myBSTree = new MyBSTree();

	public void insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input new ID: ");
		String id = scan.nextLine();
		System.out.println("Input Name: ");
		String name = scan.nextLine();
		System.out.println("Input birthplace: ");
		String birthplace = scan.nextLine();
		System.out.println(" input Birth of Date: ");
		String bod = scan.nextLine();
		Person p = new Person(id, name, birthplace, bod);
		myBSTree.Insert(p);
	}

	public void showInoder() {
		myBSTree.showInoder();
	}

	public void showPreoder() {
		myBSTree.showpreoder();
	}

	public void showPostoder() {
		myBSTree.showPostoder();
	}

	public void showTreequeue() {
		myBSTree.BFT();

	}

	public void Search() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter ID");
		String id = scan.nextLine();
		myBSTree.Search(id);
	}

	public void Delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter ID");
		String id = scan.nextLine();
		myBSTree.Delete(id);
		System.out.println("successful delete ");

	}

	public void balance() {
		myBSTree.balance();
		System.out.println("successful balance");
	}

	// chuyen String thanh int,int dai dien cho String Diem
	public static int row(String str) {
		switch (str) {
		case "A":
			return 0;
		case "B":
			return 1;
		case "C":
			return 2;
		case "D":
			return 3;
		case "E":
			return 4;
		case "F":
			return 5;
		case "G":
			return 6;
		default:
			return -1;
		}
	}

	// Chuyen int thanh String Diem
	public static String point(int i) {
		String string[] = { "A", "B", "C", "D", "E", "F", "G" };
		return string[i];
	}

	// Duyet theo chieu sau
	public void DFS() {
		Scanner scan = null;
		try {
			scan = new Scanner(Paths.get(
					"C:\\JAVAFUNIX\\CSD201x_02-A_VN - Assignment 3 - tamdtfx08938@funix.edu.vn\\src\\ASM3\\matrix.TXT"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 0;
		//// đọc file theo dòng
		while (scan.hasNext()) {
			String s = scan.nextLine();
			String string[] = s.split("\\s+");
			for (int j = 0; j < string.length; j++) {
				matrix[i][j] = Integer.parseInt(string[j]);
			}
			i++;
		}
		// Diem bat dau
		Stack<String> stack = new Stack<>();
		stack.push("A");
		String print = "";
		// check da di qua true va chua di qua false
		boolean check[] = new boolean[7];
		for (int a = 0; a < check.length; a++) {
			check[a] = false;
		}
		// bat dau duyet A1 = true
		check[row("A")] = true;
		while (!stack.isEmpty()) {
			String str = stack.pop();// nhung diem loai ra
			print += str + "";// in ra duong di
			int h = row(str);// hang vua pop
			for (int j = matrix[h].length - 1; j >= 0; j--) {// quet cac diem trong mot hang
				if (matrix[h][j] != 0 && matrix[h][j] != 9999) {// neu cac diem khac 0 va 9999 thi
					if (check[j] == false) {// check da di qua
						check[j] = true;
						stack.push(point(j));// them gia tri diem trong mot hang h vao stack
					}
				}

			}

		}
		System.out.println(print);

	}

	/////////////////////////////////////////////////////////////////////////////
	// in matrix
	public void infomationmatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 9999) {
					System.out.print(String.format("%-20d", matrix[i][j]));
				} else {
					System.out.print(String.format("%-20s", "INF"));
				}
			}
			System.out.println();
		}
	}

	// dijikask
	public int[][] copy(int marix[][]) {
		Scanner scan = null;
		try {
			scan = new Scanner(Paths.get(
					"C:\\JAVAFUNIX\\CSD201x_02-A_VN - Assignment 3 - tamdtfx08938@funix.edu.vn\\src\\ASM3\\matrix.TXT"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 0;
		//// đọc file theo dòng
		while (scan.hasNext()) {
			String s = scan.nextLine();
			String string[] = s.split("\\s+");
			for (int j = 0; j < string.length; j++) {
				matrix[i][j] = Integer.parseInt(string[j]);
			}
			i++;
		}
		return matrix;

	}

	private static final int NO_PARENT = -1;

	public void dijkstra(int[][] adjacencyMatrix, int startVertex) {
		//em tham khao
		//https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/?fbclid=IwAR38eNTFEMb2uyBDMze79Db_NYZlVryiPCeJwKe46wWrIlGmc4rXp_aaT6M
		//roi sua mot vai cho ve cach in ra diem va gia tri dieu kien
		int nVertices = adjacencyMatrix[0].length;
		int[] shortestDistances = new int[nVertices];
		boolean[] added = new boolean[nVertices];
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			added[vertexIndex] = false;
		}
		shortestDistances[startVertex] = 0;
		int[] parents = new int[nVertices];
		parents[startVertex] = NO_PARENT;
		for (int i = 1; i < nVertices; i++) {
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}
			added[nearestVertex] = true;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}
		printSolution(startVertex, shortestDistances, parents);
	}

	public void printSolution(int startVertex, int[] distances, int[] parents) {
		infomationmatrix(copy(matrix));
		int nVertices = distances.length;
		System.out.print("Vertex\t Distance\tPath");
		for (int vertexIndex = 4; vertexIndex < 5; vertexIndex++) {
			if (vertexIndex != startVertex) {
				// sua mot so cho de in
				System.out.print("\n" + point(startVertex) + " -> ");
				System.out.print(point(vertexIndex) + " \t\t ");
				System.out.print(distances[vertexIndex] + "\t\t");
				printPath(vertexIndex, parents);
			}
		}
	}

	private static void printPath(int currentVertex, int[] parents) {

		if (currentVertex == NO_PARENT) {
			return;
		}
		printPath(parents[currentVertex], parents);
		System.out.print(point(currentVertex) + " ");
	}

}
