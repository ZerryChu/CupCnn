package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.ImageInputStream;

import cupcnn.util.ImageTransformer;

public class MnistTest {
	static List<DigitImage> trains = null;
	static List<DigitImage> tests = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// load mnist
		ReadFile rf1 = new ReadFile("data/train-labels.idx1-ubyte", "data/train-images.idx3-ubyte");
		ReadFile rf2 = new ReadFile("data/t10k-labels.idx1-ubyte", "data/t10k-images.idx3-ubyte");

		List<DigitImage> lists = new ArrayList<DigitImage>();

		try {
			tests = rf2.loadDigitImages();
			// trains =rf1.loadDigitImages();
            
			
		    byte[] b = ImageTransformer.getBytes("data/01.jpeg");
			lists.add(new DigitImage(1, b));
		    b = ImageTransformer.getBytes("data/06.jpeg");
			lists.add(new DigitImage(6, b));
			b = ImageTransformer.getBytes("data/1.jpeg");
			lists.add(new DigitImage(1, b));
			b = ImageTransformer.getBytes("data/6.jpeg");
			lists.add(new DigitImage(6, b));
			b = ImageTransformer.getBytes("data/3333.jpeg");
			lists.add(new DigitImage(3, b));
			b = ImageTransformer.getBytes("data/5555.jpeg");
			lists.add(new DigitImage(5, b));
			b = ImageTransformer.getBytes("data/00034.png");
			lists.add(new DigitImage(0, b));
			b = ImageTransformer.getBytes("data/00001.png");
			lists.add(new DigitImage(0, b));
			b = ImageTransformer.getBytes("data/00021.png");
			lists.add(new DigitImage(0, b));
			 
			/*
			 * imageInputStream = new FileInputStream("data/3.jpeg");
			 * imageInputStream.read(b); lists.add(new DigitImage(3, b));
			 * imageInputStream.close();
			 * 
			 * imageInputStream = new FileInputStream("data/5.jpeg");
			 * imageInputStream.read(b); lists.add(new DigitImage(5, b));
			 * imageInputStream.close();
			 */
			// tests =
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MnistNetwork mn = new MnistNetwork();
		// mn.buildNetwork();

		// mn.train(trains, 20);

		// mn.saveModel("model/mnist.model");

		mn.loadModel("model/mnist.model");
		//mn.test(tests);
		mn.test(lists);
	}

}
