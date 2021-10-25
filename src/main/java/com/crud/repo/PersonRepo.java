package com.crud.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.crud.model.Person;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepo {

	private List<Person> list = new ArrayList<Person>();

//	public void getAll() {
//		System.out.println("Rest Api of the program is");
////		Person p1=new Person(1, "Trinh Minh Cuong", "Developer", true, "1975-11-27");
////		Person p2=new Person(2, "Mary Jane", "Banker", false, "1980-05-24");
////		Person p3=new Person(3, "Tom Sawyer", "Taxi Driver", true, "1990-08-09");
//		List<Person> list = new ArrayList<Person>();
//		list.add(new Person(1, "Trinh Minh Cuong", "Developer", true, "1975-11-27"));
//		list.add(new Person(2, "Mary Jane", "Banker", false, "1980-05-24"));
//		list.add(new Person(3, "Tom Sawyer", "Taxi Driver", true, "1990-08-09"));
//		for(Person person:list) {
//			///list.add(person);
//			System.out.println("person  is"+person);
//			System.out.println("list is"+list);
//		}

//		list.add(p1);
//		list.add(p2);
//		list.add(p3);
//		System.out.println("list the item is"+list);

//		List<Person> list = List.of(new Person(1, "Trinh Minh Cuong", "Developer", true, "1975-11-27"),
//				new Person(2, "Mary Jane", "Banker", false, "1980-05-24"),
//				new Person(3, "Tom Sawyer", "Taxi Driver", true, "1990-08-09"));
//		for (Person person : list) {
//			list.add(person);
//		}

	// }

	public void getAll() {
		List<Person> list = List.of(new Person(1, "Chaturanand", "Yadav", "chaturre@gmail.com", "9805934133"),
				new Person(2, "Ranjit", "Yadav", "ranjit@gmail.com", "9804742012"),
				new Person(3, "Rahul", "Yadav", "rahul@gmail.com", "9815317052"));
		for (Person person : list) {
			list.add(person);
		}

	}

	public List<Person> listPerson() {
		return list;
	}

	public List<Person> search(String name) {
		return list.stream().filter(x -> x.getFirstName().startsWith(name)).collect(Collectors.toList());
	}

	public String add(Person p) {
		Person obj = new Person();
		obj.setId(p.getId());
		obj.setFirstName(p.getFirstName());
		obj.setLastName(p.getLastName());
		obj.setEmail(p.getEmail());
		obj.setPhoneNumber(p.getPhoneNumber());
		list.add(obj);
		return null;
	}

	public String delete(Integer id) {
		list.removeIf(x -> x.getId() == (id));
		return null;
	}

	public String edit(Person person) {
		int idx = 0;
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == (person.getId())) {
				id = person.getId();
				idx = i;
				break;
			}
		}

		Person p = new Person();
		p.setId(id);
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		p.setEmail(person.getEmail());
		p.setPhoneNumber(person.getPhoneNumber());
		list.set(idx, p);

		return null;
	}
}
