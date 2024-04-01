package com.callor.iolist.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IoVO {
	private int	seq;	
	private String	io_date; //VARCHAR(10) NOT NULL,
	private String	io_time; //VARCHAR(10) NOT NULL,
	private String	io_pname;// VARCHAR(30) NOT NULL,
	private String	io_input; //VARCHAR(3) NOT NULL,
	private int	io_price; //INT NOT NULL,
	private int	io_quan ; //INT NOT NULL,
	private int	io_total ; // INT 

}
