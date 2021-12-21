package ui.languagePack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utils.FileLoaderWriter;

public class UILanguage{
	
	private FileLoaderWriter fileLoaderWriter = new FileLoaderWriter();
	private File languageFile = new File("./src/ui/languagePack/ITA.lan");

	private Map<String, String> language = new HashMap<>();
	
	public UILanguage() {
		realize();
	}
	public void setLanguageFile(File languageFile) {
		this.languageFile = languageFile;
	}
	
	public Map<String, String> getLanguage() {
		return language;
	}
	
	private void realize() {
		ArrayList<String> languageFileReaded = fileLoaderWriter.load(languageFile);
		for (int i = 0; i < languageFileReaded.size(); i++) {
			String[] keyEntry = languageFileReaded.get(i).replaceAll("\t", "").split("=", 2);
			language.put(keyEntry[0], keyEntry[1]);
		}
	}
}
