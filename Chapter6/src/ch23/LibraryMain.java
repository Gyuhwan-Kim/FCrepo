package ch23;

import java.util.ArrayList;

class FastLibrary {
	public ArrayList<String> shelf = new ArrayList<>();
	
	public FastLibrary() {
		shelf.add("태백산맥 1");
		shelf.add("태백산맥 2");
		shelf.add("태백산맥 3");
//		shelf.add("태백산맥 4");
//		shelf.add("태백산맥 5");
//		shelf.add("태백산맥 6");
	}
	
	public synchronized String lendBook() throws InterruptedException {
		Thread th = Thread.currentThread();
		while(shelf.size() == 0) {
			System.out.println(th.getName() + " is waiting start");
			wait();
			System.out.println(th.getName() + " is waiting end");
		}
		
		if(shelf.size() > 0) {
			String book = shelf.remove(0);
			System.out.println(th.getName() + " : " + book + " lend");
			return book;
		} else return null;
	}
	
	public synchronized void returnBook(String book) {
		Thread th = Thread.currentThread();
		
		shelf.add(book);
		notifyAll();
		System.out.println(th.getName() + " : " + book + " return");
	}
}

class Student extends Thread{
	public Student(String name) {
		super(name);
	}
	
	public void run() {
		try {
			String title = LibraryMain.library.lendBook();
			if(title == null) {
				System.out.println(getName() + " 빌리지 못했음");
				return;
			}
			sleep(5000);
			LibraryMain.library.returnBook(title);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}

public class LibraryMain {
	public static FastLibrary library = new FastLibrary();
	
	public static void main(String[] args) {
		Student std1 = new Student("std1");
		Student std2 = new Student("std2");
		Student std3 = new Student("std3");
		Student std4 = new Student("std4");
		Student std5 = new Student("std5");
		Student std6 = new Student("std6");
		
		std1.start();
		std2.start();
		std3.start();
		std4.start();
		std5.start();
		std6.start();
	}
}
