package datastruct;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		ReadText.readtxt("C:\\Users\\Mloong\\Desktop\\三年级上\\软件工程\\地铁最短路径\\ddd.txt");
		for(List<Station> line:ReadText.All_line) {
			for(Station s:line) {
				System.out.print(s.getName()+" ");
			}
			System.out.println();
		}
		// TODO Auto-generated method stub

	}

}
