package test;

import java.util.ArrayList;
import java.util.List;

public class Parent {
	private String id;
	private String name;

	private List<Child> childs = new ArrayList<Child>();

	public Parent() {
	}

	public Parent(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + "]";
	}

}
