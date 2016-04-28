package utility;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import info.ItemMod;
import info.SceneInfo;
import info.SceneLink;

public class SceneBuilder {
	
	/**
	 * The subdirectory in which the images will be stored.
	 */
	private static final String SUBDIRECTORY = "";
	/**
	 * The path from the relative base where the builder file will be stored.
	 */
	private static final String BUILDER_FILEPATH = "";
	
	/**
	 * The building function.
	 * 
	 * Takes XML of the form:
	 * <builder>
	 * 	<scene>
	 * 		<label>
	 * 			[Integer Value of the label of the scene.]
	 * 		</label>
	 * 		<link>
	 * 			<requirements>
	 * 				[String of form "num,num,num": requirement numbers separated by commas.]
	 * 			</requirements>
	 * 			<rect>
	 * 				[String of form "cornerX,cornerY,width,height": rectangle values by these numbers.]
	 * 			</rect>
	 * 			<mod>
	 * 				[String of name of ItemMod enum (ADD, DELETE, ect...). This should be empty if there is no mod.
	 * 			</mod>
	 * 			<modslot>
	 * 				[Integer value of which item slot is modified.]
	 * 			</modslot>
	 * 			<linkLabel>
	 * 				[Integer value of the label of the image that this links to.
	 * 			</linkLabel>
	 * 		</link>
	 * 		<link>
	 * 		...
	 * 		</link>
	 * 	</scene>
	 * 	<scene>
	 * 		...
	 * 	</scene>
	 * </builder>
	 * 
	 * @return An arraylist of scene information. This acts as the game map.
	 */
	public static ArrayList<SceneInfo> build()
	{
		//Set up relative pathing:
		String basePath = new File("").getAbsolutePath();
		basePath = basePath.concat("\\");
		
		try{
			//Open the file:
			File inputFile = new File(basePath + BUILDER_FILEPATH);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = (Document) dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();;
	        
	        //Read through the children:
	        NodeList sceneNodes = doc.getElementsByTagName("scene");
	        ArrayList<SceneInfo> scenes = new ArrayList<SceneInfo>();
	        for(int i = 0; i < sceneNodes.getLength(); i++)
	        {
	        	Node scene = sceneNodes.item(i);
	        	System.out.println(scene);
	        }
		}
		catch(Exception e)
		{
			System.out.println("Failed to load document:");
			e.printStackTrace();
		}
		
		
		//public SceneInfo(int label, BufferedImage image, ArrayList<SceneLink> links)
		//public SceneLink(int[] inventoryReqs, Rectangle clickRegion, ItemMod mod, int modSlot, int linkLabel)
		
		return null;
	}
}
