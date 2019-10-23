package com.first.body;

import java.awt.*;

public class Grid {

    private int xx = 80;
    private int yy = 100;
    private int z0 = 24;
    private int row;   //行
    private int col;   //列
    private Color color;

    public Grid(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(color);
        int X = (int)(xx+Math.sqrt(3)*z0*((col-1)+(row-1)/2.0)-(6*(row-1)+4*(col-1))/7.0);      //六边形上方点的坐标X
        int Y = (int)(yy+(z0+z0/2.0+1)*(row-1));     //六边形上方点的坐标Y
        g.fillOval((int)(X-(Math.sqrt(3)/2.0)*z0)+3,(int)(Y+(z0-(Math.sqrt(3)/2.0)*z0)+2),(int)((Math.sqrt(3))*z0-3),(int)((Math.sqrt(3))*z0-3));
        g.setColor(c);
    }

}
