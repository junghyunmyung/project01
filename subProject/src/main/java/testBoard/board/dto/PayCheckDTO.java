package testBoard.board.dto;

public class PayCheckDTO {
		
	private int room_code;
	private int hotel_code;
	
	public PayCheckDTO() {
	}

	public PayCheckDTO(int room_code, int hotel_code) {
		this.room_code = room_code;
		this.hotel_code = hotel_code;
	}

	public int getRoom_code() {
		return room_code;
	}

	public void setRoom_code(int room_code) {
		this.room_code = room_code;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	@Override
	public String toString() {
		return "PayCheckDTO [room_code=" + room_code + ", hotel_code=" + hotel_code + "]";
	}
	
	
	
}
