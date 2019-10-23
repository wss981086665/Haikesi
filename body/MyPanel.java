package com.first.body;

import com.first.calculate.Calculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import static java.awt.Color.*;

public class MyPanel extends Frame {

    private static int xx = 80;
    private static int yy = 100;
    private static int z0 = 24;
    private static int size = 11;
    ArrayList<Grid> list = new ArrayList<Grid>();
    Calculate calculate = null;

    public  Graphics g;

    public void launch() {
        this.setTitle("海克斯棋-南国猫觅海");
        this.setLocation(200, 200);
        this.setSize(900, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        this.setLayout(null);

        Label label0 = new Label("**Please input num of ROW and COL**:");
        label0.setBounds(600,50,300,30);
        Label label1 = new Label("ROW:");
        label1.setBounds(620,90,40,30);
        Label label2 = new Label("COL:");
        label2.setBounds(620,130,40,30);
        this.add(label0);
        this.add(label1);
        this.add(label2);

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        tf1.setBounds(670,90,70,30);
        tf2.setBounds(670,130,70,30);
        this.add(tf1);
        this.add(tf2);
        Button button = new Button("Go");
        button.setSize(100,40);
        button.setVisible(true);
        button.setLocation(750,100);
        this.add(button);

        button.addActionListener(new ActionListener() {
            int row = 0;
            int col = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    row = Integer.parseInt(tf1.getText());
                    col = Integer.parseInt(tf2.getText());
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "请输入完整棋盘坐标", "输入错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (row < 1 || row >size){
                    JOptionPane.showMessageDialog(null, "value1 输入错误", "输入错误", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if(col <1 || col >size) {
                    JOptionPane.showMessageDialog(null, "value2 输入错误", "输入错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Iterator<Grid> it = list.iterator();
                while(it.hasNext()){
                    Grid grid = it.next();
                    if(grid.getRow() == row && grid.getCol() == col){
                        JOptionPane.showMessageDialog(null, "("+row+","+col+")"+"位置已经有棋子,请重新下棋", "重复", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                list.add(new Grid(row,col,red));
                repaint();
                calculate = new Calculate(list);
                Grid grid = calculate.chess();
                list.add(grid);
                repaint();
                tf1.setText(null);
                tf2.setText(null);
            }
        });
    }

    public void setpencil(Graphics2D g2,Color color,Float a){
        g2.setColor(color);g2.setStroke(new BasicStroke(a));
    }

    @Override
    public void paint(Graphics g) {

        int x0 = xx,x1 = xx;        //0尾变量为内循环中改变的量
        int y0 = yy,y1 = yy;        //1尾变量为外循环中改变的量
        Color c = g.getColor();
        Graphics2D g2 = (Graphics2D)g;        //g是Graphics对象;

        //海克斯棋盘，从左到右0-9,从上到下0-9   *** i 行 j 列***
        for (int i=0; i<size; i++) {
            for(int j=0; j<size; j++){

                if(i==0){       //上左、上右
                    setpencil(g2, red,3.0f);
                    g2.drawLine(x0,y0,(int)(x0+(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0));
                    g2.drawLine(x0,y0,(int)(x0-(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0));
                }else if(j == size-1) {
                    setpencil(g2, black,1.0f);
                    g2.drawLine(x0,y0,(int)(x0-(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0));
                    setpencil(g2, blue,3.0f);
                    g2.drawLine(x0,y0,(int)(x0+(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0));
                } else {
                    setpencil(g2, black,1.0f);
                    g2.drawLine(x0,y0,(int)(x0+(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0));
                    g2.drawLine(x0,y0,(int)(x0-(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0));
                }

                if(j==0){       //中左
                    setpencil(g2, blue,3.0f);
                    g2.drawLine((int)(x0-(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0),(int)(x0-(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0));
                }else{
                    setpencil(g2, black,1.0f);
                    g2.drawLine((int)(x0-(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0),(int)(x0-(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0));
                }
                if(j==size-1){       //中右
                    setpencil(g2, blue,3.0f);
                    g2.drawLine((int)(x0+(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0),(int)(x0+(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0));
                }else{
                    setpencil(g2, black,1.0f);
                    g2.drawLine((int)(x0+(Math.sqrt(3)/2.0)*z0),(int)(y0+z0/2.0),(int)(x0+(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0));
                }

                if(j==0){       //下左
                    setpencil(g2, blue,3.0f);
                    g2.drawLine((int)(x0-(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0),x0,(int)(y0+2.0*z0));
                }else if(i == size-1){
                    setpencil(g2, red,3.0f);
                    g2.drawLine((int)(x0-(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0),x0,(int)(y0+2.0*z0));
                } else {
                    setpencil(g2, black,1.0f);
                    g2.drawLine((int)(x0-(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0),x0,(int)(y0+2.0*z0));
                }
                if(i==size-1){       //下右
                    setpencil(g2, red,3.0f);
                    g2.drawLine((int)(x0+(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0),x0,(int)(y0+2.0*z0));
                }else{
                    setpencil(g2, black,1.0f);
                    g2.drawLine((int)(x0+(Math.sqrt(3)/2.0)*z0),(int)((y0+z0/2.0)+z0),x0,(int)(y0+2.0*z0));
                }
                x0 = x0+(int)(Math.sqrt(3)*z0);

            }
            x1 = x1 + (int)((Math.sqrt(3)/2)*z0);  x0 = x1;
            y1 = (y1+z0/2)+z0+1;   y0 = y1;
        }
        g.setColor(c);
        Iterator<Grid> it = list.iterator();
        while (it.hasNext()){
            Grid grid = it.next();
            grid.draw(g);
        }
        g.setColor(c);

    }

}