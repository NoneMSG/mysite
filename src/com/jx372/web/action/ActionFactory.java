package com.jx372.web.action;
//각액션들을 액션의 기능에 맞도록 구체화 시키기 위한 추상클래스와 추상메서드
public abstract class ActionFactory {
	public abstract Action getAction(String actionName);
}
