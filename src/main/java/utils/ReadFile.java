package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import loggers.Loggers;


public class ReadFile {

	
	private String fileName;
	private List<String> list;
	BufferedReader reader;

	public ReadFile(String fileName) {
		this.fileName = fileName;
		reader = readerFile();
	}

	public String getFileName() {
		return fileName;
	}

	public List<String> getList(){
		return list;
	}
	
	private BufferedReader readerFile() {
		try {
			reader = new BufferedReader(new FileReader(getFileName()));
			generateList(reader);
		} catch (IOException e) {
			e.printStackTrace();
			Loggers.log("File not found ---> " + getFileName());
		}
		return reader;
	}

	private void generateList(BufferedReader reader) {
		list = new ArrayList<>();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Loggers.log("File not found ---> " + getFileName());
		}
	}
	
	public int getListSize() {
		return list.size();
	}
	
	public void closeResource() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
