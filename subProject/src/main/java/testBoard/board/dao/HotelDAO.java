package testBoard.board.dao;

import java.util.List;

import testBoard.board.dto.BookingDTO;
import testBoard.board.dto.CheckDTO;
import testBoard.board.dto.Hotel_Banner_InfoDTO;
import testBoard.board.dto.Hotel_Detail_ConDTO;
import testBoard.board.dto.Hotel_RatingDTO;
import testBoard.board.dto.Hotel_ReviewDTO;
import testBoard.board.dto.Hotel_Sub_InfoDTO;
import testBoard.board.dto.ImageDTO;
import testBoard.board.dto.IndexBannerDTO;
import testBoard.board.dto.PayCheckDTO;
import testBoard.board.dto.PayPageDTO;
import testBoard.board.dto.Room_Banner_InfoDTO;
import testBoard.board.dto.SearchDTO;
import testBoard.board.dto.managementDTO;
import testBoard.free.dto.BoardFreeDTO;
import testBoard.payment.dto.KakaoPayCancelDTO;


public interface HotelDAO {
	public List<Hotel_Banner_InfoDTO> hotelListAll();
	public List<Hotel_Banner_InfoDTO> searchHotelList(SearchDTO searchDTO);
	public List<Hotel_Sub_InfoDTO> hotelSubInfo(int hotel_code);
	public List<Room_Banner_InfoDTO> roomList(SearchDTO searchDTO);
	
	public List<Hotel_Detail_ConDTO> Hotel_Detail_infoMathod(int hotel_code);
	
	public List<Hotel_ReviewDTO> Hotel_ReviewMethod(int hotel_code);
	
	public int insertReview(Hotel_ReviewDTO review);
	   
	public int insertReviewImage(ImageDTO reviewImage);
	   
	public int updateReview(Hotel_ReviewDTO review);
	   
	public int deleteReview(int review_code);
	   
	public double getAvgRating(int hotel_code);
	   
	public int getCntRating(int hotel_code);
	   
	public int updateRating(Hotel_RatingDTO rating);
	
	public List<managementDTO> menagementMethod();
	
	public int deleteReviewImage(int review_code);
	
	public int insertBusinessComment(Hotel_ReviewDTO review);
	
	public List<CheckDTO> myPageMethod(int mem_code);
	
	public PayPageDTO PayPageMethod(PayCheckDTO payCheckDTO);
	
	public int PaymentMethod(BookingDTO bookingDTO);

	public int bookingCancelMethod(int booking_code);
	
	public List<IndexBannerDTO> indexBannerMethod();
	
	public int KakaoPayCancelMethod(KakaoPayCancelDTO kakaoPayCancelDTO);
	
	public KakaoPayCancelDTO selectKakaoPayMethod(int booking_code);
	
	public List<BoardFreeDTO> RawnumBoardMethod();
	
}
