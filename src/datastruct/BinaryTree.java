package datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	/**
	 * 前序遍历/中序遍历/后续遍历
	 * @param root
	 */
	public void search(TreeNode root){
		if(root == null) return;
		System.out.println(root.value);
		search(root.left);
		search(root.right);
	}
	
	public void BSFSearch(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			System.out.println(node.value);
			if(node.left != null)
				q.offer(node.left);
			if(node.right != null)
				q.offer(node.right);
		}
	}
	
	/**
	 * LCA 最低公共祖先节点
	 * 普通二叉树
	 */
	public TreeNode LCA_Common(TreeNode root,TreeNode n1,TreeNode n2){
		LinkedList<TreeNode> path1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> path2 = new LinkedList<TreeNode>();
		
		searchNode(root,n1,path1);
		searchNode(root,n2,path2);
		
		TreeNode node = null;
		while(path1.iterator().hasNext() && path2.iterator().hasNext()){
			TreeNode pn1 = path1.iterator().next();
			
			if(pn1 == path2.iterator().next()){
				node = pn1;
			}else{
				break;
			}
		}
		return node;
		
	}
	
	
	private boolean searchNode(TreeNode root,TreeNode n,Queue path){
		if(root == null) return false;
		path.offer(root);
		if(root == n){
			return true;
		}else{
			boolean fund = searchNode(root.left,n,path);
			if(!fund) 
				fund = searchNode(root.right,n,path);
			if(!fund){
				path.poll();
			}
			return fund;
		}
		
	}
	
	
	/**
	 * LCA 二叉搜索树
	 */
	public TreeNode LCA_BinarySearchTree(TreeNode root,TreeNode n1,TreeNode n2){
		if(root.value > n1.value && root.value > n2.value)
			return LCA_BinarySearchTree(root.left,n1,n2);
		else if(root.value < n1.value && root.value < n2.value)
			return LCA_BinarySearchTree(root.right,n1,n2);
		else{
			return root;
		}
	}
	
	public static void BFS(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(root != null){
			q.offer(root);
			int h = 0;
			while(!q.isEmpty()){
				TreeNode node = q.poll();
				// deal with it
				System.out.print(node.value+", ");
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
		}
	}
	
	public static void rootFirstSearch(TreeNode root){
		if(root != null){
			System.out.print(root.value+", ");
			rootFirstSearch(root.left);
			rootFirstSearch(root.right);
		}
	}
	
	public static void rootMidSearch(TreeNode root){
		if(root != null){
			
			rootFirstSearch(root.left);
			System.out.print(root.value+", ");
			rootFirstSearch(root.right);
		}
	}
	
	public static void rootFirstSearchNoRecursive(TreeNode root){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = Util.RandomBinaryTree(5);
		BFS(root);
		System.out.println();
		rootFirstSearch(root);
		System.out.println();
		rootMidSearch(root);
	}

}
