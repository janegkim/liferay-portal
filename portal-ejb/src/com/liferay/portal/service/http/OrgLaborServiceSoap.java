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

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.spring.OrgLaborServiceUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.RemoteException;

/**
 * <a href="OrgLaborServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class OrgLaborServiceSoap {
	public static com.liferay.portal.model.OrgLaborModel addOrgLabor(
		java.lang.String organizationId, java.lang.String typeId, int sunOpen,
		int sunClose, int monOpen, int monClose, int tueOpen, int tueClose,
		int wedOpen, int wedClose, int thuOpen, int thuClose, int friOpen,
		int friClose, int satOpen, int satClose) throws RemoteException {
		try {
			com.liferay.portal.model.OrgLabor returnValue = OrgLaborServiceUtil.addOrgLabor(organizationId,
					typeId, sunOpen, sunClose, monOpen, monClose, tueOpen,
					tueClose, wedOpen, wedClose, thuOpen, thuClose, friOpen,
					friClose, satOpen, satClose);

			return returnValue;
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static void deleteOrgLabor(java.lang.String orgLaborId)
		throws RemoteException {
		try {
			OrgLaborServiceUtil.deleteOrgLabor(orgLaborId);
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static com.liferay.portal.model.OrgLaborModel getOrgLabor(
		java.lang.String orgLaborId) throws RemoteException {
		try {
			com.liferay.portal.model.OrgLabor returnValue = OrgLaborServiceUtil.getOrgLabor(orgLaborId);

			return returnValue;
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static com.liferay.portal.model.OrgLaborModel[] getOrgLabors(
		java.lang.String organizationId) throws RemoteException {
		try {
			java.util.List returnValue = OrgLaborServiceUtil.getOrgLabors(organizationId);

			return (com.liferay.portal.model.OrgLabor[])returnValue.toArray(new com.liferay.portal.model.OrgLabor[0]);
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	public static com.liferay.portal.model.OrgLaborModel updateOrgLabor(
		java.lang.String orgLaborId, int sunOpen, int sunClose, int monOpen,
		int monClose, int tueOpen, int tueClose, int wedOpen, int wedClose,
		int thuOpen, int thuClose, int friOpen, int friClose, int satOpen,
		int satClose) throws RemoteException {
		try {
			com.liferay.portal.model.OrgLabor returnValue = OrgLaborServiceUtil.updateOrgLabor(orgLaborId,
					sunOpen, sunClose, monOpen, monClose, tueOpen, tueClose,
					wedOpen, wedClose, thuOpen, thuClose, friOpen, friClose,
					satOpen, satClose);

			return returnValue;
		}
		catch (Exception e) {
			String stackTrace = StackTraceUtil.getStackTrace(e);
			_log.error(stackTrace);
			throw new RemoteException(stackTrace);
		}
	}

	private static Log _log = LogFactory.getLog(OrgLaborServiceSoap.class);
}