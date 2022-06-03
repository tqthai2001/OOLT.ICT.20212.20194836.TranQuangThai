package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame {
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
	}
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label:"));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length];
		for(int i = 0; i < lafInfos.length; i++) {
			lafNames[i] = lafInfos[i].getName();
		}
		JComboBox cbLookAndFeel =  new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				if (index == lafInfos.length) {
					try {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if (index == lafInfos.length+1) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					try {
						UIManager.setLookAndFeel(lafInfos[index].getClassName());
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}

				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafNames[index] + " Look And Feel");
			}
		});
	}
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
}
