package com.neet.DiamondHunter.MapViewer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.TilePane;

public class MapViewController implements Initializable {
	
	@FXML
	private Canvas mvCanvas;
	@FXML
	private TilePane tileMapping;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MapPane mp = new MapPane();
		mvCanvas.relocate(60, 90);
		mvCanvas.setWidth((double) (MapPane.WIDTH));
		mvCanvas.setHeight((double) (MapPane.HEIGHT));
		mvCanvas.getGraphicsContext2D().drawImage(mp.getCanvas(), 0, 0);
		
		tileMapping.relocate(mvCanvas.getLayoutX() + 1, mvCanvas.getLayoutY() - 2);
		tileMapping.setPrefSize((double) (mp.getNumCols() * mp.getTileSize()), (double) (mp.getNumCols() * mp.getTileSize()));
		tileMapping.setPrefTileWidth((double) (mp.getTileSize()));
		tileMapping.setPrefTileHeight((double) (mp.getTileSize()));
		tileMapping.setPrefRows(mp.getNumRows());
		tileMapping.setPrefColumns(mp.getNumCols());
	}
}
