package com.spring.vo;

//page, numPerPage값을 사용하기 위해 PageCriteria객체를 상속한다.
public class FindCriteria extends PageCriteria{
	private String findType;
	private String keyWord;
	
	public String getFindType() {
		return findType;
	}
	public void setFindType(String findType) {
		this.findType = findType;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public String toString(){
		return super.toString() + " FindCriteria" + "[findType=" + findType + ", keyword=" + keyWord + "]";
	}
}
