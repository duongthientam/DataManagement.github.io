package ASM3;

public class Person {
	String id,name,birthplace,bod;

	public Person(String id, String name, String birthplace, String bod) {
		super();
		this.id = id;
		this.name = name;
		this.birthplace = birthplace;//Dia chi
		this.bod = bod;//Birth of Date
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

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getBod() {
		return bod;
	}

	public void setBod(String bod) {
		this.bod = bod;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format("%-10s%-20s%-20s%-20s",this.id,this.name,this.birthplace,this.bod);
	}

}
