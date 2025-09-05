package com.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	
	@Value("${api.service_key}")	//application.properties에서 값을 가져옴
	private String service_key;
	
	@GetMapping("api/buList")
	public String buList(Model model) {
		return "api/buList";
	}
	
	@ResponseBody
	@GetMapping("/api/api2")
	public String api2(@RequestParam(name="page", defaultValue="1") String page) throws Exception {
		//api 정보 가져오기
		page = "1";	// 하단 넘버링 페이지
		String web_url = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo";
		StringBuilder urlBuilder = new StringBuilder(web_url); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+service_key); /*Service Key*/
		//주석처리해야 함.
		//urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*이부분 주석처리 : 공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("basDt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginBasDt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endBasDt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("likeBasDt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("likeSrtnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("isinCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("likeIsinCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("itmsNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("likeItmsNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("mrktCls","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginVs","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endVs","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginFltRt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endFltRt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginTrqu","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endTrqu","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginTrPrc","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endTrPrc","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginLstgStCnt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endLstgStCnt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("beginMrktTotAmt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("endMrktTotAmt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		 rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
		 rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
		sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//---------------------------------------------------------------------
		
		System.out.println("데이터 출력 :");
		System.out.println(sb.toString());

		return sb.toString();
	}
	
	
	@GetMapping("api/list")	//api 페이지 열기
	public String list(Model model) {	// 페이지로 열때는 json 파싱 필요
		return "api/list";
	}
	
	
	@ResponseBody
	@GetMapping("/api/api")	//공공데이터 가져오기
	public String api(@RequestParam(name="page", defaultValue="1") String page) throws Exception {
		//api 정보 가져오기 : 공공데이터포털에서 제공하는 소스 ----------------------------
		page = "1";	// 하단 넘버링 페이지
		String web_url = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1";
		StringBuilder urlBuilder = new StringBuilder(web_url); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+service_key); /*Service Key*/
		//주석처리해야 함.
		//urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*이부분 주석처리 : 공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)*/
		urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명(어플명)*/
		urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*정렬구분 : A=촬영일, B=제목, C=수정일*/
		urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		 rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
		 rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
		sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//---------------------------------------------------------------------
		
		System.out.println("데이터 출력 :");
		System.out.println(sb.toString());

		return sb.toString();
	}
}
