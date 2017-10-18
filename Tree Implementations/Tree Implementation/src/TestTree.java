
public class TestTree {
	public static Node addChild(Node parent, String id){
		Node node = new Node(parent);
		node.setId(id);
		parent.getChildren().add(node);
		return node;
	}
	
	public static void printTree(Node node, String appender){
		System.out.println(appender + node.getId());
		for(Node each: node.getChildren()){
			printTree(each, appender + appender);
		}
	}
	
	public static void main(String[] args) {
		Node treeRootNode = new Node(null);
		treeRootNode.setId("root");

		// add child to root node 
		Node child = addChild(treeRootNode, "child 1");
		
		// add child to the child node created above
		addChild(child, "child 1.1");
		
		Node child12 = addChild(child, "child 1.2");
		addChild(child12, "child 1.2.1");
		addChild(child12, "child 1.2.2");
		
		// add child to the root node
		Node child2 = addChild(treeRootNode, "child 2");
		//Ad child to the child 2 node created above
		addChild(child2, "child 2.1");
		addChild(child2, "child 2.2");
		
		System.out.println("Root is : " + child12.getRoot().getId());
		
		System.out.println("Tree before deletion");
		printTree(treeRootNode, " ");
		
		System.out.println("---------------------");
		
		System.out.println("Tree after delete Node 12");
		child12.deleteNode();
		printTree(treeRootNode, " ");
		
		
	}
}
