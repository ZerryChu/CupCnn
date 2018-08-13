package cupcnn.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTransformer {

	public void binaryImage(String from, String to) throws IOException {
		File file = new File(from);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}

		File newFile = new File(to);
		ImageIO.write(grayImage, "jpeg", newFile);
	}

	public void grayImage(String from, String to) throws IOException {
		File file = new File(from);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}

		File newFile = new File(to);
		ImageIO.write(grayImage, "jpeg", newFile);
	}

	public static byte[] getBytes(String fileName) {
		File file = new File(fileName);
		BufferedImage image;
		try {
			image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();
		
        byte[] b = new byte[width * height];
        
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int rgb = image.getRGB(i, j);
				Color c = new Color(rgb);
				b[i + j * height] = (byte) (255 - c.getBlue());
				// System.out.println(rgb);
			}
		} 
		
		/*
		int index = 0;
		for (int i = height-1; i >= 0; i--) {
			for (int j = width - 1;j >= 0; j--) {
				int num = b[index++] & 0xff;
				if (num > 200) // white
					System.out.print(3 );
				else if (num < 50)
					System.out.print(1 );
				else {
					System.out.print(2 );
				}
			} 
			System.out.println();
		}
		
		System.out.println();
		*/
		
		return b;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
   /** 
    *  state:      color enhancement...still coding...
	*  background: increase the contrast ratio between number and background so that the model can perform better.
	*/
	public static void colorEnhance(String from, String to) throws IOException {
		File file = new File(from);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				Color c = new Color(rgb);
				System.out.println(c.getGreen());
				if (c.getBlue() < 230)
					image.setRGB(i, j, 0);
			}
		}

		File newFile = new File(to);
		ImageIO.write(image, "jpeg", newFile);
	}
	
	public static void main(String[] args) throws IOException {
		// demo.grayImage("data/2.jpeg", "data/2.png");
		 colorEnhance("data/5.jpeg", "data/5555.jpeg");
	}
	
}
