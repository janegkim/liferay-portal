<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
boolean autoFocus = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-localized:autoFocus"));
boolean autoSize = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-localized:autoSize"));
Locale[] availableLocales = (Locale[])request.getAttribute("liferay-ui:input-localized:availableLocales");
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-localized:cssClass"));
String defaultLanguageId = (String)request.getAttribute("liferay-ui:input-localized:defaultLanguageId");
boolean disabled = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-localized:disabled"));
String id = (String)request.getAttribute("liferay-ui:input-localized:id");
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("liferay-ui:input-localized:dynamicAttributes");
boolean ignoreRequestValue = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-localized:ignoreRequestValue"));
String languageId = (String)request.getAttribute("liferay-ui:input-localized:languageId");
String maxLength = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-localized:maxLength"));
String name = (String)request.getAttribute("liferay-ui:input-localized:name");
String xml = (String)request.getAttribute("liferay-ui:input-localized:xml");
String type = (String)request.getAttribute("liferay-ui:input-localized:type");

Locale defaultLocale = null;

if (Validator.isNotNull(defaultLanguageId)) {
	defaultLocale = LocaleUtil.fromLanguageId(defaultLanguageId);
}
else {
	defaultLocale = LocaleUtil.getDefault();
	defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);
}

String mainLanguageId = defaultLanguageId;

if (Validator.isNotNull(languageId)) {
	mainLanguageId = languageId;
}

Locale mainLocale = LocaleUtil.fromLanguageId(mainLanguageId);

String mainLanguageDir = LanguageUtil.get(mainLocale, "lang.dir");

String mainLanguageValue = LocalizationUtil.getLocalization(xml, mainLanguageId, false);

if (!ignoreRequestValue) {
	mainLanguageValue = ParamUtil.getString(request, name + StringPool.UNDERLINE + mainLanguageId, mainLanguageValue);
}

if (Validator.isNull(mainLanguageValue)) {
	mainLanguageValue = LocalizationUtil.getLocalization(xml, defaultLanguageId, true);
}

String fieldSuffix = StringPool.BLANK;

if ((availableLocales.length > 1) && !Validator.isNull(languageId)) {
	fieldSuffix = StringPool.UNDERLINE + mainLanguageId;
}

List<String> languageIds = new ArrayList<String>();
%>

