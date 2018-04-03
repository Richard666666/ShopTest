package com.vo;

import java.util.ArrayList;

//一次性钥匙
public class KeyOption {

	private ArrayList<String> keyList = new ArrayList<>();
	
	public KeyOption() {
		super();
	}

	public KeyOption(ArrayList<String> keyList) {
		super();
		this.keyList = keyList;
	}

	public ArrayList<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(ArrayList<String> keyList) {
		this.keyList = keyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyList == null) ? 0 : keyList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyOption other = (KeyOption) obj;
		if (keyList == null) {
			if (other.keyList != null)
				return false;
		} else if (!keyList.equals(other.keyList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KeyOption [keyList=" + keyList + "]";
	}
}
