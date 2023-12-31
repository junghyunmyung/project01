package testBoard.board.dto;

public class ImageDTO {
	private int hotel_code;
	private int room_code;
	private int review_code;
	
	private String filename;
	private String filepath;
	
	public ImageDTO() {
	}

	public ImageDTO(int hotel_code, int room_code, int review_code, String filename, String filepath) {
		this.hotel_code = hotel_code;
		this.room_code = room_code;
		this.review_code = review_code;
		this.filename = filename;
		this.filepath = filepath;
	}
	
	public ImageDTO (String filename, String filepath) {
		this.filename = filename;
		this.filepath = filepath;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public int getRoom_code() {
		return room_code;
	}

	public void setRoom_code(int room_code) {
		this.room_code = room_code;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getReview_code() {
		return review_code;
	}

	public void setReview_code(int review_code) {
		this.review_code = review_code;
	}

	@Override
	public String toString() {
		return "ImageDTO [hotel_code=" + hotel_code + ", room_code=" + room_code + ", review_code=" + review_code
				+ ", filename=" + filename + ", filepath=" + filepath + "]";
	}
	
	
}
