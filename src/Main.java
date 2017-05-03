import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
	public static void main(String[] args){
		final String FILE_PATH = "resources/input.txt";
		/* load input data */
		ArrayList<String> inputData = new ArrayList<String>();
		try {
			FileReader file = new FileReader(FILE_PATH);
			BufferedReader text = new BufferedReader(file);
			String line;
			while ((line = text.readLine()) != null) {
				inputData.add(line);
			}
			text.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* convert input data to instructions using REGEX */
		final String PATTERN = "(LOAD|ADD|SUB|CMP)\\s+(R\\d+),\\s*((R\\d+)|\\d+)\\s*";
		ArrayList<String[]> instructions = new ArrayList<String[]>();
		for(int i = 0; i < inputData.size(); i++) {
			String line[] = new String[3];

			Pattern p = Pattern.compile(PATTERN);
			Matcher m = p.matcher(inputData.get(i));
			if(m.find()) {
				line[0] = m.group(1);
				line[1] = m.group(2);
				line[2] = m.group(3);
			}
			instructions.add(line);
		}
		String inst[][] = new String[0][0];
		inst = instructions.toArray(new String[0][0]);	//converts instructions to a 2D String array
	}
}