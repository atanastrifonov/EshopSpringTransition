package dto;

public class CategoryData {
	
	private short id;
	private String name;
	
	public CategoryData(){
		
	}
	
	public CategoryData(short id, String name){
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}		
}
