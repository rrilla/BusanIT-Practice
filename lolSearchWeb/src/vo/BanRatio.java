package vo;

public class BanRatio {
	private String name;
	private String banRatio;
	
	public BanRatio() {}

	public BanRatio(String name, String banRatio) {
		super();
		this.name = name;
		this.banRatio = banRatio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBanRatio() {
		return banRatio;
	}

	public void setBanRatio(String banRatio) {
		this.banRatio = banRatio;
	}

	@Override
	public String toString() {
		return "banRatio [name=" + name + ", banRatio=" + banRatio + "]";
	}
	
}
