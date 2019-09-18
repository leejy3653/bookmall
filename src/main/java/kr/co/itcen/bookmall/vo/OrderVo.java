package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private Long userNo;
	private int price;
	private String address;

	private String userName;
	private String userEmail;

	public OrderVo() {
	}

	public OrderVo(Long userNo, int price, String address) {
		super();
		this.userNo = userNo;
		this.price = price;
		this.address = address;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", userNo=" + userNo + ", price=" + price + ", address=" + address + ", userName="
				+ userName + ", userEmail=" + userEmail + "]";
	}

}
