package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextNormalizer {

    public static String normalizeText(String text) {
//Tách từng dòng để xử lý
        String[] lines = text.split("(?<=\\n)");
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
//Xóa khoảng trắng đầu cuối
            String normalizedLine = line.trim();
//Chỉ một khoảng trắng giữa các từ
            normalizedLine = normalizedLine.replaceAll("\\s+", " ");
//không khoảng trắng trước các dấu câu
            normalizedLine = normalizedLine.replaceAll("\\s+([,.!:?;])", "$1");
//chỉ một khoảng trắng sau dấu câu
            normalizedLine = normalizedLine.replaceAll("([,.!:?;])([^ ])", "$1 $2");
// Gộp dấu chấm hoặc chấm than, chấm hỏi lặp lại
            normalizedLine = normalizedLine.replaceAll("([.!?])\\1+", "$1");
            
            if (line.endsWith("\n")) {
//Thêm dấu chấm hết ở cuối dòng
                if (!normalizedLine.isEmpty()) {
                    if (".?!".indexOf(normalizedLine.charAt(normalizedLine.length() - 1)) == -1) {
                        normalizedLine += ".";
                    }
                }
                normalizedLine += "\n";
            }

            result.append(normalizedLine);
        }
        String text2 = result.toString().trim();
//Không có dấu xuống dòng giữa các dòng vs nhau
        text2 = text2.replaceAll("(\\n\\s*){2,}", "\n");
//Xử lý dấu quotes
        Pattern pq = Pattern.compile("\\s*\"(.*?)\"\\s*");
        Matcher mq = pq.matcher(text2);
        StringBuffer sbq = new StringBuffer();
        while (mq.find()) {
            String inside = mq.group(1);
            String cleanInside = inside.trim().replaceAll("\\s+", " ");
            mq.appendReplacement(sbq,
                    Matcher.quoteReplacement(" \"" + cleanInside + "\" "));
        }
        mq.appendTail(sbq);
        text2 = sbq.toString();

        text2 = text2.toLowerCase();
//Chữ cái đầu dòng phải viết hoa
//Chữ cái đầu sau dấu chấm phải viết hoa
        Pattern p = Pattern.compile("(?m)(^\\s*[\\p{L}]|[.!?]\\s+[\\p{L}])", Pattern.UNICODE_CASE);
        Matcher m = p.matcher(text2);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
        }
        m.appendTail(sb);
        text2 = sb.toString();
//Viết hoa chữ cái đầu dòng
        if (!text2.isEmpty()) {
            text2 = text2.substring(0, 1).toUpperCase()
                    + text2.substring(1);
        }
//Thêm dấu chấm cuối dòng
        if (!text2.endsWith(".")) {
            text2 += ".";
        }

        return text2;
    }
}
