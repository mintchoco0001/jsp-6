package car;

import java.util.Date;

public class carDTO {

	private String 제조회사;
	private String 자동차이름;
	private String 색상;
	private int 가격;
	private Date 출고날짜;
	private String 상세사양;
	private String carURL;

	
	public String getCarURL() {
		return carURL;
	}
	public void setCarURL(String carURL) {
		this.carURL = carURL;
	}
	public String get제조회사() {
		return 제조회사;
	}
	public void set제조회사(String 제조회사) {
		this.제조회사 = 제조회사;
	}
	public String get자동차이름() {
		return 자동차이름;
	}
	public void set자동차이름(String 자동차이름) {
		this.자동차이름 = 자동차이름;
	}
	public String get색상() {
		return 색상;
	}
	public void set색상(String 색상) {
		this.색상 = 색상;
	}
	public int get가격() {
		return 가격;
	}
	public void set가격(int 가격) {
		this.가격 = 가격;
	}
	public Date get출고날짜() {
		return 출고날짜;
	}
	public void set출고날짜(Date 출고날짜) {
		this.출고날짜 = 출고날짜;
	}
	public String get상세사양() {
		return 상세사양;
	}
	public void set상세사양(String 상세사양) {
		this.상세사양 = 상세사양;
	}
	
	
}
