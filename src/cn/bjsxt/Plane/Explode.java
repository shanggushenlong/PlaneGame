package cn.bjsxt.Plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.Util.GameUtil;

/**
 * 这是定义一个爆炸类,主要是为了定义当飞机死亡的时候图片切换
 * @author wcq
 *
 */
public class Explode {
	//静态声明  还处于声明阶段，没有在内存中给他划分空间，是不能操作的。要么声明为静态的，提前划分空间
	static Image[] imgs = new Image[16];   //爆炸是一系列的图片交替变换形成的效果,所以使用数组来表示图片
	//静态变量初始化
	static{
		for(int i=0;i<16;i++){
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");   //根据路径寻找图片
			//由于将图片初始加载,不会显现在内存中,所以必须要有一个操作将图片强制加载到内存中
			imgs[i].getWidth(null);
		}
	}
	double x,y;    //爆炸坐标
	int count;   //统计图片的数量
	
	//画出图片
	public void draw(Graphics g){
		//判断图片是否越界
		if(count<=15){
			g.drawImage(imgs[count], (int)x,(int) y, null);
			count++;
		}
	}
	
	//构造函数
	public Explode(){
		
	}
	public Explode(double x,double y){
		this.x = x;
		this.y = y;
	}
}





