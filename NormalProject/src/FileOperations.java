import java.io.*;


public class FileOperations {
	
	private static final String INPUT_FILE_NAME = "C:\\Users\\ASUS\\IdeaProjects\\NormalProject\\src\\in.txt";
	private static final String OUTPUT_FILE_NAME = "out.txt";


	public static void main(String[] args) {

		try {
			String line;
			BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
			while (true) {
				line = br.readLine();
				if (line == null) break;
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String text = "Hello World";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
			bw.write(text);
			bw.write("\n");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		File file = new File(INPUT_FILE_NAME);
		System.out.println("Executable: " + file.canExecute());
		System.out.println("Readable: " + file.canRead());
		System.out.println("Writable: "+ file.canWrite());
	}
}