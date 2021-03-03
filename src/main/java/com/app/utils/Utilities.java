package com.app.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.app.config.Constants;

public class Utilities {
	/**
	 * Split lines by hypen attribute
	 * 
	 * @param lines
	 * @return Map<String, String[]> key value pair
	 */
	public static Map<String, String[]> SplitByHypen(List<String> lines) {
		Map<String, String[]> store = new LinkedHashMap<String, String[]>();
		for (String line : lines) {
			String[] keyValue = line.split("–");
			if (keyValue.length <= 1) {
				System.out.println("line contains not values");
				store.put(keyValue[0], new String[1]);
			} else
				store.put(keyValue[0], keyValue[1].trim().replaceAll(", ", ",").split(","));
		}
		return store;
	}

	/**
	 * Get all text files from resource folder of current project directory
	 * 
	 * @return Arraylist<String>
	 */
	public static ArrayList<String> getAllTextFiles() {
		String FilePath = System.getProperty("user.dir") + Constants.FILESPATH;
		File f = new File(FilePath);
		ArrayList<String> validfiles = new ArrayList<String>();
		for (File pathname : f.listFiles()) {
			if (pathname.isFile() && pathname.toString().endsWith(".txt")) {
				validfiles.add(pathname.toString());
			}
		}
		if (validfiles.size() == 0) {
			System.out.println("No file with .txt extension exist in resource directory");
			System.exit(0);
		}
		return validfiles;
	}
	
	/**
	 * Get all text file from resource folder of current project directory
	 * 
	 * @return Arraylist<String>
	 */

	public static ArrayList<String> getAllTextFiles(String fileExtension) {
		String FilePath = System.getProperty("user.dir") + Constants.FILEPATH;
		File f = new File(FilePath);
		ArrayList<String> validfiles = new ArrayList<String>();
		for (File pathname : f.listFiles()) {
			if (pathname.isFile() && pathname.toString().endsWith(fileExtension)) {
				validfiles.add(pathname.toString());
			}
		}
		if (validfiles.size() == 0) {
			System.out.println("No file with .txt extension exist in resource directory");
			System.exit(0);
		}
		return validfiles;
	}

	/**
	 * Read all Files in the folder
	 * @param filePath
	 * @return List<String>
	 * @throws Exception
	 */
	public static List<String> ReadFiles(String filePath) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("IO exception occurs");
			e.printStackTrace();
		}
		return lines;
	}
	/**
	 * Read File in the folder
	 * @param filePath
	 * @return List<String>
	 * @throws Exception
	 */
	public static List<String> ReadFile(String fileName) {
		List<String> lines = null;
		String FilePath = System.getProperty("user.dir") + fileName;
		File f = new File(FilePath);
		try {
			lines = Files.readAllLines(Paths.get(FilePath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("IO exception occurs");
			e.printStackTrace();
		}
		return lines;
	}
}
