package cn.bjsxt.Plane;

import java.awt.Color;
import java.awt.Graphics;

import cn.bjsxt.Util.Constant;

/**
 * 这是一个子弹类
 * @author wcq
 *
 */
public class Bullet extends GameObject{
	double degree;
	
	//构造方法
	public Bullet(){
		degree = Math.random() * Math.PI*2; // [0,360]; 控制子弹变换的角度
		width = 10;
		height = 10;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
	}

	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		//设置x,y移动变化
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		//使得子弹能够碰撞回来
		if(y>Constant.GAME_HEIGHT - height || y<0){
			degree = -degree;
		}
		if(x>Constant.GAME_WIDTH - width || x<0){
			degree = Math.PI - degree;
		}
		g.setColor(c);
	}
}







