package com.app.test;

import static com.app.utils.Utilities.ReadFile;
import static com.app.utils.Utilities.SplitByHypen;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.app.config.Constants;

public class StringTest {
	
	public static void main(String[] args) throws Exception {
			List<String> lines = ReadFile(Constants.FILEPATH);
			Map<String, String[]> values = SplitByHypen(lines);
			for (Entry<String, String[]> Keyvalue : values.entrySet()) {
				System.out.println(Keyvalue.getKey());
				for (String string : Keyvalue.getValue()) {
					System.out.println(string);
				}
			}
		}
	}

