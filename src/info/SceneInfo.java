package info;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SceneInfo
{
	/**
	 * What scene the info represents.
	 */
	int label;
	
	/**
	 * What is to be displayed to the player.
	 */
	BufferedImage image;
	
	/**
	 * The set of links between scenes.
	 */
	ArrayList<SceneLink> links;
	
	public SceneInfo(int label, BufferedImage image, ArrayList<SceneLink> links)
	{
		this.label = label;
		this.image = image;
		this.links = links;
	}
	
	/**
	 * Function to get a link to another scene from this scene given the current state of the player.
	 * @param p
	 * @param inventory
	 * @return
	 */
	public SceneLink getLink(PlayerInfo p)
	{
		for(SceneLink link : links)
		{
			if(link.linkValid(p.getLastClickPos(), p.getInventory()))//Only one link should be valid at a time.
				return link;
		}
		return null;
	}

	////////////////////////
	//Getters and Setters://
	//********************//
	public int getLabel()
	{
		return label;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
}
