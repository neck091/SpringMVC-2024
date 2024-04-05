package com.callor.iolist.exec;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateEx2 {
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		String strDate = localDateTime.format(dayFormat);
		String strTime = localDateTime.format(timeFormat);
		
		System.out.print(strDate);
		System.out.print(strTime);
		System.out.print(localDateTime.minusYears(1));
		
	}

}
