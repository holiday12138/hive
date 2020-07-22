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
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class AddPartitionsResult implements org.apache.thrift.TBase<AddPartitionsResult, AddPartitionsResult._Fields>, java.io.Serializable, Cloneable, Comparable<AddPartitionsResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AddPartitionsResult");

  private static final org.apache.thrift.protocol.TField PARTITIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("partitions", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField IS_STATS_COMPLIANT_FIELD_DESC = new org.apache.thrift.protocol.TField("isStatsCompliant", org.apache.thrift.protocol.TType.BOOL, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AddPartitionsResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AddPartitionsResultTupleSchemeFactory());
  }

  private List<Partition> partitions; // optional
  private boolean isStatsCompliant; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PARTITIONS((short)1, "partitions"),
    IS_STATS_COMPLIANT((short)2, "isStatsCompliant");

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
        case 1: // PARTITIONS
          return PARTITIONS;
        case 2: // IS_STATS_COMPLIANT
          return IS_STATS_COMPLIANT;
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
  private static final int __ISSTATSCOMPLIANT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PARTITIONS,_Fields.IS_STATS_COMPLIANT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PARTITIONS, new org.apache.thrift.meta_data.FieldMetaData("partitions", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Partition.class))));
    tmpMap.put(_Fields.IS_STATS_COMPLIANT, new org.apache.thrift.meta_data.FieldMetaData("isStatsCompliant", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AddPartitionsResult.class, metaDataMap);
  }

  public AddPartitionsResult() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AddPartitionsResult(AddPartitionsResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPartitions()) {
      List<Partition> __this__partitions = new ArrayList<Partition>(other.partitions.size());
      for (Partition other_element : other.partitions) {
        __this__partitions.add(new Partition(other_element));
      }
      this.partitions = __this__partitions;
    }
    this.isStatsCompliant = other.isStatsCompliant;
  }

  public AddPartitionsResult deepCopy() {
    return new AddPartitionsResult(this);
  }

  @Override
  public void clear() {
    this.partitions = null;
    setIsStatsCompliantIsSet(false);
    this.isStatsCompliant = false;
  }

  public int getPartitionsSize() {
    return (this.partitions == null) ? 0 : this.partitions.size();
  }

  public java.util.Iterator<Partition> getPartitionsIterator() {
    return (this.partitions == null) ? null : this.partitions.iterator();
  }

  public void addToPartitions(Partition elem) {
    if (this.partitions == null) {
      this.partitions = new ArrayList<Partition>();
    }
    this.partitions.add(elem);
  }

  public List<Partition> getPartitions() {
    return this.partitions;
  }

  public void setPartitions(List<Partition> partitions) {
    this.partitions = partitions;
  }

  public void unsetPartitions() {
    this.partitions = null;
  }

  /** Returns true if field partitions is set (has been assigned a value) and false otherwise */
  public boolean isSetPartitions() {
    return this.partitions != null;
  }

  public void setPartitionsIsSet(boolean value) {
    if (!value) {
      this.partitions = null;
    }
  }

  public boolean isIsStatsCompliant() {
    return this.isStatsCompliant;
  }

  public void setIsStatsCompliant(boolean isStatsCompliant) {
    this.isStatsCompliant = isStatsCompliant;
    setIsStatsCompliantIsSet(true);
  }

  public void unsetIsStatsCompliant() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISSTATSCOMPLIANT_ISSET_ID);
  }

  /** Returns true if field isStatsCompliant is set (has been assigned a value) and false otherwise */
  public boolean isSetIsStatsCompliant() {
    return EncodingUtils.testBit(__isset_bitfield, __ISSTATSCOMPLIANT_ISSET_ID);
  }

  public void setIsStatsCompliantIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISSTATSCOMPLIANT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PARTITIONS:
      if (value == null) {
        unsetPartitions();
      } else {
        setPartitions((List<Partition>)value);
      }
      break;

    case IS_STATS_COMPLIANT:
      if (value == null) {
        unsetIsStatsCompliant();
      } else {
        setIsStatsCompliant((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PARTITIONS:
      return getPartitions();

    case IS_STATS_COMPLIANT:
      return isIsStatsCompliant();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PARTITIONS:
      return isSetPartitions();
    case IS_STATS_COMPLIANT:
      return isSetIsStatsCompliant();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AddPartitionsResult)
      return this.equals((AddPartitionsResult)that);
    return false;
  }

  public boolean equals(AddPartitionsResult that) {
    if (that == null)
      return false;

    boolean this_present_partitions = true && this.isSetPartitions();
    boolean that_present_partitions = true && that.isSetPartitions();
    if (this_present_partitions || that_present_partitions) {
      if (!(this_present_partitions && that_present_partitions))
        return false;
      if (!this.partitions.equals(that.partitions))
        return false;
    }

    boolean this_present_isStatsCompliant = true && this.isSetIsStatsCompliant();
    boolean that_present_isStatsCompliant = true && that.isSetIsStatsCompliant();
    if (this_present_isStatsCompliant || that_present_isStatsCompliant) {
      if (!(this_present_isStatsCompliant && that_present_isStatsCompliant))
        return false;
      if (this.isStatsCompliant != that.isStatsCompliant)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_partitions = true && (isSetPartitions());
    list.add(present_partitions);
    if (present_partitions)
      list.add(partitions);

    boolean present_isStatsCompliant = true && (isSetIsStatsCompliant());
    list.add(present_isStatsCompliant);
    if (present_isStatsCompliant)
      list.add(isStatsCompliant);

    return list.hashCode();
  }

  @Override
  public int compareTo(AddPartitionsResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPartitions()).compareTo(other.isSetPartitions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartitions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitions, other.partitions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsStatsCompliant()).compareTo(other.isSetIsStatsCompliant());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsStatsCompliant()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isStatsCompliant, other.isStatsCompliant);
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
    StringBuilder sb = new StringBuilder("AddPartitionsResult(");
    boolean first = true;

    if (isSetPartitions()) {
      sb.append("partitions:");
      if (this.partitions == null) {
        sb.append("null");
      } else {
        sb.append(this.partitions);
      }
      first = false;
    }
    if (isSetIsStatsCompliant()) {
      if (!first) sb.append(", ");
      sb.append("isStatsCompliant:");
      sb.append(this.isStatsCompliant);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AddPartitionsResultStandardSchemeFactory implements SchemeFactory {
    public AddPartitionsResultStandardScheme getScheme() {
      return new AddPartitionsResultStandardScheme();
    }
  }

  private static class AddPartitionsResultStandardScheme extends StandardScheme<AddPartitionsResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AddPartitionsResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PARTITIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list514 = iprot.readListBegin();
                struct.partitions = new ArrayList<Partition>(_list514.size);
                Partition _elem515;
                for (int _i516 = 0; _i516 < _list514.size; ++_i516)
                {
                  _elem515 = new Partition();
                  _elem515.read(iprot);
                  struct.partitions.add(_elem515);
                }
                iprot.readListEnd();
              }
              struct.setPartitionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IS_STATS_COMPLIANT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isStatsCompliant = iprot.readBool();
              struct.setIsStatsCompliantIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AddPartitionsResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.partitions != null) {
        if (struct.isSetPartitions()) {
          oprot.writeFieldBegin(PARTITIONS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.partitions.size()));
            for (Partition _iter517 : struct.partitions)
            {
              _iter517.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetIsStatsCompliant()) {
        oprot.writeFieldBegin(IS_STATS_COMPLIANT_FIELD_DESC);
        oprot.writeBool(struct.isStatsCompliant);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AddPartitionsResultTupleSchemeFactory implements SchemeFactory {
    public AddPartitionsResultTupleScheme getScheme() {
      return new AddPartitionsResultTupleScheme();
    }
  }

  private static class AddPartitionsResultTupleScheme extends TupleScheme<AddPartitionsResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AddPartitionsResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPartitions()) {
        optionals.set(0);
      }
      if (struct.isSetIsStatsCompliant()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetPartitions()) {
        {
          oprot.writeI32(struct.partitions.size());
          for (Partition _iter518 : struct.partitions)
          {
            _iter518.write(oprot);
          }
        }
      }
      if (struct.isSetIsStatsCompliant()) {
        oprot.writeBool(struct.isStatsCompliant);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AddPartitionsResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list519 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.partitions = new ArrayList<Partition>(_list519.size);
          Partition _elem520;
          for (int _i521 = 0; _i521 < _list519.size; ++_i521)
          {
            _elem520 = new Partition();
            _elem520.read(iprot);
            struct.partitions.add(_elem520);
          }
        }
        struct.setPartitionsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.isStatsCompliant = iprot.readBool();
        struct.setIsStatsCompliantIsSet(true);
      }
    }
  }

}

