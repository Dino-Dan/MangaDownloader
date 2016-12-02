import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import javax.imageio.ImageIO;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DownloadManga {
	
	public static String saveTo = System.getProperty("user.home") + "/Documents";
	public static String originalURL = null;

	public static void main(String[] args){
		
		System.out.println("running manga downloader\n.\n.\n.");
		// Get the URL from the User
		System.out.println("Please enter a URL for the first page of the Manga  (currently only mangareader accepted)");
		originalURL = getOriginalURL();
		
		// Go the the page
		Document doc = JSoup.connect(originalURL).get();
		// Download the img
		
			// Loop through the pages in this chapter
			
			// Download the img
		
		
	}
	
	public static String getOriginalURL(){
		// Get the Input URL from the User
		Scanner scan = new Scanner(System.in);
		String original_page = scan.next();
		scan.close();
		
		return original_page;
	}
	
	public static void downloadPage(String img_url, int pageNumber){
		
		// Create an empty buffered image to save the image in
		BufferedImage image = null;
		
		// Create a URL object and read the image from it
		try {
			URL url = new URL(img_url);
		
			HttpURLConnection httpcon = (HttpURLConnection) url.openConnection(); 
			httpcon.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"); 
			image = ImageIO.read(httpcon.getInputStream());
			// Save the image in the designated location
			ImageIO.write(image,  "jpg",  new File(saveTo + Integer.toString(pageNumber) + ".jpg"));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
