/**
 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.util;

import com.liferay.util.CollectionFactory;
import com.liferay.util.StringUtil;

import java.io.IOException;

import java.util.Map;

/**
 * <a href="ContentUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class ContentUtil {

	public static String get(String location) {
		return _instance._get(location);
	}

	private ContentUtil() {
		_contentPool = CollectionFactory.getHashMap();
	}

	private String _get(String location) {
		String content = (String)_contentPool.get(location);

		if (content == null) {
			try {
				content =
					StringUtil.read(getClass().getClassLoader(), location);

				_put(location, content);
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		return content;
	}

	private void _put(String location, String content) {
		_contentPool.put(location, content);
	}

	private static ContentUtil _instance = new ContentUtil();

	private Map _contentPool;

}