package testBoard.board.dto;

import java.util.List;

public class SearchDTO {
	private String checkin;
	private String checkout;
	private Integer hotel_code;
	
	private String check;
	
	   private String location;
	   private List<String> type;
	   private List<String> bedType;
	   private List<String> filter;
	   
	public SearchDTO(String checkin, String checkout, Integer hotel_code, String location, List<String> type,
			List<String> bedType, List<String> filter,String check) {
		this.checkin = checkin;
		this.checkout = checkout;
		this.hotel_code = hotel_code;
		this.location = location;
		this.type = type;
		this.bedType = bedType;
		this.filter = filter;
		this.check= check;
	}

	
	
	
	public String getCheck() {
		return check;
	}




	public void setCheck(String check) {
		this.check = check;
	}




	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public Integer getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(Integer hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<String> getBedType() {
		return bedType;
	}

	public void setBedType(List<String> bedType) {
		this.bedType = bedType;
	}

	public List<String> getFilter() {
		return filter;
	}

	public void setFilter(List<String> filter) {
		this.filter = filter;
	}




	@Override
	public String toString() {
		return "SearchDTO [checkin=" + checkin + ", checkout=" + checkout + ", hotel_code=" + hotel_code + ", check="
				+ check + ", location=" + location + ", type=" + type + ", bedType=" + bedType + ", filter=" + filter
				+ "]";
	}

	
	
	
	
	
	
}
