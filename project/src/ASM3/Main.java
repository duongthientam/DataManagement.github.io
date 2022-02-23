package ASM3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		boolean check = true;
		Scanner scan = new Scanner(System.in);
		do {
			menu();
			int chon = scan.nextInt();
			switch (chon) {
			// chen
			case 1: {
				graph.insert();
				break;
			}
			// Inorder traverse
			case 2: {
				System.out.println("You want: ");
				System.out.println("1.Inorder traverse");
				System.out.println("2.Preoder traverse");
				System.out.println("3.Postoder traverse");
				System.out.println("please enter 1 or 2 or 3.");
				int n = scan.nextInt();
				if (n == 1) {
					System.out.println("1.Inorder traverse");
					graph.showInoder();
					break;
				} else if (n == 2) {
					System.out.println("2.Preoder traverse");
					graph.showPreoder();

					break;
				} else {
					System.out.println("3.Postoder traverse");
					graph.showPostoder();
					break;
				}
			}
			// In cay chieu rong
			case 3: {
				System.out.println("3. Breadth-First Traversal traverse");
				graph.showTreequeue();
				break;
			}
			// Search
			case 4: {
				System.out.println("4.Search by Person ID");
				graph.Search();
				break;
			}
			// Delete
			case 5: {
				System.out.println("5.Delete by Person ID");
				graph.Delete();
				break;

			}
			// balance
			case 6: {
				System.out.println("Balancing Binary Search Tree");
				graph.balance();
				break;
			}
			// DFS
			case 7: {
				System.out.println("7.DFS_Graph");
				graph.DFS();

				break;
			}
			// Dijkstra tim duong di ngan nhat
			case 8:
				System.out.println("8. Dijkstra");
				graph.dijkstra(graph.copy(graph.matrix), graph.matrix[0][0]);

				break;

			}

		} while (check);
	}

	public static void menu() {
		System.out.println("\nPerson Tree:\r\n" + "1. Insert a new Person.\r\n" + "2. Inorder traverse\r\n"
				+ "3. Breadth-First Traversal traverse\r\n" + "4.Search by Person ID\r\n" + "5. Delete by Person ID\r\n"
				+ "6.  Balancing Binary Search Tree\r\n" + "7.DFS_Graph\r\n" + "8. Dijkstra\r\n" + "Exit:\r\n"
				+ "0. Exit\r\n" + " choice=");
	}

}
