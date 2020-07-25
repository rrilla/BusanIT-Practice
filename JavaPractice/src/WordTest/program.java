package WordTest;

import java.util.Scanner;
import java.util.Vector;

import WordTest.Word;

public class program {
	private Scanner sc=new Scanner(System.in);
	private Vector<Word> v;
	
	public program() {
		v = new Vector<Word>();
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "애인"));
		v.add(new Word("dall", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}
	
	public void quiz() {
		System.out.println("영어단어의 테스트를 시작합니다.\n현재"+v.size()+"개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
		while(true) {
//			System.out.println("현재 "+v.size()+"개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
			int answer;
			int[] a = new int[4];
			for(int i=0; i<a.length;i++) {
				a[i]=(int)(Math.random()*v.size());
					for(int y=0; y<i; y++) {
						if(a[i]==a[y])
							i--;
					}
			}
			answer=(int)(Math.random()*a.length);
			Word w = v.get(a[answer]);
			Word w0 = v.get(a[0]);
			Word w1 = v.get(a[1]);
			Word w2 = v.get(a[2]);
			Word w3 = v.get(a[3]);
			System.out.print(w.getEng()+"?\n(1)"+w0.getKor()+" (2)"+w1.getKor()+" (3)"+w2.getKor()+" (4)"+w3.getKor()+"\n>>");
			int insnum=sc.nextInt();
			if(insnum==-1) {
				break;
			}else if(insnum==answer+1)
				System.out.println("Excellent !!");
			else if(0<insnum && insnum<5)
				System.out.println("No !!");
			else 
				System.out.println("잘못입력했다.다시");
		}
	}
	
	public void insert() {
		System.out.println("영어단어를 추가합니다.\n'그만'을 입력하면 종료합니다");
		while(true) {
			System.out.print("영어 한글 순으로 입력>>>>");
			String str1=sc.next();
			if(str1.equals("그만"))
				break;
			String str2=sc.next();
			v.add(new Word(str1,str2));
		}
	}
	public static void main(String[] args) {
		program test = new program();
		Scanner sc2=new Scanner(System.in);
		
		System.out.println(" ************ 영어 단어 테스트 프로그램 ************");
		while(true) {
			System.out.print("1:단어 퀴즈, 2:단어 삽입, 3:종료\n>>>>");
			int num=sc2.nextInt();
			if(num==3) 
				break;
			switch(num) {
			case 1 : test.quiz();break;
			case 2 : test.insert();break;
			default : System.out.println("그거아님. 다시입력");break;
			}
		}
		System.out.println("영어단어 게임 종료합니다.");
	}
}
