package com.shinhan.week2.day07.lab2;

class OtherClass {
	void method1();{
		Chatting.Chat cc = new Chatting().new Chat();
	}
}

public class Chatting {
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}

	
	
	void method1();{
		Chat cc = new Chat();
	}
	
	void startChat(String chatId) {
		String nickName = null;
//		nickName = chatId; //익명구현class 때문에 final 적용
		
		//익명구현class, local inner class는 지역변수를 참조하는 경우 무조건 지역변수는 final이다.
		Chat chat = new Chat() {
			
			public void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		
		chat.start();
	}
}