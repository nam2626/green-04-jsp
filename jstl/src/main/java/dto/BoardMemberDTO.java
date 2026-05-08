package dto;

public class BoardMemberDTO {
	private String id;
	private String name;
	private String passwd;
	private String nick;

	public BoardMemberDTO(String id, String name, String passwd, String nick) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.nick = nick;
	}

	public BoardMemberDTO() {	}

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "BoardMemberDTO [id=" + id + ", name=" + name + ", passwd=" + passwd + ", nick=" + nick + "]";
	}
	
	
	
}
