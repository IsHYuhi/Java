import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/*
<applet code = "ExGenerics_01" width=400 height=400></applet>
*/

public class ExGenerics_01 extends Applet{
	ArrayList  num_list = new ArrayList();

	public void init(){
		this.setSize(400, 300);
		num_list.add("1200");
		num_list.add(new Point(300, 100));
		num_list.add(1300);
		num_list.add("1400");
		num_list.add("1500");
		num_list.add("1600");
	}

	public void paint(Graphics g){
		super.paint(g);

		for(int ii = 0 ; ii < num_list.size() ; ii++){
			String s = (String)num_list.get(ii); //Exception
			g.drawString(s, 100, ii*20);
		}
	}
}
