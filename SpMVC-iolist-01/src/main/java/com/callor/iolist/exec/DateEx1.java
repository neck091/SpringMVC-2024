package com.callor.iolist.exec;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx1 {
	public static void main(String[] args) {
		//import java.util.Date;
		Date date = new Date();
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dayFormat.format(date);
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String strTime = dayFormat.format(date);
		System.out.print(strDate);
		System.out.print(strTime);
	}

}
