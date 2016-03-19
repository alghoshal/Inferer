package infer.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author algo
 */
public class RandomReader {
	
	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("ERROR! Please enter source_file_name & no_of_samples");
			System.exit(0);
		}
		
		String inputFileName = args[0];
		int noOfSamples = Integer.parseInt(args[1]);
		String outputFileName = inputFileName+"_"+new Date().getTime();
		readAndGenerateSamples(inputFileName,noOfSamples, outputFileName);
	}

	static void readAndGenerateSamples(String inputFileName, int noOfSamples, String outputFileName) {
		Map<Integer, String> inMemFile = new HashMap<Integer, String>();
		int lineNo=0;
		lineNo = readInMemoryFile(inputFileName, inMemFile, lineNo);
		generateRandomSamples(noOfSamples, outputFileName, inMemFile, lineNo);
	}

	static void generateRandomSamples(int noOfSamples, String outputFileName, Map<Integer, String> inMemFile,
			int lineNo) {
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter(new File(outputFileName)));
			
			Random r = new Random();
			
			for(int i=0;i<noOfSamples;i++){
				int nextRand = r.nextInt(lineNo);
				String dataRead = inMemFile.get(nextRand);
				System.out.println(dataRead);
				writer.write(dataRead);
				writer.write(System.lineSeparator());
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				writer.close();
			}catch(Exception e3){
				System.out.println(e3);
			}
		}
	}

	static int readInMemoryFile(String inputFileName, Map<Integer, String> inMemFile,
			int lineNo) {
		BufferedReader reader = null;
		try{					
				reader = new BufferedReader(new FileReader(new File(inputFileName)));
				String line;
				
				while(null!=(line = reader.readLine())){
					inMemFile.put(lineNo, line);
					lineNo++;
				}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				reader.close();
			}
			catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return lineNo;
	}
}
