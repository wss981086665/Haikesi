package com.first.calculate;

import com.first.body.Grid;

import java.awt.*;
import java.util.ArrayList;

public class Calculate {

    private ArrayList<Grid> list = new ArrayList<Grid>();

    public Calculate(ArrayList<Grid> list) {
        this.list = list;
    }

    public ArrayList<Grid> getList() {
        return list;
    }

    public void setList(ArrayList<Grid> list) {
        this.list = list;
    }

    public Grid chess(){
        int count = 100;
        Grid grid = null;
        int row = 0,col = 0;

        for(int i=0; i<count; i++){
            row = (int)(1+Math.random()*(10-1+1));
            col = (int)(1+Math.random()*(10-1+1));
        }

        grid = new Grid(row,col, Color.blue);
        return grid;
    }
}
