package cn.bjsxt.Util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 游戏开发中常用的工具类,比如加载的图片等方法
 * @author wcq
 *
 */

public class GameUtil {
	
	private GameUtil(){}   //将构造方法私有,外部不能调用了,只让外部调用getImage()方法
	
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try{
			img = ImageIO.read(u);
		}catch(IOException e){
			e.printStackTrace();
		}	
		return img;
	}
	
//	public static Image getImage(String path){
//		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
//	}
	
	// URL url = GameUtil.class.getClass().getResource(path);
	// Image img = Toolkit.getDefaultToolkit().getImage(url);
	// int height = img.getWidth(img);
	
	/*  height == -1； 也就是没有图片。
	 *  使用 img.getHeight(null); 图片加载到内存中，可获图片真实高度，否则得到img对象，但没加载到内存就会等于 -1；
	 *   而toolkit并没有加载到内存，只有调用g.drawImage才把图片加载到内存。
	 *   
	 * */
	
}


















