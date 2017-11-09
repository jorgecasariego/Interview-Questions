import java.util.HashMap;

public class Solution {
	static class TrieNode {
        HashMap<Character, TrieNode> childrens;
        int size;
        
        public TrieNode() {
            childrens = new HashMap<>();
            size = 0;
        }
        
        public void add(TrieNode root, String word) {
            TrieNode node = root;
            
            for(int i = 0; i < word.length(); i++){                
                if(!node.childrens.containsKey(word.charAt(i))){
                    TrieNode next = new TrieNode();
                    node.childrens.put(word.charAt(i), next);
                } 
                
                node = node.childrens.get(word.charAt(i));
                node.size++;
                
            }
        }
        
        public int find(TrieNode root, String prefix) {
            TrieNode node = root;
            
            for(int i = 0; i < prefix.length(); i++) {
                if(node.childrens.containsKey(prefix.charAt(i))){
                   node = node.childrens.get(prefix.charAt(i));
                } else {
                    return 0;
                }
                
            }
            
            return node.size;
        }
    }
	
	
	
	/*
	 * add hack
	 * add hackerrank
	 * find hac
	 * find hak
	 */
	public static void main(String[] args) {
		TrieNode node = new TrieNode();
		node.add(node, "hack");
        node.add(node, "hacker");
        
        System.out.println(node.find(node, "hac"));
        
        /*
			add s
			add ss
			add sss
			add ssss
			add sssss
			find s
			find ss
			find sss
			find ssss
			find sssss
			find ssssss
         */
        node.add(node, "s");
        node.add(node, "ss");
        node.add(node, "sss");
        node.add(node, "ssss");
        node.add(node, "sssss");
        
        System.out.println("");
        System.out.println(node.find(node, "s"));
        System.out.println(node.find(node, "ss"));
        System.out.println(node.find(node, "sss"));
        System.out.println(node.find(node, "ssss"));
        System.out.println(node.find(node, "sssss"));
        System.out.println(node.find(node, "ssssss"));
        
        System.out.println("");
        node.add(node, "abc");
        node.add(node, "bcd");
        node.add(node, "def");
        node.add(node, "def");
        node.add(node, "a");
        node.add(node, "aba");
        
        System.out.println(node.find(node, "a"));
        
       
	}

}
