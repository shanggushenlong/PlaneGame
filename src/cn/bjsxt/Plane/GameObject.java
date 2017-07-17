package cn.bjsxt.Plane;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * 这是一个物体类,是子弹,飞机的父类
 * @author wcq
 *
 */
public class GameObject {
	Image img;
	double x,y;
	int speed = 5;
	int width,height;
	
	//定义飞机碰撞检测方法,定义矩形方法检测,jdk提供了一个Rectangle类,计算矩形
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	public GameObject(){
		
	}
	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	
}
