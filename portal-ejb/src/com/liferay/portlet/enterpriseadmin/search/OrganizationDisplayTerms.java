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

package com.liferay.portlet.enterpriseadmin.search;

import com.liferay.util.ParamUtil;
import com.liferay.util.dao.search.DisplayTerms;

import javax.portlet.RenderRequest;

/**
 * <a href="OrganizationDisplayTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class OrganizationDisplayTerms extends DisplayTerms {

	public static final String NAME = "name";

	public static final String STREET = "street";

	public static final String CITY = "city";

	public static final String ZIP = "zip";

	public static final String COUNTRY_ID = "countryId";

	public static final String REGION_ID = "regionId";

	public static final String PARENT_ORGANIZATION_ID = "parentOrganizationId";

	public OrganizationDisplayTerms(RenderRequest req) {
		super(req);

		name = ParamUtil.getString(req, NAME);
		street = ParamUtil.getString(req, STREET);
		city = ParamUtil.getString(req, CITY);
		zip = ParamUtil.getString(req, ZIP);
		regionId = ParamUtil.getString(req, REGION_ID);
		countryId = ParamUtil.getString(req, COUNTRY_ID);
		parentOrganizationId = ParamUtil.getString(req, PARENT_ORGANIZATION_ID);
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getRegionId() {
		return regionId;
	}

	public String getCountryId() {
		return countryId;
	}

	public String getParentOrganizationId() {
		return parentOrganizationId;
	}

	protected String name;
	protected String street;
	protected String city;
	protected String zip;
	protected String regionId;
	protected String countryId;
	protected String parentOrganizationId;

}