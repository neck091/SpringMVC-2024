package com.callor.hello.exec;

public class ExecB {
	/*
	 * throws...
	 * add() method 에서 exception 이 발생하면 원래는 try 를 사용하여 처리해야하는데
	 * 직접 여기서 처리하지 않고 add method를 호출한 곳으로 되돌려 보내겠다.
	 */
	public int add(String  num1, String num2) throws Exception {
		int sum= Integer.valueOf(num1) + Integer.valueOf(num2);
		return sum;
	}
}
