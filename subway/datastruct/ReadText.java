package datastruct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.spi.LocaleNameProvider;

import javax.xml.transform.Templates;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ReadText {
	public static LinkedHashSet<List<Station>> All_line=new LinkedHashSet<List<Station>>();//线路的集合
	public ReadText(String filepath) {
		readtxt(filepath);
		// TODO Auto-generated constructor stub
	}
	public static LinkedHashSet<List<Station>> readtxt(String filepath) {
		try {
			File file=new File(filepath);
			if(file.exists()&&file.isFile()) {
				InputStreamReader isr=new InputStreamReader(new FileInputStream(file),"utf-8");
				BufferedReader BR=new BufferedReader(isr);
				String lineText=null;
				int count=0;
				lineText=BR.readLine();
				while(lineText!= null){
					List<Station> line=new ArrayList<Station>(); //一整条线路
					String[] lineTexts=lineText.split("\\s+");
					String line_name=lineTexts[0];
					for(int j=1;j<lineTexts.length;j++) { //往线路中添加站点
						int flag=0;
						for(List<Station> lineList:All_line) {  //找之前存在在其他线路的站点
							for(Station station:lineList) {  
								if(station.getName().equals(lineTexts[j])) {
									station.getLine().add(line_name);
									line.add(station);
									flag=1;
									break; //最多只存在一个站点同时在两条线上
								}
								if(flag==1) break;
							}
						}
						if(j==lineTexts.length-1 &&lineTexts[j].equals(lineTexts[1])) {
							line.get(0).getLinkstations().add(line.get(line.size()-1));
							line.get(line.size()-1).getLinkstations().add(line.get(0));
							flag=1;
						}
						if(flag==0) {
							line.add(new Station(lineTexts[j],line_name));
						}
					
					}
					for(int k=0;k<line.size();k++) {
						List<Station> newlinkStations=line.get(k).getLinkstations();
						if(k==0) {
							newlinkStations.add(line.get(k+1));
							line.get(k).setLinkstations(newlinkStations);
						}
						else if(k==line.size()-1) {
							newlinkStations.add(line.get(k-1));
							line.get(k).setLinkstations(newlinkStations);
						}
						else {
							newlinkStations.add(line.get(k-1));
							newlinkStations.add(line.get(k+1));
							line.get(k).setLinkstations(newlinkStations);
						}
						
					}
					All_line.add(line);
					lineText=BR.readLine();
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error!");
			// TODO: handle exception
		}
		return All_line;
	}
}
