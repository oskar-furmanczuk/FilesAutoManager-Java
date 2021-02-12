import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	static String dir = "C:/BASE_FOLDER/";

	public static void main(String[] args) {
		
		System.out.println("App is running");

		createDirs();

		createCountFile();

		moveFiles();
		
		System.out.println("App has successfully finished processing.");

	}

	public static void createDirs() {

		String[] list = new String[3];
		list[0] = "HOME";
		list[1] = "DEV";
		list[2] = "TEST";
		for (int i = 0; i < list.length; i++) {

			try {

				Path path = Paths.get(dir + list[i]);
				Files.createDirectories(path);

			} catch (IOException e) {
				System.err.println("Tworzenie katologu nie powiod³o siê!" + e.getMessage());
			}
		}
	}

	public static void createCountFile() {
		File countFile = new File(dir + "HOME/count.txt");

		if (!countFile.exists()) {
			try {
				countFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileWriter myWriter;
			try {
				myWriter = new FileWriter(dir + "HOME/count.txt");
				myWriter.write("ALL MOVED FILES | FILES MOVED TO DEV | FILES MOVED TO TEST \n" + "0|0|0");
				myWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void moveFiles() {
		File f = new File("C:/BASE_FOLDER/HOME");
		String[] names;
		names = f.list();

		for (String name : names) {

			Path p = Paths.get(dir + "HOME/" + name);

			BasicFileAttributes attr;

			try {
				attr = Files.readAttributes(p, BasicFileAttributes.class);

				long cTime = attr.creationTime().toMillis();
				ZonedDateTime t = Instant.ofEpochMilli(cTime).atZone(ZoneId.of("UTC"));
				String dateCreated = DateTimeFormatter.ofPattern("HH").format(t);

				int hour = Integer.parseInt(dateCreated);

				if (name.endsWith(".xml")) {
					Files.move(p, Paths.get(dir + "DEV/" + name));
					writeToCountFile(1);

				} else if (name.endsWith(".jar") && hour % 2 == 0) {
					Files.move(p, Paths.get(dir + "DEV/" + name));
					writeToCountFile(1);
				} else if (name.endsWith(".jar") && hour % 2 == 1) {
					Files.move(p, Paths.get(dir + "TEST/" + name));
					writeToCountFile(2);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void writeToCountFile(int catalogNr) {

		int nrAll = -1;
		int nrDev = -1;
		int nrTest = -1;

		try {

			String line2 = Files.readAllLines(Paths.get(dir + "HOME/count.txt")).get(1);

			  nrAll = Integer.parseInt(line2.split("\\|")[0]); 
			  nrDev = Integer.parseInt(line2.split("\\|")[1]); 
			  nrTest =  Integer.parseInt(line2.split("\\|")[2]);
			  
			 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (catalogNr == 1) {
			nrDev++;
			nrAll++;
		} else {
			nrTest++;
			nrAll++;
		}

		FileWriter myWriter;

		try {
			myWriter = new FileWriter(dir + "HOME/count.txt");
			myWriter.write("ALL MOVED FILES | FILES MOVED TO DEV | FILES MOVED TO TEST \n" + nrAll + "|" + nrDev + "|"
					+ nrTest);
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
