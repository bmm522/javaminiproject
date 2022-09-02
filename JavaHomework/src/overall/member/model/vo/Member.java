package overall.member.model.vo;

public class Member {
	
	private String id;
	private String pwd;
	private String name;
	private boolean isManager;
	
	public Member() {}

	public Member(String id, String pwd, String name, boolean isManager) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.isManager = isManager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return id +" "+ pwd + " " + name +" "+ isManager+"\n";
	}
	
	
}
