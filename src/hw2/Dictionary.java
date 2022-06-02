package hw2;

import java.util.*;

public class Dictionary extends PairMap {
	private int n = 0; // 아이템 개수
	private int capacity; // 배열 크기
	
	public Dictionary(int n) {
		// 배열 크기 할당
		keyArray = new String[n];
		valueArray = new String[n];
		capacity = n;
	}

	@Override
	String get(String key) {
		for (int i = 0; i < n; i++) {
			if (keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return null;
	}

	@Override
	void put(String key, String value) {
		boolean exists = false; // 전달 받은 key의 존재 여부
		for (int i = 0; i < n; i++) {
			// key가 이미 존재하면 value 값 수정
			if (keyArray[i].equals(key)) {
				valueArray[i] = value;
				exists = true;
				break;
			}
		}
		// key가 존재하지 않으면 값을 새로 추가
		if (!exists) {
			keyArray[n] = key;
			valueArray[n] = value;
			n++; // 아이템 개수 + 1
		}
		
	}

	@Override
	String delete(String key) {
		// 배열의 list를 생성
		List<String> keys = new ArrayList<>(Arrays.asList(keyArray));
		List<String> values = new ArrayList<>(Arrays.asList(valueArray));
		
		String removed; // 삭제한 value
		
		for (int i = 0; i < n; i++) {
			if (keyArray[i].equals(key)) {
				n--; // 아이템 개수 - 1
				removed = valueArray[i]; // 제거할 value
				keys.remove(key); // key 제거
				values.remove(removed); // value 제거
				// list를 배열로 변환
				keyArray = keys.toArray(new String[capacity]);
				valueArray = values.toArray(new String[capacity]);
				return removed; // 제거한 value 반환
			}
		}
		return null; // 일치하는 key 없으면 null
	}

	@Override
	int length() {
		return n;
	}
	
}
