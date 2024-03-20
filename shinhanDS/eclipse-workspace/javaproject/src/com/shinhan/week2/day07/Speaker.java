package com.shinhan.week2.day07;

public class Speaker extends Volume {
	int volLevel;

	@Override
	public void volumeUp(int vol) {
		volLevel += vol;
		if(volLevel>100) volLevel=100;
		System.out.println(getClass().getSimpleName()+"볼륨 올립니다. "+volLevel);
		
	}

	@Override
	public void volumeDown(int vol) {
		volLevel -= vol;
		if(volLevel<0) volLevel=0;
		
		System.out.println(getClass().getSimpleName()+"볼륨 내립니다. "+volLevel);
	}
	
	
}
