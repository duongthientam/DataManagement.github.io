package ASM3;

import java.util.LinkedList;
import java.util.Queue;

public class MyBSTree {
	Node root;

	public boolean isEmpty() {
		return (root == null);
	}

	// Hien thi Inoder
	public void showInoderRec(Node root) {
		if (root != null) {
			showInoderRec(root.left);
			System.out.println(root.p.toString());
			showInoderRec(root.right);
		}
	}

	public void showInoder() {
		if (root == null) {
			System.out.println("IsEmpty");
		} else {
			System.out.format("%-10s%-20s%-20s%-20s", "ID", "Name", "Birthplace", "Bod\n");
			showInoderRec(root);
		}

	}

	// Hien thi Preoder
	public void showPreoderRec(Node root) {
		if (root != null) {
			System.out.println(root.p.toString());
			showPreoderRec(root.left);

			showPreoderRec(root.right);
		}
	}

	public void showpreoder() {
		if (root == null) {
			System.out.println("IsEmpty");
		} else {
			System.out.format("%-10s%-20s%-20s%-20s", "ID", "Name", "Birthplace", "Bod\n");
			showPreoderRec(root);
		}

	}

	// Hien thi Postoder
	public void showPostoderRec(Node root) {
		if (root != null) {
			showPostoderRec(root.left);

			showPostoderRec(root.right);
			System.out.println(root.p.toString());
		}
	}

	public void showPostoder() {
		if (root == null) {
			System.out.println("IsEmpty");
		} else {
			System.out.format("%-10s%-20s%-20s%-20s", "ID", "Name", "Birthplace", "Bod\n");
			showPostoderRec(root);
		}

	}
     
	public Node InsertRec(Node root, Person p) {
		if (root == null) {
			root = new Node(p);
			return root;
		}
		if (p.id.compareToIgnoreCase(root.p.id) > 0) {
			root.right = InsertRec(root.right, p);
		} else if (p.id.compareToIgnoreCase(root.p.id) < 0) {
			root.left = InsertRec(root.left, p);
		}
		return root;

	}
    //Insert
	public void Insert(Person p) {
		Node n = SearchRec(root, p.id);
		if (n == null) {
			root = InsertRec(root, p);
		} else {
			System.out.println("This ID is had");
		}

	}
   
	public Node SearchRec(Node root, String id) {
		if (root == null || root.p.id.compareTo(id) == 0) {
			return root;
		}
		if (id.compareTo(root.p.id) > 0) {
			return SearchRec(root.right, id);
		} else {
			return SearchRec(root.left, id);
		}
	}
	//Search
	public void Search(String id) {
		if (root == null) {
			System.out.println("isEmpty");
		} else {
			Node node = SearchRec(root, id);
			if (node != null) {
				System.out.format("%-10s%-20s%-20s%-20s", "ID", "Name", "Birthplace", "Bod\n");
				System.out.println(node.p.toString());
} else {
				System.out.println("Null");
				}
		}
	}
public Node DeleteRec(Node root, Person x) {
		if (root == null) {
			return root;
		}
		if (x.id.compareToIgnoreCase(root.p.id) > 0) {
			root.right = DeleteRec(root.right, x);
		} else if (x.id.compareToIgnoreCase(root.p.id) < 0) {
			root.left = DeleteRec(root.left, x);
		}
		// Neu chi co 1 child hoac 0 child
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {
			// neu co 2 child
			root.p = MinValue(root.right);
			root.right = DeleteRec(root.right, x);
		}
		return root;
	}
public void Delete(String id) {
		if (root == null) {
			System.out.println("isEmpty");
		} else {
			Node n = SearchRec(root, id);
			if (n != null) {
				System.out.format("%-10s%-20s%-20s%-20s", "ID", "Name", "Birthplace", "Bod\n");
				root = DeleteRec(root, n.p);
				System.out.println(n.p.toString());
			} else {
				System.out.println("Null");
			}
}
	}
//Gia tri nho nhat
public Person MinValue(Node root) {
		Person min = root.p;
		while (root.left != null) {
			min = root.left.p;
			root = root.left;
		}
		return min;
	}

	// Duyet cay theo chieu rong
	public void TreeQueue(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.p.toString());
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
	// Duyet cay theo chieu rong
	public void BFT() {
		if (root == null) {
			System.out.println(" BST empty");
		} else {
			System.out.format("%-10s%-20s%-20s%-20s", "ID", "Name", "Birthplace", "Bod\n");
			TreeQueue(root);
		}
	}

	// copy tree den LinkedList
	LinkedList<Node> list = new LinkedList<>();

	public void copytree(Node node) {
		if (node != null) {
			copytree(node.left);
			list.add(node);
			copytree(node.right);
		}

	}

	// can bang cay
	public void balanceRec(LinkedList<Node> list, int star, int over) {
		if (star <= over) {
			int mid = (star + over) / 2;
			root = InsertRec(root, list.get(mid).p);
			balanceRec(list, star, mid - 1);
			balanceRec(list, mid + 1, over);
		}

	}

	// can bang cay
	public void balance() {
		// copy tat ca cay den list
		copytree(root);
		// Xoa tat ca tree
		root = null;
		// Chen tat ca den tree
		int star = 0;
		int over = list.size() - 1;
		balanceRec(list, star, over);
	}

}
