package lolSearch;

public class WinRatio {
	private int no;
	private String name;
	private String line;
	private String winRatio;
	private String pickRatio;
	private String banRatio;
	
	public WinRatio() {}

	public WinRatio(int no, String name, String line, String winRatio, String pickRatio) {
		super();
		this.no = no;
		this.name = name;
		this.line = line;
		this.winRatio = winRatio;
		this.pickRatio = pickRatio;
	}

	
	public WinRatio(int no, String name, String line, String winRatio, String pickRatio, String banRatio) {
		super();
		this.no = no;
		this.name = name;
		this.line = line;
		this.winRatio = winRatio;
		this.pickRatio = pickRatio;
		this.banRatio = banRatio;
	}

	public String getBanRatio() {
		return banRatio;
	}

	public void setBanRatio(String banRatio) {
		this.banRatio = banRatio;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getWinRatio() {
		return winRatio;
	}

	public void setWinRatio(String winRatio) {
		this.winRatio = winRatio;
	}

	public String getPickRatio() {
		return pickRatio;
	}

	public void setPickRatio(String pickRatio) {
		this.pickRatio = pickRatio;
	}

	@Override
	public String toString() {
		return "|| no : " + no + " || 챔프이름 : " + name + " || 포지션 : " + line + " || 승률 : " + winRatio + " || 픽률 : "
				+ pickRatio + " || 밴률 : " + banRatio;
	}
	
}
