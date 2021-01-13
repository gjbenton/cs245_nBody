//import java.util.*;
//import java.lang.*;

public class ArrayList<T> implements List<T>{
	private int currentSize;
	private T[] arr;

	public ArrayList(){
		arr = (T[]) new Object[10];
		currentSize = 0;
	}

	public T get(int index){
		Assert.notFalse(index >= 0 && index < currentSize, "Index not in list");
		return arr[index];
	}

	public boolean add(T elem){
		if(currentSize == arr.length){
			Grow_Array();
		}
		arr[currentSize++] = elem;
		return true;

	}
	public void add(int index, T elem){
		for(int i = currentSize; i> index; i--){
			arr[i] = arr[i-1];
		}
		arr[index] = elem;
		currentSize++;

	}
	public T remove(int index){

		Assert.notFalse(index>= 0 && index < currentSize, "Index not in list");

		T item = arr[index];
		for(int i = index + 1; i < currentSize; i++){
			arr[i-1]=arr[i];
		}
		currentSize--;
		return item;

	}
	public int size(){
		return currentSize;
	}

	private void Grow_Array(){
		T[] newArray;

		newArray = (T[]) new Object[currentSize *2];
		for(int i = 0; i< currentSize; i++)
			newArray[i]= arr[i];
		arr = newArray;
		currentSize = currentSize*2;
	}

	public String toString(){
		String output = "[";
		for (int i=0; i < currentSize; i++){
			if(i!=currentSize-1)
				output+= arr[i] + ", ";
			else
				output+= arr[i];
		}
		output += "]";
		return output;
	}
}