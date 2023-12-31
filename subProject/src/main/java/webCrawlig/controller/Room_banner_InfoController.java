package webCrawlig.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import webCrawlig.dto.Room_banner_InfoDTO;
import webCrawlig.service.CrawligService;

// http://localhost:8090/test/test/room_banner_info

@Controller
public class Room_banner_InfoController {

	
	private final CrawligService service;

	@Autowired
	public Room_banner_InfoController(CrawligService service) {
		this.service = service;
	}
	
	
	@GetMapping("/test/test/room_banner_info")
	public void execute() throws IOException {
		
		// 지역 : 강남/역삼/삼성/신사/청담 
				// 기간 : 4.19 ~ 4.20 
				// 호텔 갯수 : 47

				String [] urlList = {
						// 1. 호텔 크레센도 서울
						"https://www.goodchoice.kr/product/detail?ano=55178&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 2. 호텔 리베라    
						"https://www.goodchoice.kr/product/detail?ano=6264&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 3. 호텔 인 나인 강남
						"https://www.goodchoice.kr/product/detail?ano=57843&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 4. 노보텔 앰배서더 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=6473&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 5. 이비스 스타일 앰배서더 강남
						"https://www.goodchoice.kr/product/detail?ano=6826&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 6. 호텔 안테룸 서울
						"https://www.goodchoice.kr/product/detail?ano=65455&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 7. 더 디자이너스 리즈 강남 프리미어
						"https://www.goodchoice.kr/product/detail?ano=6903&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 8. 호텔 카푸치노
						"https://www.goodchoice.kr/product/detail?ano=6915&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 9. 호텔 선샤인 서울
						"https://www.goodchoice.kr/product/detail?ano=6533&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 10. 에이든 바이베스트웨스턴 청담
						"https://www.goodchoice.kr/product/detail?ano=55185&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 11. L7 강남 바이 롯데
						"https://www.goodchoice.kr/product/detail?ano=48567&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 12. AC 호텔 바이 메리어트 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=70224&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 13. 글래드 강남 코엑스센터
						"https://www.goodchoice.kr/product/detail?ano=49442&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 14. 신라스테이 역삼
						"https://www.goodchoice.kr/product/detail?ano=7936&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 15. 보코서울강남, IHG 호텔
						"https://www.goodchoice.kr/product/detail?ano=70540&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 16. 엘리에나 호텔
						"https://www.goodchoice.kr/product/detail?ano=72776&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 17. H 에비뉴 호텔 역삼점
						"https://www.goodchoice.kr/product/detail?ano=71261&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 18. 조선 팰리스 서울 강남 럭셔리 컬렉션
						"https://www.goodchoice.kr/product/detail?ano=69906&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 19. 사월 호텔
						"https://www.goodchoice.kr/product/detail?ano=69487&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 20. 역삼 아르누보씨티 호텔앤레지던스
						"https://www.goodchoice.kr/product/detail?ano=70045&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 21. 신라스테이 삼성
						"https://www.goodchoice.kr/product/detail?ano=64392&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 22. 안다즈 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=61931&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 23. 파크 하얏트 서울
						"https://www.goodchoice.kr/product/detail?ano=57910&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 24. 오크우드 프리미어 코엑스센터
						"https://www.goodchoice.kr/product/detail?ano=65311&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 25. 라비타호텔
						"https://www.goodchoice.kr/product/detail?ano=52120&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 26. 호텔 세느
						"https://www.goodchoice.kr/product/detail?ano=51954&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 27. 호텔 페이토 삼성
						"https://www.goodchoice.kr/product/detail?ano=45184&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 28. 파티오세븐 호텔
						"https://www.goodchoice.kr/product/detail?ano=52834&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 29. 호텔 아노블리
						"https://www.goodchoice.kr/product/detail?ano=61661&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 30. 호텔 컬리넌 개포
						"https://www.goodchoice.kr/product/detail?ano=48277&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 31. 도미인 서울강남
						"https://www.goodchoice.kr/product/detail?ano=13067&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 32. 오월 호텔
						"https://www.goodchoice.kr/product/detail?ano=51593&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 33. 인터컨티넨탈 서울 코엑스
						"https://www.goodchoice.kr/product/detail?ano=6980&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 34. 마리호텔
						"https://www.goodchoice.kr/product/detail?ano=51237&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 35. 삼정호텔
						"https://www.goodchoice.kr/product/detail?ano=45099&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 36. 그랜드 인터컨티넨탈 서울 파르나스
						"https://www.goodchoice.kr/product/detail?ano=6490&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 37. 호텔 엔트라 강남
						"https://www.goodchoice.kr/product/detail?ano=10845&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 38. 호텔스타 강남
						"https://www.goodchoice.kr/product/detail?ano=9850&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 39. 강남 스테이호텔
						"https://www.goodchoice.kr/product/detail?ano=8200&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 40. 호텔 그라모스
						"https://www.goodchoice.kr/product/detail?ano=6446&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 41. 호텔 카파스
						"https://www.goodchoice.kr/product/detail?ano=7103&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 42. 인더시티 비즈니스
						"https://www.goodchoice.kr/product/detail?ano=6564&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 43. 라까사호텔 서울
						"https://www.goodchoice.kr/product/detail?ano=6639&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 44. 알로프트 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=6322&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 45. 호텔 데님
						"https://www.goodchoice.kr/product/detail?ano=6338&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 46. 베니키아 강남 노블레스
						"https://www.goodchoice.kr/product/detail?ano=6350&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 47. 베스트웨스턴 프리미어 강남 호텔
						"https://www.goodchoice.kr/product/detail?ano=6259&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20"
				
			};
		
		/////////////////////////////////////
		
			for(int i=0; i<urlList.length; i++) {
				
				String url = urlList[i];
			      
				////////////////////////////////
		      Document doc = Jsoup.connect(url).get();
		      
		      Elements e1 = doc.getElementsByAttributeValue("class", "room");
		      
		  
		  	//객실 이름
		  		List<String> nameList =e1.select("strong").eachText().stream()
		  					.filter(n-> !(n.equals("가격"))).collect(Collectors.toList());
				
		    //객실 가격
				List<String> room_priceList =e1.select("b").eachText();
				
				
				if(url.equals("https://www.goodchoice.kr/product/detail?ano=49442&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20")) {
					
					room_priceList.add(0, "119,000원");
				}
				
				
				Elements e2 = doc.getElementsByAttributeValue("class", "layer pop_full pop_useinfo");
							
				List<String> room_member = new ArrayList<>();
				
				List<String> room_bed = new ArrayList<>();
				
				List<String> room_width = new ArrayList<>();
				
				for(int e=0; e<e2.size(); e++) {
					
					for(int k=0; k<e2.attr("class", "dot_txt").get(e)
							.select("ul").first().children().size(); k++) {
						
						if(e2.attr("class", "dot_txt").get(e)
								.select("ul").first().children().size()==4) {
							
							if(k==0) {
								room_member.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k)
										+e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k+1)
										);
								
							}
							if(k==2) {
								room_bed.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							if(k==3) {
								room_width.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							
						}else if(e2.attr("class", "dot_txt").get(e)
								.select("ul").first().children().size()==2){
							
							if(e2.attr("class", "dot_txt").get(e)
									.select("ul").first().children().eachText().get(k).contains("베드")) {
								
								if(k==0) {
									room_member.add(e2.attr("class", "dot_txt").get(e)
											.select("ul").first().children().eachText().get(k));
								}
								
								if(k==1) {
									
									room_width.add(null);
									
									
									room_bed.add(e2.attr("class", "dot_txt").get(e)
											.select("ul").first().children().eachText().get(k));
								}
								
								
							}
							
							if(k==0) {
								room_member.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							
							if(k==1) {
								
								room_bed.add(null);
								
								
								room_width.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							
							
						}else if(e2.attr("class", "dot_txt").get(e)
								.select("ul").first().children().size()==1){
							
							room_member.add(e2.attr("class", "dot_txt").get(e)
									.select("ul").first().children().eachText().get(k));
							
							room_bed.add(null);
							
							
							room_width.add(null);
							
							
						}else {
							
							if(k==0) {
								room_member.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							
							if(k==1) {
								room_bed.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							
							if(k==2) {
								room_width.add(e2.attr("class", "dot_txt").get(e)
										.select("ul").first().children().eachText().get(k));
							}
							
						}
						
						
						
					}
					
				}
						
						
				
		  
				
	    	  	int num = (i+1);
				
		      for(int j=0; j<nameList.size(); j++) {
		    		 
		    
		    	  int room_code = j+1;
		    	  int hotel_code = num;
		    	  String room_name = nameList.get(j);
		    	  String room_price = room_priceList.get(j);
		    	  String room_mem = room_member.get(j);
		    	  String room_wid = room_width.get(j);
		    	  String room_be = room_bed.get(j);
		    	  
		    	  
		    	  Room_banner_InfoDTO Room_bannerDTO 
		    	  	= new Room_banner_InfoDTO(hotel_code,room_name, room_price, room_mem, room_wid,room_be);
		    	  
		    	  	service.roomBannerInfoProcess(Room_bannerDTO);
		    	  
		    	  	System.out.println(j+"저장완료");
		    	  	
		      }
		      
			}
	      
	      
	      
		
	}
	
}
