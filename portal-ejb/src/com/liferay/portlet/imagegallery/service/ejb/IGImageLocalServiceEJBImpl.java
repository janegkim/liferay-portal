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

package com.liferay.portlet.imagegallery.service.ejb;

import com.liferay.portal.spring.util.SpringUtil;

import com.liferay.portlet.imagegallery.service.spring.IGImageLocalService;

import org.springframework.context.ApplicationContext;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * <a href="IGImageLocalServiceEJBImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class IGImageLocalServiceEJBImpl implements IGImageLocalService,
	SessionBean {
	public static final String CLASS_NAME = IGImageLocalService.class.getName() +
		".transaction";

	public static IGImageLocalService getService() {
		ApplicationContext ctx = SpringUtil.getContext();

		return (IGImageLocalService)ctx.getBean(CLASS_NAME);
	}

	public com.liferay.portlet.imagegallery.model.IGImage addImage(
		java.lang.String userId, java.lang.String folderId,
		java.lang.String description, java.io.File file,
		java.lang.String contentType, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return getService().addImage(userId, folderId, description, file,
			contentType, addCommunityPermissions, addGuestPermissions);
	}

	public void addImageResources(java.lang.String folderId,
		java.lang.String imageId, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		getService().addImageResources(folderId, imageId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addImageResources(
		com.liferay.portlet.imagegallery.model.IGFolder folder,
		com.liferay.portlet.imagegallery.model.IGImage image,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		getService().addImageResources(folder, image, addCommunityPermissions,
			addGuestPermissions);
	}

	public void deleteImage(java.lang.String companyId, java.lang.String imageId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		getService().deleteImage(companyId, imageId);
	}

	public void deleteImage(
		com.liferay.portlet.imagegallery.model.IGImage image)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		getService().deleteImage(image);
	}

	public void deleteImages(java.lang.String folderId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		getService().deleteImages(folderId);
	}

	public int getFoldersImagesCount(java.util.List folderIds)
		throws com.liferay.portal.SystemException {
		return getService().getFoldersImagesCount(folderIds);
	}

	public java.util.List getGroupImages(java.lang.String groupId, int begin,
		int end) throws com.liferay.portal.SystemException {
		return getService().getGroupImages(groupId, begin, end);
	}

	public java.util.List getGroupImages(java.lang.String groupId,
		java.lang.String userId, int begin, int end)
		throws com.liferay.portal.SystemException {
		return getService().getGroupImages(groupId, userId, begin, end);
	}

	public int getGroupImagesCount(java.lang.String groupId)
		throws com.liferay.portal.SystemException {
		return getService().getGroupImagesCount(groupId);
	}

	public int getGroupImagesCount(java.lang.String groupId,
		java.lang.String userId) throws com.liferay.portal.SystemException {
		return getService().getGroupImagesCount(groupId, userId);
	}

	public com.liferay.portlet.imagegallery.model.IGImage getImage(
		java.lang.String companyId, java.lang.String imageId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return getService().getImage(companyId, imageId);
	}

	public java.util.List getImages(java.lang.String folderId)
		throws com.liferay.portal.SystemException {
		return getService().getImages(folderId);
	}

	public java.util.List getImages(java.lang.String folderId, int begin,
		int end) throws com.liferay.portal.SystemException {
		return getService().getImages(folderId, begin, end);
	}

	public java.util.List getImages(java.lang.String folderId, int begin,
		int end, com.liferay.util.dao.hibernate.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getService().getImages(folderId, begin, end, obc);
	}

	public int getImagesCount(java.lang.String folderId)
		throws com.liferay.portal.SystemException {
		return getService().getImagesCount(folderId);
	}

	public com.liferay.portlet.imagegallery.model.IGImage updateImage(
		java.lang.String companyId, java.lang.String imageId,
		java.lang.String folderId, java.lang.String description,
		java.io.File file, java.lang.String contentType)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return getService().updateImage(companyId, imageId, folderId,
			description, file, contentType);
	}

	public void ejbCreate() throws CreateException {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public SessionContext getSessionContext() {
		return _sc;
	}

	public void setSessionContext(SessionContext sc) {
		_sc = sc;
	}

	private SessionContext _sc;
}