package com.wolfram.mexprparser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MExprParserUtilities {
	
	public static int encodedStringLength() {
		return 8;
	}
	
	public static boolean isEncodedString(String str) {
		return "(*!1A!*)".equals(str) || "(*!1B!*)".equals(str)
				|| "(*!1C!*)".equals(str) || "(*!1D!*)".equals(str)
				|| "(*!1H!*)".equals(str) || "(*!1I!*)".equals(str)
				|| "(*!1N!*)".equals(str) || "(*!1O!*)".equals(str);
	}

	public static Reader checkReaderForEncoding(Reader reader) {
		int encodedLen = encodedStringLength();
		if (reader.markSupported()) {
			int len = encodedLen;
			try {
				reader.mark(len + 1);
				char[] cbuf = new char[len];
				int got = reader.read(cbuf);
				String test = new String(cbuf);
				if (got == len
						&& isEncodedString(new String(cbuf))) {
					reader = new StringReader(test);
				} else {
					reader.reset();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return reader;
	}
}
