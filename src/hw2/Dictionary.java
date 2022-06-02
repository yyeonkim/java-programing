package hw2;

import java.util.*;

public class Dictionary extends PairMap {
	private int n = 0; // ������ ����
	private int capacity; // �迭 ũ��
	
	public Dictionary(int n) {
		// �迭 ũ�� �Ҵ�
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
		boolean exists = false; // ���� ���� key�� ���� ����
		for (int i = 0; i < n; i++) {
			// key�� �̹� �����ϸ� value �� ����
			if (keyArray[i].equals(key)) {
				valueArray[i] = value;
				exists = true;
				break;
			}
		}
		// key�� �������� ������ ���� ���� �߰�
		if (!exists) {
			keyArray[n] = key;
			valueArray[n] = value;
			n++; // ������ ���� + 1
		}
		
	}

	@Override
	String delete(String key) {
		// �迭�� list�� ����
		List<String> keys = new ArrayList<>(Arrays.asList(keyArray));
		List<String> values = new ArrayList<>(Arrays.asList(valueArray));
		
		String removed; // ������ value
		
		for (int i = 0; i < n; i++) {
			if (keyArray[i].equals(key)) {
				n--; // ������ ���� - 1
				removed = valueArray[i]; // ������ value
				keys.remove(key); // key ����
				values.remove(removed); // value ����
				// list�� �迭�� ��ȯ
				keyArray = keys.toArray(new String[capacity]);
				valueArray = values.toArray(new String[capacity]);
				return removed; // ������ value ��ȯ
			}
		}
		return null; // ��ġ�ϴ� key ������ null
	}

	@Override
	int length() {
		return n;
	}
	
}
