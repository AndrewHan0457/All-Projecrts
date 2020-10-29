package Tree_linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Tree_linkedlist {
	
	private HashMap<String, Node> treeNodesMap = new HashMap<String, Node>();
	private List<Node> treeNodesList = new ArrayList<Node>();
	
	public Tree_linkedlist(List<Node> list) {
		initNodesMap(list);
		initNodesList();
	}
	
	private void initNodesMap(List<Node> list) {
		Node node = null;
		for (Node item : list) {
			node = new Node(item);
			treeNodesMap.put(item.getNodeId(), node);
		}
		
		Iterator<Node> iterator = treeNodesMap.values().iterator();
		Node parentNode = null;
		
		while(iterator.hasNext()) {
			node = iterator.next();
			if(node.getParentNodeId() == null || node.getParentNodeId() == "") {
				continue;
				
			}
			
			parentNode = treeNodesMap.get(node.getParentNodeId());
			if(parentNode != null) {
				node.setParent(parentNode);
				parentNode.addChild(node);
			}
						
		}
		
	}
	
	private void initNodesList() {
		if (treeNodesList.size() > 0) {
			return;
		}
		
		if(treeNodesMap.size() == 0) {
			return;
		}
		
		Iterator<Node> iterator = treeNodesMap.values().iterator();
		Node node = null;
		while(iterator.hasNext()) {
			node = iterator.next();
			if(node.getParent() == null) {
				this.treeNodesList.add(node);
				this.treeNodesList.addAll(node.getAllChildren());
			}
		}
		
	}
}
