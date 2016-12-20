/* Get position of axe and boat
 * and return the value
 * Update position of axe and boat
 * Get axe and boat sprites
 * */

package com.neet.DiamondHunter.MapViewer;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.Manager.ImageConversion;
import com.neet.DiamondHunter.Coordinates.WriteCoord;
import com.neet.DiamondHunter.GameState.PlayState;

import javafx.scene.image.WritableImage;

public class AxeShip {

	private WritableImage item;
	private int type;
	private int[] boatPosition;
	private int[] axePosition;
	private int[] coordinates;
	
	int row;
	int col;
	
	//items
	private static final int BOAT = 0;
	private static final int AXE = 1;
	
	private AxeShip(int type) {
		this.type = type;
	}
	
	//get current position of the axe and boat
	private int[] getItemPosition(){
		
		PlayState ps = new PlayState(null);
		coordinates = ps.getItemCoord();
		
		if(type == BOAT){
			row = boatPosition[0] = coordinates[2];
			col = boatPosition[1] = coordinates[3];
			
			return boatPosition;
			
		}else if(type == AXE){
			row = axePosition[0] = coordinates[0];
			col = axePosition[1] = coordinates[1];
			
			return axePosition;
		}else return null;
	}
	
	//updates the game on the new position of the axe and boat
	private void updateItemPosition(){
		String coords = Integer.toString(axePosition[0]) + "," + Integer.toString(axePosition[1]) + "," + Integer.toString(boatPosition[0]) + "," + Integer.toString(boatPosition[1]);
		WriteCoord.overwriteFile(coords,1);
	}
	
	//get the sprites
	private WritableImage getItem(){
		item = new ImageConversion(Content.ITEMS[row][col]).getWrImg();	
		return item;
	}
	
}
