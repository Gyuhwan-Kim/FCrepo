package ch14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		try(FileOutputStream fos = new FileOutputStream("output3.txt")){
			byte[] bs = new byte[26];
			byte data = 65;
			for(int i = 0; i<bs.length; i++) {
				bs[i] = data++;
			}
			fos.write(bs, 2, 10);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
