package com.mm.employee.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.inject.Singleton;

import com.google.gwt.dev.util.collect.HashMap;



@Singleton
public class EmployeeDB {

	public List<Employee> person = new ArrayList<Employee>();
	
 

public void addEmployee(Employee emp)
	{
		person.add(emp);
	}
	// Adding employee data
	public Employee addEmpData(int id, int age, String name, String address) {

		// calling employee class constructor
		Employee emp = new Employee(id, age, name, address);
		// adding the emp details into the list
		person.add(emp);

		return emp;

	}
	public Employee searchEmpDataById(int id) {

		Iterator<Employee> it = person.iterator();
		while (it.hasNext()) {
			Employee employee = it.next();
			if (id == employee.getEmp_id()) {
				return employee;
			}
		}
		return null;
	}

	public int  getEmployeeCount() {

		return  person.size();
	}
	public boolean deleteEmpByID(int id) {

		ListIterator<Employee> it = person.listIterator();
		while (it.hasNext()) {
			// Store the emp details in del_emp object
			Employee del_emp1 = it.next();
			//Check the provided name to be deleted is matching with the list
			// emp or not
			 
			if (id == (del_emp1.getEmp_id())) {
				{
					person.remove(del_emp1);
					break;
					// remove the emp based on the name
				}
			}
		}

		return false;
	}

	/*Adding employee data
		public Employee addManager(int id, int mgid, String nm, String address) {

			// calling employee class constructor
			Manager emp = new Manager(id, mgid, nm, address);
			// adding the emp details into the list
			person.add(emp);

			return emp;

		}
	// function to return the no of Employee list entry
	public int getEmployeeCount() {

		return person.size();
	}

	public boolean searchEmpDataByName(String name) {
		Iterator<Employee> it = person.iterator();
		while (it.hasNext()) {
			if (name.equals(it.next().getName())) {
				return true;
			}
		}
		return false;
	}

	public Employee searchEmpDataById(int id) {

		Iterator<Employee> it = person.iterator();
		while (it.hasNext()) {
			Employee employee = it.next();
			if (id == employee.getID()) {
				return employee;
			}
		}
		return null;
	}

	public boolean searchEmpData(Employee emp1) {
		if (person.contains(emp1)) {
			return true;
		}
		return false;

	}

	public boolean deleteEmpByName(String name) {

		Iterator<Employee> it = person.iterator();
		while (it.hasNext()) {
			// Store the emp details in del_emp object
			Employee del_emp = it.next();
			Check the provided name to be deleted is matching with the list
			 * emp or not
			 
			if (name.equals(del_emp.getName())) {
				{
					it.remove(); // remove the emp based on the name
				}
			}
		}

		return false;

	}

	public boolean deleteEmpByID(int id) {

		Iterator<Employee> it = person.iterator();
		while (it.hasNext()) {
			// Store the emp details in del_emp object
			Employee del_emp1 = it.next();
			Check the provided name to be deleted is matching with the list
			 * emp or not
			 
			if (id == (del_emp1.getID())) {
				{
					it.remove(); // remove the emp based on the name
				}
			}
		}

		return false;

	}*/
public List<Employee> getAllEmployees() {
	// TODO Auto-generated method stub
	return person;
}

}
