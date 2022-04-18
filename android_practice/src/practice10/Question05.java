package practice10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Question05 {

	public static void main(String[] args) {
		Date date = new Date();
		
		System.out.println(date);
		
		LocalDateTime dateTimeNow = LocalDateTime.now();
		
		DateTimeFormatter japaneseFormat = DateTimeFormatter.ofPattern("yyyy_MM_dd");
		
		String dateTime = dateTimeNow.format(japaneseFormat);
		
		System.out.println(dateTime);
	}

}
