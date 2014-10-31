package datastruct;

public class TrieTree {
	
	TrieTreeNode root;
	
	public TrieTree(){
		root = new TrieTreeNode();
	}
	
	static class TrieTreeNode {
		/** 经过节点的单词数量 */
		int num;
		TrieTreeNode[] child;
		boolean isEnd;
		char value;
		
		public TrieTreeNode(){
			num = 1;
			child = new TrieTreeNode[26];
			isEnd = false;
		}
	}
	
	/**
	 * 查找完全匹配的单词，即一直到叶子节点
	 * @param str
	 * @return
	 */
	boolean search(String str){
		char[] chars = str.toCharArray();
		TrieTreeNode node = root;
		for(int i=0; i<chars.length; i++){
			int pos = chars[i] - 'a';
			if(node.child[pos] != null){
				node = node.child[pos];
			}else{
				return false;
			}
		}
		return node.isEnd;
	}
	
	/**
	 * 插入一个字符串
	 * @param str
	 */
	void insert(String str){
		char[] chars = str.toCharArray();
		TrieTreeNode node = root;
		for(char c : chars){
			int pos = c - 'a';
			if(node.child[pos] != null) {
				node = node.child[pos];
				node.num++;
			}else{
				node.child[pos] = new TrieTreeNode();
				node = node.child[pos];
				node.value = c;
				node.isEnd = false;
				node.num = 1;
			}
		}
		node.isEnd = true;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
