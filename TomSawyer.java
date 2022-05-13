package TomSawyer;
import java.io.*;
import java.util.*;
//write to file
public class TomSawyer {
	Map<String, Integer> tom;
	FileWriter filew;
	public TomSawyer() throws IOException{
		tom = new HashMap<String, Integer>();
		 filew = new FileWriter(new File("H:\\workspace2021\\Maps\\src\\TomSawyer\\WordsOccur.txt"));
	}
	public void add(String sent) throws IOException {
		String[] line = sent.split(" ");
		for(int i  = 0; i < line.length; i++) {
		if(tom.containsKey(line[i])) {
			int num = tom.get(line[i]) + 1;
			tom.put(line[i], num);
		}
		else {
			tom.put(line[i], 1);
		}
		}
		
		
	}
	public Set<String> once() {
		Set<String> once = new HashSet<String>();
		for(String a : tom.keySet()) {
			if(tom.get(a)==1) {
				once.add(a);
			}
		}
		return once;
	}
	
	public String ten() {
		Set<String> moreOne = new HashSet<String>();
		String output = "";
		for(String a : tom.keySet()) {
			if(tom.get(a)>10) {
				moreOne.add(a);
				for(int i = 0; i < tom.get(a); i++) {
					output+=a + " ";
				}
				output+="\n";
			}
		}
		return output;
	}
	public String noio() throws IOException{
		BufferedWriter br = new BufferedWriter(filew);
		String output = "";
		for(String a : tom.keySet()) {
				br.write(a + " " + tom.get(a) + "\n");
		}
		filew.close();
		FileReader file  = new FileReader(new File("H:\\\\workspace2021\\\\Maps\\\\src\\\\TomSawyer\\\\WordsOccur.txt"));
		BufferedReader br1 = new BufferedReader(file);
		while(br1.ready()) {
			output+=br1.readLine() + "\n";
		}
		return output;
	}
	public String toString() {
		try {
			return this.noio();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws IOException{
		
		FileReader file = new FileReader(new File("H:\\workspace2021\\Maps\\src\\TomSawyer\\tomSawyer.txt"));
		BufferedReader br = new BufferedReader(file);
		TomSawyer a = new TomSawyer();
		while(br.ready()) {
			 a.add(br.readLine());
		}
		System.out.println(a);
	}

}
