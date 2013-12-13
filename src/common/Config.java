package common;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

import java.io.File;

public class Config {

	private Configuration config;

	public int scrollItemID;
	public int writingDeskID;
	public int researchNotesID;

	public Config(File configFile) {
	 	config = new Configuration(configFile);
		loadGeneral();
		config.save();
	}

	private void loadGeneral() {
		Property prop;
		prop = config.get(Configuration.CATEGORY_ITEM, "Scroll", 8000);
		scrollItemID = prop.getInt();
		prop = config.get(Configuration.CATEGORY_ITEM, "Research Notes", 8001);
		researchNotesID = prop.getInt();
		prop = config.get(Configuration.CATEGORY_BLOCK, "Writing Desk", 2100);
		writingDeskID = prop.getInt();
	}
}
