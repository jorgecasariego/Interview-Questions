import java.util.ArrayList;
import java.util.List;

public class Node {
	private String id;
	private final List<Node> children = new ArrayList<>();
	private Node parent;
	
	public Node(Node parent){
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Node> getChildren() {
		return children;
	}
	
	public void setParent(Node parent){
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}
	
	/*
	 * Every node first checks if it is a root by itself. And it can be root only 
	 * when it has no parent. If it is not a root, it calls the function to the parent 
	 * and it bubbles up right to the root. And once a root is found the resulting node
	 * is passed back and the node asking for it gets the reference of the root node. 
	 */
	public Node getRoot(){
		if(parent == null){
			return this;
		}
		return parent.getRoot();
	}
	
	/**
	 * Here are the steps we will follow:
 		1. Delete the current node from the list of children of current parent
 		2. Assign the children of this node to the parent of this node. So if we have to delete 
 		   “Node 12” then we will make “Node 121” and “Node 122” as the children of “Node 1”
		3. The parent reference of the children will also be updated to the parent of this node
		4. The children are added at the same index as the deleted node
	 */
	public void deleteNode(){
		if(parent != null){
			// a. first we get the index of the current node
			int index = parent.getChildren().indexOf(this);
			
			// b. Removes the first occurrence of the specified element from this list, if it is present
			this.parent.getChildren().remove(this);
			
			// c. Assign the children of this node to the parent of this node
			for(Node child: this.getChildren()){
				child.setParent(parent);
			}
			
			// d. Now, our parent will have more children
			// 	- Inserts all of the elements in the specified collection into this
			//    list at the specified position Shifts the element currently at that 
			//	  position (if any) and any subsequent elements to the right (increases their indices)
			this.parent.getChildren().addAll(index, getChildren());
		}
		this.getChildren().clear();
	}
	
	public Node deleteRootNode(){
		if(parent != null){
			throw new IllegalStateException("Delete root node can be only called on the root node of tree");
		}
		
		Node newParent = null;
		if(!getChildren().isEmpty()){
			newParent = getChildren().get(0);
			newParent.setParent(null);
			getChildren().remove(0);
			for(Node child: getChildren()){
				child.setParent(newParent);
			}
			newParent.getChildren().addAll(getChildren());
		}
		
		this.getChildren().clear();
		
		return newParent;
	}
		

}
