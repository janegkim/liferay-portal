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

package com.liferay.portlet.calendar.service.http;

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.servlet.TunnelUtil;

import com.liferay.portlet.calendar.service.spring.CalEventServiceUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <a href="CalEventServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class CalEventServiceHttp {
	public static com.liferay.portlet.calendar.model.CalEvent addEvent(
		HttpPrincipal httpPrincipal, java.lang.String plid,
		java.lang.String title, java.lang.String description,
		int startDateMonth, int startDateDay, int startDateYear,
		int startDateHour, int startDateMinute, int endDateMonth,
		int endDateDay, int endDateYear, int durationHour, int durationMinute,
		boolean allDay, boolean timeZoneSensitive, java.lang.String type,
		boolean repeating, com.liferay.util.cal.Recurrence recurrence,
		java.lang.String remindBy, int firstReminder, int secondReminder,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		try {
			Object paramObj0 = plid;

			if (plid == null) {
				paramObj0 = new NullWrapper("java.lang.String");
			}

			Object paramObj1 = title;

			if (title == null) {
				paramObj1 = new NullWrapper("java.lang.String");
			}

			Object paramObj2 = description;

			if (description == null) {
				paramObj2 = new NullWrapper("java.lang.String");
			}

			Object paramObj3 = new IntegerWrapper(startDateMonth);
			Object paramObj4 = new IntegerWrapper(startDateDay);
			Object paramObj5 = new IntegerWrapper(startDateYear);
			Object paramObj6 = new IntegerWrapper(startDateHour);
			Object paramObj7 = new IntegerWrapper(startDateMinute);
			Object paramObj8 = new IntegerWrapper(endDateMonth);
			Object paramObj9 = new IntegerWrapper(endDateDay);
			Object paramObj10 = new IntegerWrapper(endDateYear);
			Object paramObj11 = new IntegerWrapper(durationHour);
			Object paramObj12 = new IntegerWrapper(durationMinute);
			Object paramObj13 = new BooleanWrapper(allDay);
			Object paramObj14 = new BooleanWrapper(timeZoneSensitive);
			Object paramObj15 = type;

			if (type == null) {
				paramObj15 = new NullWrapper("java.lang.String");
			}

			Object paramObj16 = new BooleanWrapper(repeating);
			Object paramObj17 = recurrence;

			if (recurrence == null) {
				paramObj17 = new NullWrapper("com.liferay.util.cal.Recurrence");
			}

			Object paramObj18 = remindBy;

			if (remindBy == null) {
				paramObj18 = new NullWrapper("java.lang.String");
			}

			Object paramObj19 = new IntegerWrapper(firstReminder);
			Object paramObj20 = new IntegerWrapper(secondReminder);
			Object paramObj21 = new BooleanWrapper(addCommunityPermissions);
			Object paramObj22 = new BooleanWrapper(addGuestPermissions);
			MethodWrapper methodWrapper = new MethodWrapper(CalEventServiceUtil.class.getName(),
					"addEvent",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
						paramObj10, paramObj11, paramObj12, paramObj13,
						paramObj14, paramObj15, paramObj16, paramObj17,
						paramObj18, paramObj19, paramObj20, paramObj21,
						paramObj22
					});
			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.PortalException) {
					throw (com.liferay.portal.PortalException)e;
				}

				if (e instanceof com.liferay.portal.SystemException) {
					throw (com.liferay.portal.SystemException)e;
				}

				throw new com.liferay.portal.SystemException(e);
			}

			return (com.liferay.portlet.calendar.model.CalEvent)returnObj;
		}
		catch (com.liferay.portal.SystemException se) {
			String stackTrace = StackTraceUtil.getStackTrace(se);
			_log.error(stackTrace);
			throw se;
		}
	}

	public static void deleteEvent(HttpPrincipal httpPrincipal,
		java.lang.String eventId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		try {
			Object paramObj0 = eventId;

			if (eventId == null) {
				paramObj0 = new NullWrapper("java.lang.String");
			}

			MethodWrapper methodWrapper = new MethodWrapper(CalEventServiceUtil.class.getName(),
					"deleteEvent", new Object[] { paramObj0 });

			try {
				TunnelUtil.invoke(httpPrincipal, methodWrapper);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.PortalException) {
					throw (com.liferay.portal.PortalException)e;
				}

				if (e instanceof com.liferay.portal.SystemException) {
					throw (com.liferay.portal.SystemException)e;
				}

				throw new com.liferay.portal.SystemException(e);
			}
		}
		catch (com.liferay.portal.SystemException se) {
			String stackTrace = StackTraceUtil.getStackTrace(se);
			_log.error(stackTrace);
			throw se;
		}
	}

	public static com.liferay.portlet.calendar.model.CalEvent getEvent(
		HttpPrincipal httpPrincipal, java.lang.String eventId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		try {
			Object paramObj0 = eventId;

			if (eventId == null) {
				paramObj0 = new NullWrapper("java.lang.String");
			}

			MethodWrapper methodWrapper = new MethodWrapper(CalEventServiceUtil.class.getName(),
					"getEvent", new Object[] { paramObj0 });
			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.PortalException) {
					throw (com.liferay.portal.PortalException)e;
				}

				if (e instanceof com.liferay.portal.SystemException) {
					throw (com.liferay.portal.SystemException)e;
				}

				throw new com.liferay.portal.SystemException(e);
			}

			return (com.liferay.portlet.calendar.model.CalEvent)returnObj;
		}
		catch (com.liferay.portal.SystemException se) {
			String stackTrace = StackTraceUtil.getStackTrace(se);
			_log.error(stackTrace);
			throw se;
		}
	}

	public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
		HttpPrincipal httpPrincipal, java.lang.String eventId,
		java.lang.String title, java.lang.String description,
		int startDateMonth, int startDateDay, int startDateYear,
		int startDateHour, int startDateMinute, int endDateMonth,
		int endDateDay, int endDateYear, int durationHour, int durationMinute,
		boolean allDay, boolean timeZoneSensitive, java.lang.String type,
		boolean repeating, com.liferay.util.cal.Recurrence recurrence,
		java.lang.String remindBy, int firstReminder, int secondReminder)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		try {
			Object paramObj0 = eventId;

			if (eventId == null) {
				paramObj0 = new NullWrapper("java.lang.String");
			}

			Object paramObj1 = title;

			if (title == null) {
				paramObj1 = new NullWrapper("java.lang.String");
			}

			Object paramObj2 = description;

			if (description == null) {
				paramObj2 = new NullWrapper("java.lang.String");
			}

			Object paramObj3 = new IntegerWrapper(startDateMonth);
			Object paramObj4 = new IntegerWrapper(startDateDay);
			Object paramObj5 = new IntegerWrapper(startDateYear);
			Object paramObj6 = new IntegerWrapper(startDateHour);
			Object paramObj7 = new IntegerWrapper(startDateMinute);
			Object paramObj8 = new IntegerWrapper(endDateMonth);
			Object paramObj9 = new IntegerWrapper(endDateDay);
			Object paramObj10 = new IntegerWrapper(endDateYear);
			Object paramObj11 = new IntegerWrapper(durationHour);
			Object paramObj12 = new IntegerWrapper(durationMinute);
			Object paramObj13 = new BooleanWrapper(allDay);
			Object paramObj14 = new BooleanWrapper(timeZoneSensitive);
			Object paramObj15 = type;

			if (type == null) {
				paramObj15 = new NullWrapper("java.lang.String");
			}

			Object paramObj16 = new BooleanWrapper(repeating);
			Object paramObj17 = recurrence;

			if (recurrence == null) {
				paramObj17 = new NullWrapper("com.liferay.util.cal.Recurrence");
			}

			Object paramObj18 = remindBy;

			if (remindBy == null) {
				paramObj18 = new NullWrapper("java.lang.String");
			}

			Object paramObj19 = new IntegerWrapper(firstReminder);
			Object paramObj20 = new IntegerWrapper(secondReminder);
			MethodWrapper methodWrapper = new MethodWrapper(CalEventServiceUtil.class.getName(),
					"updateEvent",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
						paramObj10, paramObj11, paramObj12, paramObj13,
						paramObj14, paramObj15, paramObj16, paramObj17,
						paramObj18, paramObj19, paramObj20
					});
			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.PortalException) {
					throw (com.liferay.portal.PortalException)e;
				}

				if (e instanceof com.liferay.portal.SystemException) {
					throw (com.liferay.portal.SystemException)e;
				}

				throw new com.liferay.portal.SystemException(e);
			}

			return (com.liferay.portlet.calendar.model.CalEvent)returnObj;
		}
		catch (com.liferay.portal.SystemException se) {
			String stackTrace = StackTraceUtil.getStackTrace(se);
			_log.error(stackTrace);
			throw se;
		}
	}

	private static Log _log = LogFactory.getLog(CalEventServiceHttp.class);
}