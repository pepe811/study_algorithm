package Regex;
import java.io.*;
import java.util.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/detect-html-links/problem
//INPUT  : <li id="n-mainpage-description"><a href="/wiki/Main_Page" title="Visit the main page [z]" accesskey="z">Main page</a></li>
//OUTPUT : /wiki/Main_Page,Main page

public class DetectHTMLLinks {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int lineCnt = scanner.nextInt();
    	ArrayList<String> html = new ArrayList();
    	
    	for (int i = 0; i < lineCnt ; i++) {
    		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    		
    		String line = scanner.nextLine();
    		//Pattern ptn = Pattern.compile("a href=\"([a-zA-Z0-9:/_.?&=;]*)\"[^>.*]*>([a-zA-Z\\s.,]*)</a>");
    		//Pattern ptn = Pattern.compile("a href=\"([\\w\\d:/_.?&=;]*)\"[^>.*]*>([\\w\\s.,]*)</a>");
    		/*
    		 * \ 치환문자,  * 0회이상 = {0,} .*모든문자
    		 * a href=" ([\w 문자열, \d 숫자, :/_.?&=;]*) => ""사이의 첫번째 링크 걸러내고 "
    		 * [^>.*]*> => '>'제외한 모든 문자 건너뛰고 ~~y="z> 까지 옴 
    		 * ([\w 문자열, \d 숫자,.]*)</a> => </a>전까지 내용 걸러내기
    		 */
    		
    		
    		// 더 간단하게 
    		Pattern ptn = Pattern.compile("a href=\"(.*?)\".*?>(.*?)</a>");
    		/*
    		 * "(.*?)"  에서 ?를 안붙이면  Greedy Operator로 마지막 " 있는데까지 가버림 "(/wiki ~ accesskey="z)"까지 걸러져버림
    		 * ? 붙이면 Non-greedy Operator로 처음나오는 "(/wiki ~ Main_Page)" 까지 알맞게 걸러짐
    		 * 두번째 거르는것도 마찬가지로 첫번째</a>전까지만 걸러짐
    		 */
    		Matcher matcher = ptn.matcher(line);
    		
    		while(matcher.find()){ 
    			html.add(matcher.group(1) + "," + matcher.group(2));
    		} 
    	}
    	
    	for (int i = 0; i < html.size() ; i++) {
    		System.out.println(html.get(i));
    	}

    }
}