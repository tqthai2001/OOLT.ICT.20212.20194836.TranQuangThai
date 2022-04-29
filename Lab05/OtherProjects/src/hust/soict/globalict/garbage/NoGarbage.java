package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "src/hust/soict/globalict/garbage/SpotifySetup.exe";
		byte[] inputBytes = {0};
		long startTime, endTime;
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder outStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outStringBuilder.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime));
	}
}