package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private Long orderNo;
	private Long bookNo;
	private int amount;

	private String bookTitle;

	public OrderBookVo() {
	}

	public OrderBookVo(Long orderNo, Long bookNo, int amount) {
		super();
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.amount = amount;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "OrderBookVo [orderNo=" + orderNo + ", bookNo=" + bookNo + ", amount=" + amount + ", bookTitle="
				+ bookTitle + "]";
	}

}
