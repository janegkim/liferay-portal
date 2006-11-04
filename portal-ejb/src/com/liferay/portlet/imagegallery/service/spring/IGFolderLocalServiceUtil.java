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

package com.liferay.portlet.imagegallery.service.spring;

/**
 * <a href="IGFolderLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class IGFolderLocalServiceUtil {
	public static com.liferay.portlet.imagegallery.model.IGFolder addFolder(
		java.lang.String userId, java.lang.String plid,
		java.lang.String parentFolderId, java.lang.String name,
		java.lang.String description, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.addFolder(userId, plid, parentFolderId,
			name, description, addCommunityPermissions, addGuestPermissions);
	}

	public static void addFolderResources(java.lang.String folderId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();
		igFolderLocalService.addFolderResources(folderId,
			addCommunityPermissions, addGuestPermissions);
	}

	public static void addFolderResources(
		com.liferay.portlet.imagegallery.model.IGFolder folder,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();
		igFolderLocalService.addFolderResources(folder,
			addCommunityPermissions, addGuestPermissions);
	}

	public static void deleteFolder(java.lang.String folderId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();
		igFolderLocalService.deleteFolder(folderId);
	}

	public static void deleteFolder(
		com.liferay.portlet.imagegallery.model.IGFolder folder)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();
		igFolderLocalService.deleteFolder(folder);
	}

	public static void deleteFolders(java.lang.String groupId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();
		igFolderLocalService.deleteFolders(groupId);
	}

	public static com.liferay.portlet.imagegallery.model.IGFolder getFolder(
		java.lang.String folderId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.getFolder(folderId);
	}

	public static java.util.List getFolders(java.lang.String groupId)
		throws com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.getFolders(groupId);
	}

	public static java.util.List getFolders(java.lang.String groupId,
		java.lang.String parentFolderId)
		throws com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.getFolders(groupId, parentFolderId);
	}

	public static java.util.List getFolders(java.lang.String groupId,
		java.lang.String parentFolderId, int begin, int end)
		throws com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.getFolders(groupId, parentFolderId, begin,
			end);
	}

	public static int getFoldersCount(java.lang.String groupId,
		java.lang.String parentFolderId)
		throws com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.getFoldersCount(groupId, parentFolderId);
	}

	public static void getSubfolderIds(java.util.List folderIds,
		java.lang.String groupId, java.lang.String folderId)
		throws com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();
		igFolderLocalService.getSubfolderIds(folderIds, groupId, folderId);
	}

	public static com.liferay.portlet.imagegallery.model.IGFolder updateFolder(
		java.lang.String folderId, java.lang.String parentFolderId,
		java.lang.String name, java.lang.String description,
		boolean mergeWithParentFolder)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		IGFolderLocalService igFolderLocalService = IGFolderLocalServiceFactory.getService();

		return igFolderLocalService.updateFolder(folderId, parentFolderId,
			name, description, mergeWithParentFolder);
	}
}