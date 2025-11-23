package filenormalize;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import service.FileHandler;
import service.TextNormalizer;

public class FileNormalize {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try {
            String content = FileHandler.readFile(inputFile);
            
            if(content == null || content.trim().isEmpty()){
                System.err.println("File is null or don't have anything.");
                return;
            }
            
            String normalized = TextNormalizer.normalizeText(content);

            FileHandler.writeFile(outputFile, normalized);

            System.out.println("Chuẩn hóa hoàn tất. Kết quả ghi vào file: " + outputFile);
        }catch (NoSuchFileException e) {
            System.err.println("No found the file " + inputFile + " Please recheck.");
        }catch(IOException e){
            System.err.println("Error when read or write file: " + inputFile);
            //gắn đường dẫn khác output.txt/input.txt thì sẽ báo lỗi ko đọc hay ghi được 
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } 
    }
}
