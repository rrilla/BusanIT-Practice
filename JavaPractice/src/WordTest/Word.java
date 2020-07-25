package WordTest;

public class Word {
	private String kor;
	private String eng;
	
	public Word(String eng,String kor) {
		this.kor=kor;
		this.eng=eng;
	}

	public String getKor() {
		return kor;
	}

	public String getEng() {
		return eng;
	}
}
