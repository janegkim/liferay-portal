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

package com.liferay.portlet.shopping.model;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portlet.shopping.NoSuchCouponException;
import com.liferay.portlet.shopping.service.spring.ShoppingCartLocalServiceUtil;
import com.liferay.portlet.shopping.service.spring.ShoppingCouponLocalServiceUtil;
import com.liferay.util.StringPool;
import com.liferay.util.StringUtil;
import com.liferay.util.Validator;

import java.util.Map;

/**
 * <a href="ShoppingCart.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public class ShoppingCart extends ShoppingCartModel {

	public ShoppingCart() {
	}

	public void addItemId(String itemId, String fields) {
		setItemIds(StringUtil.add(
			getItemIds(), itemId + fields, StringPool.COMMA, true));
	}

	public Map getItems() throws SystemException {
		return ShoppingCartLocalServiceUtil.getItems(
			getGroupId(), getItemIds());
	}

	public int getItemsSize() {
		return StringUtil.split(getItemIds()).length;
	}

	public ShoppingCoupon getCoupon() throws PortalException, SystemException {
		ShoppingCoupon coupon = null;

		if (Validator.isNotNull(getCouponIds())) {
			String couponId = StringUtil.split(getCouponIds())[0];

			try {
				coupon = ShoppingCouponLocalServiceUtil.getCoupon(couponId);
			}
			catch (NoSuchCouponException nsce) {
			}
		}

		return coupon;
	}

}