package Tree_linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String nodeId;
	private String nodeName;
	private String parentNodeId;
	private Node parent;
	List<Node> children = new ArrayList<Node>();
	List<Node> allChildren = new ArrayList<Node>();
;	
	public Node(Node node) {
		this.nodeId = node.getNodeId();
		this.nodeName = node.getNodeName();
		this.parentNodeId = node.getParentNodeId();	
	}
	
	public Node(String nodeId, String nodeName, String parentNodeId) {
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.parentNodeId = parentNodeId;
	}
	
	public void addChild(Node node) {
		this.children.add(node);
	}

	public void removeChild(Node node) {
		this.children.remove(node);
	}
	
	public List<Node> getAllChildren(){
		if(this.allChildren.isEmpty()) {
			for (Node node : this.children) {
				this.allChildren.add(node);
				this.allChildren.addAll(node.getAllChildren());
			}
		}
		return this.allChildren;
	}
	
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(String parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
}
