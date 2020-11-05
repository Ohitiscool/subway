package datastruct;

import java.util.ArrayList;
import java.util.List;

public class Station {
	private String name;
	private List<String> line=new ArrayList<>(); //存此站点所在的线路
	private List<Station> linkstations=new ArrayList<>();  //存同一线路的站点
	Station(String name,String line){
		this.name=name;
		this.line.add(line);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getLine() {
		return line;
	}
	public void setLine(List<String> line) {
		this.line = line;
	}
	public List<Station> getLinkstations() {
		return linkstations;
	}
	public void setLinkstations(List<Station> linkstations) {
		this.linkstations = linkstations;
	}

}
