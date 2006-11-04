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

package com.liferay.portlet.documentlibrary.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.spring.hibernate.CustomSQLUtil;
import com.liferay.portal.spring.hibernate.HibernateUtil;
import com.liferay.util.StringUtil;
import com.liferay.util.dao.hibernate.QueryPos;
import com.liferay.util.dao.hibernate.QueryUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * <a href="DLFileEntryAndShortcutFinder.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class DLFileEntryAndShortcutFinder {

	public static String COUNT_BY_FOLDER_IDS =
		DLFileEntryAndShortcutFinder.class.getName() + ".countByFolderIds";

	public static String FIND_BY_FOLDER_IDS =
		DLFileEntryAndShortcutFinder.class.getName() + ".findByFolderIds";

	public static int countByFolderIds(List folderIds) throws SystemException {
		Session session = null;

		try {
			session = HibernateUtil.openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_FOLDER_IDS);

			sql = StringUtil.replace(
				sql, "[$FOLDER_ID$]", _getFolderIds(folderIds));

			SQLQuery q = session.createSQLQuery(sql);

			q.setCacheable(false);

			q.addScalar(HibernateUtil.getCountColumnName(), Hibernate.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			for (int i = 0; i < folderIds.size(); i++) {
				String folderId = (String)folderIds.get(i);

				qPos.add(folderId);
			}

			for (int i = 0; i < folderIds.size(); i++) {
				String folderId = (String)folderIds.get(i);

				qPos.add(folderId);
			}

			int count = 0;

			Iterator itr = q.list().iterator();

			while (itr.hasNext()) {
				Long l = (Long)itr.next();

				if (l != null) {
					count += l.intValue();
				}
			}

			return count;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	public static List findByFolderIds(List folderIds, int begin, int end)
		throws SystemException {

		Session session = null;

		try {
			session = HibernateUtil.openSession();

			String sql = CustomSQLUtil.get(FIND_BY_FOLDER_IDS);

			sql = StringUtil.replace(
				sql, "[$FOLDER_ID$]", _getFolderIds(folderIds));

			SQLQuery q = session.createSQLQuery(sql);

			q.setCacheable(false);

			q.addScalar("folderId", Hibernate.STRING);
			q.addScalar("name", Hibernate.STRING);
			q.addScalar("fileShortcutId", Hibernate.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			for (int i = 0; i < folderIds.size(); i++) {
				String folderId = (String)folderIds.get(i);

				qPos.add(folderId);
			}

			for (int i = 0; i < folderIds.size(); i++) {
				String folderId = (String)folderIds.get(i);

				qPos.add(folderId);
			}

			List list = new ArrayList();

			Iterator itr = QueryUtil.iterate(
				q, HibernateUtil.getDialect(), begin, end);

			while (itr.hasNext()) {
				Object[] array = (Object[])itr.next();

				String folderId = (String)array[0];
				String name = (String)array[1];
				long fileShortcutId = ((Long)array[2]).longValue();

				Object obj = null;

				if (fileShortcutId > 0) {
					obj = DLFileShortcutUtil.findByPrimaryKey(fileShortcutId);
				}
				else {
					obj = DLFileEntryUtil.findByPrimaryKey(
						new DLFileEntryPK(folderId, name));
				}

				list.add(obj);
			}

			return list;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}

	private static String _getFolderIds(List folderIds) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < folderIds.size(); i++) {
			sb.append("folderId = ? ");

			if ((i + 1) != folderIds.size()) {
				sb.append("OR ");
			}
		}

		return sb.toString();
	}

}