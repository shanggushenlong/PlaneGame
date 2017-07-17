package cn.bjsxt.Plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import cn.bjsxt.Util.GameUtil;

/**
 * 定义飞机类,将飞机独立封装起来
 * @author wcq
 *
 */
public class Plane extends GameObject{
	boolean left,right,up,down;   //定义四个变量,控制四个方向,这样飞机能够在八个方向运动
	boolean live = true;    //加入一个新的boolean变量,判断控制飞机是否还存活,默认游戏开始飞机是活着的
	
	public Plane(){
		
	}
	public Plane(String imgpath, double x, double y) {
//		super();
		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;

	}
//	//定义飞机碰撞检测方法,定义矩形方法检测,jdk提供了一个Rectangle类,计算矩形
//	public Rectangle getRect(){
//		Rectangle r = new Rectangle((int)x,(int)y,width,height);
//		return r;
//	}
	
	public void draw(Graphics g){
		//加一个判断,判断飞机是否活着,为true,就画出飞机
		if(live){
			g.drawImage(img,(int) x,(int) y, null);
			move();
		}	
	}
	//通过set,get方法对全局变量live操作
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	//定义通过键盘操作飞机移动的方法move()
	public void move(){
		if(left){
			x -= speed;
		}
		if(up){
			y -= speed;
		}
		if(right){
			x += speed;
		}
		if(down){
			y += speed;
		}
		//由于这些代码是操作飞机,所以将这些代码全部放到plane类里面
	}
	//键盘按下去的时候添加方向
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = true;	
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
				break;
		}
	}
	//键盘弹起的时候
	public void loseDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
				break;
		}
	}


}
