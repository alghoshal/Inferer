package infer.util;

/**
 * @author algo
 */
public interface TextFilter {

	boolean orientFile(String inputFilePath);

	String orientLine(String readLine);

	Object orientAnswer(String query, String answer);

	String orientBody(String body, boolean isQuery);

}