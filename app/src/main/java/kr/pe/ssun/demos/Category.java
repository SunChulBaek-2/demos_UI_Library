package kr.pe.ssun.demos;

/**
 * Created by x1210x on 15. 5. 25..
 */
public enum Category {
	MATERIAL("Material"),
	IMAGE("Image");

	private String title;

	Category(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
}
