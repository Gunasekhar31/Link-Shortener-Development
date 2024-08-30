import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private static final String BASE_URL = "http://short.ly/";
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;
    
    private final Map<String, String> urlMap = new HashMap<>();
    private final Random random = new Random();
    
    public String shortenUrl(String longUrl) {
        String shortCode = generateShortCode();
        urlMap.put(shortCode, longUrl);
        return BASE_URL + shortCode;
    }
    
    public String getOriginalUrl(String shortUrl) {
        String shortCode = shortUrl.replace(BASE_URL, "");
        return urlMap.get(shortCode);
    }
    
    private String generateShortCode() {
        StringBuilder shortCode = new StringBuilder(SHORT_CODE_LENGTH);
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortCode.append(CHARACTERS.charAt(index));
        }
        return shortCode.toString();
    }
    
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        
        // Test shortening and retrieving URLs
        String longUrl = "https://www.example.com/some/long/url";
        String shortUrl = linkShortener.shortenUrl(longUrl);
        
        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Original URL: " + linkShortener.getOriginalUrl(shortUrl));
    }
}
