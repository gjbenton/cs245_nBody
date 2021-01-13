import java.util.*;
import java.lang.*;

public class LinkedList<Object> implements List<Object>{
	private Node<Object> head;
	private int size;

	
	public LinkedList(){
		this.head = null;
		this.size = 0;
	}

	public Object get(int index) throws Exception{
		if(index < 0 && index >= size){
			throw new Exception("Position is invalid.");
		}
		Node<Object> curr = head;
		for (int i = 0; i<index; i++)
			curr = curr.next;
		return curr.data;
	}

	public boolean add(Object elem){
		if(head == null){
			//head = new Node<Object>(elem);
			head = new Node(elem);
			size++;
			return true;
		}

		Node<Object> prev = head;
		//Node<Object> node = new Node<Object>(elem);
		Node<Object> node = new Node(elem);

		for(int i=0; i < size; i++)
			prev = prev.next;
		
		prev.next = node;
		size++;
		return true;
	}

	public void add(int index, Object elem) throws Exception{
		if (index < 0 && index >= size){
            throw new Exception("Position is invalid.");
        }
		if(index == 0){
			Node<Object> node = new Node(elem);
			node.next = head;
			head = node;
			size++;
		}
		else{
			Node<Object> prev = head;
			Node<Object> node = new Node(elem);
			//Node<Object> node = new Node<Object>(elem);

			for(int i=0; i<index-1; i++)
				prev = prev.next;

			node.next = prev.next;
			prev.next = node;
			size++;
		}
	}
	public Object remove(int index) throws Exception{
		if (index < 0 && index >= size){
            throw new Exception("Position is invalid.");
        }
		if (index == 0){
			Node<Object> node = head;
			head = head.next;
			size--;
			return node.data;
		}
		else{
			Node<Object> prev = head;
			Node<Object> node = prev.next;
			
			for(int i=0; i<index -1; i++)
				prev = prev.next;
			prev.next = node.next;
			size--;
			return node.data;
		}
	}
	public int size(){
		return size;
	}

	private class Node<Object>{
		Object data;
		Node<Object> next;

		public Node(Object value){
			this.data = value;
			Node<Object> next = null;
		}
	}
}