<span class="input-localized input-localized-<%= type %>" id="<portlet:namespace /><%= id %>BoundingBox">
	<c:choose>
		<c:when test='<%= type.equals("editor") %>'>

			<%
			String fieldName = HtmlUtil.escapeAttribute(name + fieldSuffix);
			%>

			<liferay-ui:input-editor
				cssClass='<%= \"language-value \" + cssClass %>'
				editorImpl="ckeditor"
				initMethod='<%= fieldName + \"InitEditor\" %>'
				name="<%= fieldName %>"
				onBlurMethod='<%= fieldName + \"OnBlurEditor\" %>'
				onChangeMethod='<%= fieldName + \"OnChangeEditor\" %>'
				onFocusMethod='<%= fieldName + \"OnFocusEditor\" %>'
				toolbarSet="simple"
			/>

			<aui:script>
				function <portlet:namespace /><%= fieldName %>InitEditor() {
					return "<%= UnicodeFormatter.toString(mainLanguageValue) %>";
				}

				function <portlet:namespace /><%= fieldName %>OnBlurEditor() {
					Liferay.component('<portlet:namespace /><%= fieldName %>').blur();
				}

				function <portlet:namespace /><%= fieldName %>OnChangeEditor() {
					var inputLocalized = Liferay.component('<portlet:namespace /><%= fieldName %>');

					var editor = window.<portlet:namespace /><%= fieldName %>;

					inputLocalized.updateInputLanguage(editor.getHTML());
				}

				function <portlet:namespace /><%= fieldName %>OnFocusEditor() {
					Liferay.component('<portlet:namespace /><%= fieldName %>').focus();
				}
			</aui:script>

			<aui:script use="aui-base">
				A.all('#<portlet:namespace /><%= id %>ContentBox .palette-item-inner').on(
					'click',
					function() {
						window.<portlet:namespace /><%= fieldName %>.focus();
					}
				);
			</aui:script>
		</c:when>
		<c:when test='<%= type.equals("input") %>'>
			<input class="language-value <%= cssClass %>" dir="<%= mainLanguageDir %>" <%= disabled ? "disabled=\"disabled\"" : "" %> id="<portlet:namespace /><%= HtmlUtil.escapeAttribute(id + fieldSuffix) %>" name="<portlet:namespace /><%= HtmlUtil.escapeAttribute(name + fieldSuffix) %>" type="text" value="<%= HtmlUtil.escapeAttribute(mainLanguageValue) %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %> />
		</c:when>
		<c:when test='<%= type.equals("textarea") %>'>
			<textarea class="language-value <%= cssClass %>" dir="<%= mainLanguageDir %>" <%= disabled ? "disabled=\"disabled\"" : "" %> id="<portlet:namespace /><%= HtmlUtil.escapeAttribute(id + fieldSuffix) %>" name="<portlet:namespace /><%= HtmlUtil.escapeAttribute(name + fieldSuffix) %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>><%= HtmlUtil.escape(mainLanguageValue) %></textarea>

			<c:if test="<%= autoSize %>">
				<aui:script use="aui-autosize-deprecated">
					A.one('#<portlet:namespace /><%= HtmlUtil.escapeJS(id + fieldSuffix) %>').plug(A.Plugin.Autosize);
				</aui:script>
			</c:if>
		</c:when>
	</c:choose>

	<c:if test="<%= autoFocus %>">
		<aui:script>
			Liferay.Util.focusFormField('#<portlet:namespace /><%= HtmlUtil.escapeAttribute(id + fieldSuffix) %>');
		</aui:script>
	</c:if>

	<c:if test="<%= (availableLocales.length > 1) && Validator.isNull(languageId) %>">

		<%
		languageIds.add(defaultLanguageId);

		if (Validator.isNotNull(xml)) {
			for (int i = 0; i < availableLocales.length; i++) {
				String curLanguageId = LocaleUtil.toLanguageId(availableLocales[i]);

				if (curLanguageId.equals(defaultLanguageId)) {
					continue;
				}

				String languageValue = LocalizationUtil.getLocalization(xml, curLanguageId, false);

				if (Validator.isNotNull(languageValue) || (!ignoreRequestValue && (request.getParameter(name + StringPool.UNDERLINE + curLanguageId) != null))) {
					languageIds.add(curLanguageId);
				}
			}
		}

		for (int i = 0; i < languageIds.size(); i++) {
			String curLanguageId = languageIds.get(i);

			Locale curLocale = LocaleUtil.fromLanguageId(curLanguageId);

			String curLanguageDir = LanguageUtil.get(curLocale, "lang.dir");

			String languageValue = StringPool.BLANK;

			if (Validator.isNotNull(xml)) {
				languageValue = LocalizationUtil.getLocalization(xml, curLanguageId, false);
			}

			if (!ignoreRequestValue) {
				languageValue = ParamUtil.getString(request, name + StringPool.UNDERLINE + curLanguageId, languageValue);
			}
		%>

			<aui:input dir="<%= curLanguageDir %>" disabled="<%= disabled %>" id="<%= HtmlUtil.escapeAttribute(id + StringPool.UNDERLINE + curLanguageId) %>" name="<%= HtmlUtil.escapeAttribute(name + StringPool.UNDERLINE + curLanguageId) %>" type="hidden" value="<%= languageValue %>" />

		<%
		}
		%>

	</c:if>

	<div class="input-localized-content" id="<portlet:namespace /><%= id %>ContentBox">
		<table class="palette-container">
			<tr class="palette-items-container">

				<%
				LinkedHashSet<String> uniqueLanguageIds = new LinkedHashSet<String>();

				uniqueLanguageIds.add(defaultLanguageId);

				for (int i = 0; i < availableLocales.length; i++) {
					String curLanguageId = LocaleUtil.toLanguageId(availableLocales[i]);

					uniqueLanguageIds.add(curLanguageId);
				}

				int index = 0;

				for (String curLanguageId : uniqueLanguageIds) {
					String itemCssClass = "palette-item";

					if (index == 0) {
						itemCssClass += " palette-item-selected";
					}

					if (defaultLanguageId.equals(curLanguageId)) {
						itemCssClass += " lfr-input-localized-default";
					}

					if (languageIds.contains(curLanguageId)) {
						itemCssClass += " lfr-input-localized";
					}
				%>

					<td class="palette-item <%= itemCssClass %>" data-index="<%= index++ %>" data-value="<%= curLanguageId %>">
						<a class="palette-item-inner" href="javascript:void(0);">
							<img class="lfr-input-localized-flag" data-languageid="<%= curLanguageId %>" src="<%= themeDisplay.getPathThemeImages() %>/language/<%= curLanguageId %>.png" />
							<div class="lfr-input-localized-state"></div>
						</a>
					</td>

				<%
				}
				%>

			</tr>
		</table>
	</div>
</span>

<c:if test="<%= Validator.isNotNull(maxLength) %>">
	<aui:script use="aui-char-counter">
		new A.CharCounter(
			{
				input: '#<portlet:namespace /><%= HtmlUtil.escapeJS(id + fieldSuffix) %>',
				maxLength: <%= maxLength %>
			}
		);
	</aui:script>
</c:if>

<c:if test="<%= (availableLocales.length > 1) && Validator.isNull(languageId) %>">
	<aui:script use="liferay-input-localized">
		var defaultLanguageId = themeDisplay.getDefaultLanguageId();

		var available = {};

		<%
		for (Locale availableLocale : availableLocales) {
			String availableLanguageId = LocaleUtil.toLanguageId(availableLocale);
		%>

			available['<%= availableLanguageId %>'] = '<%= availableLocale.getDisplayName(locale) %>';

		<%
		}
		%>

		var availableLanguageIds = A.Array.dedupe(
			[defaultLanguageId].concat(A.Object.keys(available))
		);

		Liferay.InputLocalized.register(
			'<portlet:namespace /><%= HtmlUtil.escapeJS(id + fieldSuffix) %>',
			{
				boundingBox: '#<portlet:namespace /><%= id %>BoundingBox',
				columns: 20,
				contentBox: '#<portlet:namespace /><%= id %>ContentBox',

				<c:if test='<%= type.equals("editor") %>'>
					editor: window.<portlet:namespace /><%= name + fieldSuffix %>,
				</c:if>

				inputNamespace: '<portlet:namespace /><%= id + StringPool.UNDERLINE %>',
				inputPlaceholder: '#<portlet:namespace /><%= HtmlUtil.escapeJS(id + fieldSuffix) %>',
				items: availableLanguageIds,
				lazy: <%= !type.equals("editor") %>,
				toggleSelection: false,
				translatedLanguages: '<%= StringUtil.merge(languageIds) %>'
			}
		);
	</aui:script>
</c:if>