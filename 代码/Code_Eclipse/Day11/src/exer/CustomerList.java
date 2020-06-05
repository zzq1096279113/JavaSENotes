package exer;

public class CustomerList {
	//声明Customer类型数组customers和记录存储的客户的个数的变量
	private Customer[] customers;
	private int total;
	
	//构造器，用来初始化customers数组
	public CustomerList(int totalnum) {
		customers = new Customer[totalnum];
	}
	
	/**
	 * 添加指定的客户到数组中
	 * @return 添加是否成功
	 */
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}else {
			customers[total] = customer;
			total++;
			return true;
 		}
	}
	
	/**
	 * 替换指定索引位置上的数组元素
	 * @return 是否替换成功
	 */
	public boolean replaceCustomer(int index, Customer cust){
		if(index >= total || index < 0) {
			return false;
		}else {
			customers[index] = cust;
			return true;
		}
	}

	/**
	 * 删除指定索引位置上的元素
	 * @return 是否删除成功
	 */
	public boolean deleteCustomer(int index){
		if(index >= total || index < 0) {
			return false;
		}else {
			for(int i = index; i < total - 2; i++) {
				customers[i] = customers[i + 1];
			}
			customers[total - 1] = null;
			total--;
			return true;
		}
	}
	
	/**
	 * 获取所有的customers对象构成的数组
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i = 0; i < custs.length; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	/**
	 * 返回指定索引位置上的Customer
	 * @return 如果输入的index位置上的元素不存在，返回null
	 */
	public Customer getCustomer(int index) {
		if(index >= total || index < 0) {
			return null;
		}else {
			return customers[index];
		}
	}

	/**
	 * 返回Customer对象的个数
	 */
	public int getTotal(){
		return total;
	}

}
