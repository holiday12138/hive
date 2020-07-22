/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class ReplTblWriteIdStateRequest implements org.apache.thrift.TBase<ReplTblWriteIdStateRequest, ReplTblWriteIdStateRequest._Fields>, java.io.Serializable, Cloneable, Comparable<ReplTblWriteIdStateRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReplTblWriteIdStateRequest");

  private static final org.apache.thrift.protocol.TField VALID_WRITE_IDLIST_FIELD_DESC = new org.apache.thrift.protocol.TField("validWriteIdlist", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField HOST_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("hostName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PART_NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("partNames", org.apache.thrift.protocol.TType.LIST, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReplTblWriteIdStateRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReplTblWriteIdStateRequestTupleSchemeFactory());
  }

  private String validWriteIdlist; // required
  private String user; // required
  private String hostName; // required
  private String dbName; // required
  private String tableName; // required
  private List<String> partNames; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    VALID_WRITE_IDLIST((short)1, "validWriteIdlist"),
    USER((short)2, "user"),
    HOST_NAME((short)3, "hostName"),
    DB_NAME((short)4, "dbName"),
    TABLE_NAME((short)5, "tableName"),
    PART_NAMES((short)6, "partNames");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // VALID_WRITE_IDLIST
          return VALID_WRITE_IDLIST;
        case 2: // USER
          return USER;
        case 3: // HOST_NAME
          return HOST_NAME;
        case 4: // DB_NAME
          return DB_NAME;
        case 5: // TABLE_NAME
          return TABLE_NAME;
        case 6: // PART_NAMES
          return PART_NAMES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.PART_NAMES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.VALID_WRITE_IDLIST, new org.apache.thrift.meta_data.FieldMetaData("validWriteIdlist", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOST_NAME, new org.apache.thrift.meta_data.FieldMetaData("hostName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PART_NAMES, new org.apache.thrift.meta_data.FieldMetaData("partNames", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReplTblWriteIdStateRequest.class, metaDataMap);
  }

  public ReplTblWriteIdStateRequest() {
  }

  public ReplTblWriteIdStateRequest(
    String validWriteIdlist,
    String user,
    String hostName,
    String dbName,
    String tableName)
  {
    this();
    this.validWriteIdlist = validWriteIdlist;
    this.user = user;
    this.hostName = hostName;
    this.dbName = dbName;
    this.tableName = tableName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReplTblWriteIdStateRequest(ReplTblWriteIdStateRequest other) {
    if (other.isSetValidWriteIdlist()) {
      this.validWriteIdlist = other.validWriteIdlist;
    }
    if (other.isSetUser()) {
      this.user = other.user;
    }
    if (other.isSetHostName()) {
      this.hostName = other.hostName;
    }
    if (other.isSetDbName()) {
      this.dbName = other.dbName;
    }
    if (other.isSetTableName()) {
      this.tableName = other.tableName;
    }
    if (other.isSetPartNames()) {
      List<String> __this__partNames = new ArrayList<String>(other.partNames);
      this.partNames = __this__partNames;
    }
  }

  public ReplTblWriteIdStateRequest deepCopy() {
    return new ReplTblWriteIdStateRequest(this);
  }

  @Override
  public void clear() {
    this.validWriteIdlist = null;
    this.user = null;
    this.hostName = null;
    this.dbName = null;
    this.tableName = null;
    this.partNames = null;
  }

  public String getValidWriteIdlist() {
    return this.validWriteIdlist;
  }

  public void setValidWriteIdlist(String validWriteIdlist) {
    this.validWriteIdlist = validWriteIdlist;
  }

  public void unsetValidWriteIdlist() {
    this.validWriteIdlist = null;
  }

  /** Returns true if field validWriteIdlist is set (has been assigned a value) and false otherwise */
  public boolean isSetValidWriteIdlist() {
    return this.validWriteIdlist != null;
  }

  public void setValidWriteIdlistIsSet(boolean value) {
    if (!value) {
      this.validWriteIdlist = null;
    }
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  public String getHostName() {
    return this.hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public void unsetHostName() {
    this.hostName = null;
  }

  /** Returns true if field hostName is set (has been assigned a value) and false otherwise */
  public boolean isSetHostName() {
    return this.hostName != null;
  }

  public void setHostNameIsSet(boolean value) {
    if (!value) {
      this.hostName = null;
    }
  }

  public String getDbName() {
    return this.dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public void unsetDbName() {
    this.dbName = null;
  }

  /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
  public boolean isSetDbName() {
    return this.dbName != null;
  }

  public void setDbNameIsSet(boolean value) {
    if (!value) {
      this.dbName = null;
    }
  }

  public String getTableName() {
    return this.tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public void unsetTableName() {
    this.tableName = null;
  }

  /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
  public boolean isSetTableName() {
    return this.tableName != null;
  }

  public void setTableNameIsSet(boolean value) {
    if (!value) {
      this.tableName = null;
    }
  }

  public int getPartNamesSize() {
    return (this.partNames == null) ? 0 : this.partNames.size();
  }

  public java.util.Iterator<String> getPartNamesIterator() {
    return (this.partNames == null) ? null : this.partNames.iterator();
  }

  public void addToPartNames(String elem) {
    if (this.partNames == null) {
      this.partNames = new ArrayList<String>();
    }
    this.partNames.add(elem);
  }

  public List<String> getPartNames() {
    return this.partNames;
  }

  public void setPartNames(List<String> partNames) {
    this.partNames = partNames;
  }

  public void unsetPartNames() {
    this.partNames = null;
  }

  /** Returns true if field partNames is set (has been assigned a value) and false otherwise */
  public boolean isSetPartNames() {
    return this.partNames != null;
  }

  public void setPartNamesIsSet(boolean value) {
    if (!value) {
      this.partNames = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case VALID_WRITE_IDLIST:
      if (value == null) {
        unsetValidWriteIdlist();
      } else {
        setValidWriteIdlist((String)value);
      }
      break;

    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((String)value);
      }
      break;

    case HOST_NAME:
      if (value == null) {
        unsetHostName();
      } else {
        setHostName((String)value);
      }
      break;

    case DB_NAME:
      if (value == null) {
        unsetDbName();
      } else {
        setDbName((String)value);
      }
      break;

    case TABLE_NAME:
      if (value == null) {
        unsetTableName();
      } else {
        setTableName((String)value);
      }
      break;

    case PART_NAMES:
      if (value == null) {
        unsetPartNames();
      } else {
        setPartNames((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case VALID_WRITE_IDLIST:
      return getValidWriteIdlist();

    case USER:
      return getUser();

    case HOST_NAME:
      return getHostName();

    case DB_NAME:
      return getDbName();

    case TABLE_NAME:
      return getTableName();

    case PART_NAMES:
      return getPartNames();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case VALID_WRITE_IDLIST:
      return isSetValidWriteIdlist();
    case USER:
      return isSetUser();
    case HOST_NAME:
      return isSetHostName();
    case DB_NAME:
      return isSetDbName();
    case TABLE_NAME:
      return isSetTableName();
    case PART_NAMES:
      return isSetPartNames();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReplTblWriteIdStateRequest)
      return this.equals((ReplTblWriteIdStateRequest)that);
    return false;
  }

  public boolean equals(ReplTblWriteIdStateRequest that) {
    if (that == null)
      return false;

    boolean this_present_validWriteIdlist = true && this.isSetValidWriteIdlist();
    boolean that_present_validWriteIdlist = true && that.isSetValidWriteIdlist();
    if (this_present_validWriteIdlist || that_present_validWriteIdlist) {
      if (!(this_present_validWriteIdlist && that_present_validWriteIdlist))
        return false;
      if (!this.validWriteIdlist.equals(that.validWriteIdlist))
        return false;
    }

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    boolean this_present_hostName = true && this.isSetHostName();
    boolean that_present_hostName = true && that.isSetHostName();
    if (this_present_hostName || that_present_hostName) {
      if (!(this_present_hostName && that_present_hostName))
        return false;
      if (!this.hostName.equals(that.hostName))
        return false;
    }

    boolean this_present_dbName = true && this.isSetDbName();
    boolean that_present_dbName = true && that.isSetDbName();
    if (this_present_dbName || that_present_dbName) {
      if (!(this_present_dbName && that_present_dbName))
        return false;
      if (!this.dbName.equals(that.dbName))
        return false;
    }

    boolean this_present_tableName = true && this.isSetTableName();
    boolean that_present_tableName = true && that.isSetTableName();
    if (this_present_tableName || that_present_tableName) {
      if (!(this_present_tableName && that_present_tableName))
        return false;
      if (!this.tableName.equals(that.tableName))
        return false;
    }

    boolean this_present_partNames = true && this.isSetPartNames();
    boolean that_present_partNames = true && that.isSetPartNames();
    if (this_present_partNames || that_present_partNames) {
      if (!(this_present_partNames && that_present_partNames))
        return false;
      if (!this.partNames.equals(that.partNames))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_validWriteIdlist = true && (isSetValidWriteIdlist());
    list.add(present_validWriteIdlist);
    if (present_validWriteIdlist)
      list.add(validWriteIdlist);

    boolean present_user = true && (isSetUser());
    list.add(present_user);
    if (present_user)
      list.add(user);

    boolean present_hostName = true && (isSetHostName());
    list.add(present_hostName);
    if (present_hostName)
      list.add(hostName);

    boolean present_dbName = true && (isSetDbName());
    list.add(present_dbName);
    if (present_dbName)
      list.add(dbName);

    boolean present_tableName = true && (isSetTableName());
    list.add(present_tableName);
    if (present_tableName)
      list.add(tableName);

    boolean present_partNames = true && (isSetPartNames());
    list.add(present_partNames);
    if (present_partNames)
      list.add(partNames);

    return list.hashCode();
  }

  @Override
  public int compareTo(ReplTblWriteIdStateRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetValidWriteIdlist()).compareTo(other.isSetValidWriteIdlist());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValidWriteIdlist()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.validWriteIdlist, other.validWriteIdlist);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUser()).compareTo(other.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, other.user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHostName()).compareTo(other.isSetHostName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHostName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hostName, other.hostName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbName()).compareTo(other.isSetDbName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTableName()).compareTo(other.isSetTableName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTableName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartNames()).compareTo(other.isSetPartNames());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartNames()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partNames, other.partNames);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ReplTblWriteIdStateRequest(");
    boolean first = true;

    sb.append("validWriteIdlist:");
    if (this.validWriteIdlist == null) {
      sb.append("null");
    } else {
      sb.append(this.validWriteIdlist);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("user:");
    if (this.user == null) {
      sb.append("null");
    } else {
      sb.append(this.user);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hostName:");
    if (this.hostName == null) {
      sb.append("null");
    } else {
      sb.append(this.hostName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbName:");
    if (this.dbName == null) {
      sb.append("null");
    } else {
      sb.append(this.dbName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tableName:");
    if (this.tableName == null) {
      sb.append("null");
    } else {
      sb.append(this.tableName);
    }
    first = false;
    if (isSetPartNames()) {
      if (!first) sb.append(", ");
      sb.append("partNames:");
      if (this.partNames == null) {
        sb.append("null");
      } else {
        sb.append(this.partNames);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetValidWriteIdlist()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'validWriteIdlist' is unset! Struct:" + toString());
    }

    if (!isSetUser()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'user' is unset! Struct:" + toString());
    }

    if (!isSetHostName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'hostName' is unset! Struct:" + toString());
    }

    if (!isSetDbName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' is unset! Struct:" + toString());
    }

    if (!isSetTableName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tableName' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ReplTblWriteIdStateRequestStandardSchemeFactory implements SchemeFactory {
    public ReplTblWriteIdStateRequestStandardScheme getScheme() {
      return new ReplTblWriteIdStateRequestStandardScheme();
    }
  }

  private static class ReplTblWriteIdStateRequestStandardScheme extends StandardScheme<ReplTblWriteIdStateRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReplTblWriteIdStateRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // VALID_WRITE_IDLIST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.validWriteIdlist = iprot.readString();
              struct.setValidWriteIdlistIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.user = iprot.readString();
              struct.setUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HOST_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.hostName = iprot.readString();
              struct.setHostNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = iprot.readString();
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TABLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tableName = iprot.readString();
              struct.setTableNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PART_NAMES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list674 = iprot.readListBegin();
                struct.partNames = new ArrayList<String>(_list674.size);
                String _elem675;
                for (int _i676 = 0; _i676 < _list674.size; ++_i676)
                {
                  _elem675 = iprot.readString();
                  struct.partNames.add(_elem675);
                }
                iprot.readListEnd();
              }
              struct.setPartNamesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReplTblWriteIdStateRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.validWriteIdlist != null) {
        oprot.writeFieldBegin(VALID_WRITE_IDLIST_FIELD_DESC);
        oprot.writeString(struct.validWriteIdlist);
        oprot.writeFieldEnd();
      }
      if (struct.user != null) {
        oprot.writeFieldBegin(USER_FIELD_DESC);
        oprot.writeString(struct.user);
        oprot.writeFieldEnd();
      }
      if (struct.hostName != null) {
        oprot.writeFieldBegin(HOST_NAME_FIELD_DESC);
        oprot.writeString(struct.hostName);
        oprot.writeFieldEnd();
      }
      if (struct.dbName != null) {
        oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        oprot.writeString(struct.dbName);
        oprot.writeFieldEnd();
      }
      if (struct.tableName != null) {
        oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
        oprot.writeString(struct.tableName);
        oprot.writeFieldEnd();
      }
      if (struct.partNames != null) {
        if (struct.isSetPartNames()) {
          oprot.writeFieldBegin(PART_NAMES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.partNames.size()));
            for (String _iter677 : struct.partNames)
            {
              oprot.writeString(_iter677);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReplTblWriteIdStateRequestTupleSchemeFactory implements SchemeFactory {
    public ReplTblWriteIdStateRequestTupleScheme getScheme() {
      return new ReplTblWriteIdStateRequestTupleScheme();
    }
  }

  private static class ReplTblWriteIdStateRequestTupleScheme extends TupleScheme<ReplTblWriteIdStateRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReplTblWriteIdStateRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.validWriteIdlist);
      oprot.writeString(struct.user);
      oprot.writeString(struct.hostName);
      oprot.writeString(struct.dbName);
      oprot.writeString(struct.tableName);
      BitSet optionals = new BitSet();
      if (struct.isSetPartNames()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetPartNames()) {
        {
          oprot.writeI32(struct.partNames.size());
          for (String _iter678 : struct.partNames)
          {
            oprot.writeString(_iter678);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReplTblWriteIdStateRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.validWriteIdlist = iprot.readString();
      struct.setValidWriteIdlistIsSet(true);
      struct.user = iprot.readString();
      struct.setUserIsSet(true);
      struct.hostName = iprot.readString();
      struct.setHostNameIsSet(true);
      struct.dbName = iprot.readString();
      struct.setDbNameIsSet(true);
      struct.tableName = iprot.readString();
      struct.setTableNameIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list679 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.partNames = new ArrayList<String>(_list679.size);
          String _elem680;
          for (int _i681 = 0; _i681 < _list679.size; ++_i681)
          {
            _elem680 = iprot.readString();
            struct.partNames.add(_elem680);
          }
        }
        struct.setPartNamesIsSet(true);
      }
    }
  }

}

