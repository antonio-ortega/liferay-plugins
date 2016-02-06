/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.testblob.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.testblob.model.TestBlobEntry;
import com.liferay.testblob.model.TestBlobEntryBlobFieldBlobModel;
import com.liferay.testblob.model.TestBlobEntryModel;
import com.liferay.testblob.service.TestBlobEntryLocalServiceUtil;

import java.io.Serializable;

import java.sql.Blob;
import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TestBlobEntry service. Represents a row in the &quot;TestBlob_TestBlobEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TestBlobEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TestBlobEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestBlobEntryImpl
 * @see TestBlobEntry
 * @see TestBlobEntryModel
 * @generated
 */
@ProviderType
public class TestBlobEntryModelImpl extends BaseModelImpl<TestBlobEntry>
	implements TestBlobEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a test blob entry model instance should use the {@link TestBlobEntry} interface instead.
	 */
	public static final String TABLE_NAME = "TestBlob_TestBlobEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "testBlobEntryId", Types.BIGINT },
			{ "blobField", Types.BLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("testBlobEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("blobField", Types.BLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table TestBlob_TestBlobEntry (uuid_ VARCHAR(75) null,testBlobEntryId LONG not null primary key,blobField BLOB)";
	public static final String TABLE_SQL_DROP = "drop table TestBlob_TestBlobEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY testBlobEntry.testBlobEntryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TestBlob_TestBlobEntry.testBlobEntryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.testblob.model.TestBlobEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.testblob.model.TestBlobEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.testblob.model.TestBlobEntry"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long TESTBLOBENTRYID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.testblob.model.TestBlobEntry"));

	public TestBlobEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _testBlobEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTestBlobEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testBlobEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TestBlobEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TestBlobEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("testBlobEntryId", getTestBlobEntryId());
		attributes.put("blobField", getBlobField());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long testBlobEntryId = (Long)attributes.get("testBlobEntryId");

		if (testBlobEntryId != null) {
			setTestBlobEntryId(testBlobEntryId);
		}

		Blob blobField = (Blob)attributes.get("blobField");

		if (blobField != null) {
			setBlobField(blobField);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getTestBlobEntryId() {
		return _testBlobEntryId;
	}

	@Override
	public void setTestBlobEntryId(long testBlobEntryId) {
		_testBlobEntryId = testBlobEntryId;
	}

	@Override
	public Blob getBlobField() {
		if (_blobFieldBlobModel == null) {
			try {
				_blobFieldBlobModel = TestBlobEntryLocalServiceUtil.getBlobFieldBlobModel(getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_blobFieldBlobModel != null) {
			blob = _blobFieldBlobModel.getBlobFieldBlob();
		}

		return blob;
	}

	@Override
	public void setBlobField(Blob blobField) {
		if (_blobFieldBlobModel == null) {
			_blobFieldBlobModel = new TestBlobEntryBlobFieldBlobModel(getPrimaryKey(),
					blobField);
		}
		else {
			_blobFieldBlobModel.setBlobFieldBlob(blobField);
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TestBlobEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TestBlobEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TestBlobEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TestBlobEntryImpl testBlobEntryImpl = new TestBlobEntryImpl();

		testBlobEntryImpl.setUuid(getUuid());
		testBlobEntryImpl.setTestBlobEntryId(getTestBlobEntryId());

		testBlobEntryImpl.resetOriginalValues();

		return testBlobEntryImpl;
	}

	@Override
	public int compareTo(TestBlobEntry testBlobEntry) {
		long primaryKey = testBlobEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestBlobEntry)) {
			return false;
		}

		TestBlobEntry testBlobEntry = (TestBlobEntry)obj;

		long primaryKey = testBlobEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TestBlobEntryModelImpl testBlobEntryModelImpl = this;

		testBlobEntryModelImpl._originalUuid = testBlobEntryModelImpl._uuid;

		testBlobEntryModelImpl._blobFieldBlobModel = null;

		testBlobEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TestBlobEntry> toCacheModel() {
		TestBlobEntryCacheModel testBlobEntryCacheModel = new TestBlobEntryCacheModel();

		testBlobEntryCacheModel.uuid = getUuid();

		String uuid = testBlobEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			testBlobEntryCacheModel.uuid = null;
		}

		testBlobEntryCacheModel.testBlobEntryId = getTestBlobEntryId();

		return testBlobEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", testBlobEntryId=");
		sb.append(getTestBlobEntryId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.testblob.model.TestBlobEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testBlobEntryId</column-name><column-value><![CDATA[");
		sb.append(getTestBlobEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TestBlobEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TestBlobEntry.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _testBlobEntryId;
	private TestBlobEntryBlobFieldBlobModel _blobFieldBlobModel;
	private long _columnBitmask;
	private TestBlobEntry _escapedModel;
}