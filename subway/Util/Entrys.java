package Util;
import java.util.*;
import java.util.Scanner;

import algorithm.*;
import datastruct.*;

public class Entrys {

	public static void main(String[] args) {
		int flag1=1;
		int flag2=1;
		Station star=null;
		Station end=null;
		System.out.println("请输入起点:");
		Scanner input=new Scanner(System.in);
		String starString=input.next();
		System.out.println("请输入起点:");
		String endString=input.next();
		input.close();
		ReadText.readtxt("C:\\Users\\Mloong\\Desktop\\三年级上\\软件工程\\地铁最短路径\\地铁线路信息.txt");
		for(List<Station> line:ReadText.All_line) {
			for(Station s:line) {
				if(s.getName().equals(starString)) {
					flag1=0;
					star=s;
				}
				if(s.getName().equals(endString)) {
					flag2=0;
					end=s;
				}
				if(flag1==0&&flag2==0) {
					break;
				}
			}
			if(flag1==0&&flag2==0) {
				break;
			}
		}
		if(flag1==1||flag2==1) {
			System.out.println("站点错误");
		}
	Result result=Getans.shortestPath(star, end);
	List<String> path=Getans.getPath(result);
	System.out.println(result.getDistance());
	System.out.println(path);
	
		
	}
}
