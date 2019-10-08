package com.sky.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main implements I1,I2{

	public static void printDate(String s){
		Map<String,String> k = new HashMap<>();
		k.put(null, null);
		System.out.println(k.get(null));
	}

	final static String name = "Amit";
	public static void main(String[] args) {
		printDate("");
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"Sandeep",22));
		persons.add(new Person(2,"Aditya",24));
		persons.add(new Person(3,"Sandeep",29));
		persons.add(new Person(4,"Dodo",30));
		persons.add(new Person(5,"Sandeep",22));
		persons.add(null);
		
		System.out.println(persons);
		//persons.replaceAll(p->p.getName().equals("Sandeep")?new Person(p.getId(),name,p.getAge()):p);
		//System.out.println(persons);
		
		persons.replaceAll(p->(p!=null&&p.getName().equals("Sandeep"))?new Person(p.getId(),name,p.getAge()):p);
		System.out.println(persons);
		
		//System.out.println(persons.get(5));
		
		//Map<Integer, Person> m = persons.stream().collect(Collectors.toMap(p->p.getId(),p->p));
		//System.out.println(m);
		
		//Map<Integer, Person> m = persons.stream().filter(p->(p!=null)).collect(Collectors.toMap(p->p.getId(),p->p));
		//System.out.println(m);
		
		// TODO Auto-generated method stub
		List<String> listItem = new ArrayList<>();
		listItem.add("Sandeep");
		listItem.add("Aditya");
		listItem.add("Sandeep");
		listItem.add("Dodo");
		listItem.add("Sandeep");
		//System.out.println(listItem);
		//UnaryOperator<String> u = t->t.equals("Sandeep")?"Aditya":t;
		//listItem.replaceAll(t->t.equals("Sandeep")?"Aditya":t);
		//System.out.println(listItem);
		//System.out.println(listItem.stream().filter(l->l.equals("Sandeep")).collect(Collectors.toList()));
		Predicate<String> p = t->t.equals("Sandeep");
		//System.out.println(listItem.stream().filter(p).collect(Collectors.toList()));
		
		/*Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstm = null;
		try {
			Class.forName("");
			conn = DriverManager.getConnection("", "", "");
			for(){
				stmt = conn.createStatement();
				stmt.executeUpdate("");
				pstm = conn.prepareStatement("");
				pstm.execute();
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(stmt!=null)
					stmt.close();
				if(pstm != null)
					pstm.close();
				if(conn!=null)
					conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}*/
		
		
		
		

	}

	@Override
	public void showA() {
		
		I1.super.showA();
	}

	
	

}

interface I1{
	default void showA(){
		System.out.println("I1");
	}
}
interface I2{
	default void showA(){
		System.out.println("I2");
	}
}
class Person{
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}