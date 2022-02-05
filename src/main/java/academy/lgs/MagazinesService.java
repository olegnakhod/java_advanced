package academy.lgs;

import java.util.ArrayList;
import java.util.List;

public class MagazinesService {
	
	private List<Magazine> listOfMagazines = new ArrayList<>();
	private static MagazinesService magazinesService;
	
	private  MagazinesService() {
		
	}
	
	public static MagazinesService getMagazineService() {
		if(magazinesService == null ) {
			magazinesService = new MagazinesService();
		}
		return magazinesService;
	}

	public List<Magazine> getListOfMagazines() {
		return listOfMagazines;
	}
	
	public void addMagazine(Magazine magazine) {
		this.listOfMagazines.add(magazine);
	}
	
	public Magazine getMagazine(String name) {
		return listOfMagazines.stream().filter(magazine -> magazine.getName().equals(name)).findAny().orElse(null);
	}

	

}
