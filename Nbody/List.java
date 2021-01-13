public interface List<Object>{
	public Object get(int index) throws Exception;
	public boolean add(Object elem);
	public void add(int index, Object elem) throws Exception;
	public Object remove(int index) throws Exception;
	public int size();
}