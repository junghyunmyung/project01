package testBoard.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CheckDTO {
	
	private int booking_code;
	private String name;  //호텔명
	private String room_name; 
	private String hotel_detail_address;
	private String  room_member;
	
	private String room_price;
	private int days;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	private String filepath;
	private String filename;
	
	public CheckDTO() {
	}

	public CheckDTO(int booking_code, String name, String room_name, String hotel_detail_address, String room_member,
			String room_price, int days, Date checkin, Date checkout, Date regdate, String filepath, String filename) {
		this.booking_code = booking_code;
		this.name = name;
		this.room_name = room_name;
		this.hotel_detail_address = hotel_detail_address;
		this.room_member = room_member;
		this.room_price = room_price;
		this.days = days;
		this.checkin = checkin;
		this.checkout = checkout;
		this.regdate = regdate;
		this.filepath = filepath;
		this.filename = filename;
	}

	public int getBooking_code() {
		return booking_code;
	}

	public void setBooking_code(int booking_code) {
		this.booking_code = booking_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getHotel_detail_address() {
		return hotel_detail_address;
	}

	public void setHotel_detail_address(String hotel_detail_address) {
		this.hotel_detail_address = hotel_detail_address;
	}

	public String getRoom_member() {
		return room_member;
	}

	public void setRoom_member(String room_member) {
		this.room_member = room_member;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "CheckDTO [booking_code=" + booking_code + ", name=" + name + ", room_name=" + room_name
				+ ", hotel_detail_address=" + hotel_detail_address + ", room_member=" + room_member + ", room_price="
				+ room_price + ", days=" + days + ", checkin=" + checkin + ", checkout=" + checkout + ", regdate="
				+ regdate + ", filepath=" + filepath + ", filename=" + filename + "]";
	}

	
	
	
	
}
