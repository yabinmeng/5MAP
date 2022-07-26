/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

package com.example.auto_gen;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class IotSensorVal extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7628971872949909357L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IotSensorVal\",\"fields\":[{\"name\":\"SensorID\",\"type\":\"string\"},{\"name\":\"SensorType\",\"type\":\"string\"},{\"name\":\"ReadingTime\",\"type\":\"long\",\"logicalType\":\"date\"},{\"name\":\"ReadingValue\",\"type\":\"float\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<IotSensorVal> ENCODER =
      new BinaryMessageEncoder<IotSensorVal>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<IotSensorVal> DECODER =
      new BinaryMessageDecoder<IotSensorVal>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<IotSensorVal> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<IotSensorVal> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<IotSensorVal> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<IotSensorVal>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this IotSensorVal to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a IotSensorVal from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a IotSensorVal instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static IotSensorVal fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence SensorID;
  private java.lang.CharSequence SensorType;
  private long ReadingTime;
  private float ReadingValue;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public IotSensorVal() {}

  /**
   * All-args constructor.
   * @param SensorID The new value for SensorID
   * @param SensorType The new value for SensorType
   * @param ReadingTime The new value for ReadingTime
   * @param ReadingValue The new value for ReadingValue
   */
  public IotSensorVal(java.lang.CharSequence SensorID, java.lang.CharSequence SensorType, java.lang.Long ReadingTime, java.lang.Float ReadingValue) {
    this.SensorID = SensorID;
    this.SensorType = SensorType;
    this.ReadingTime = ReadingTime;
    this.ReadingValue = ReadingValue;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return SensorID;
    case 1: return SensorType;
    case 2: return ReadingTime;
    case 3: return ReadingValue;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: SensorID = (java.lang.CharSequence)value$; break;
    case 1: SensorType = (java.lang.CharSequence)value$; break;
    case 2: ReadingTime = (java.lang.Long)value$; break;
    case 3: ReadingValue = (java.lang.Float)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'SensorID' field.
   * @return The value of the 'SensorID' field.
   */
  public java.lang.CharSequence getSensorID() {
    return SensorID;
  }


  /**
   * Sets the value of the 'SensorID' field.
   * @param value the value to set.
   */
  public void setSensorID(java.lang.CharSequence value) {
    this.SensorID = value;
  }

  /**
   * Gets the value of the 'SensorType' field.
   * @return The value of the 'SensorType' field.
   */
  public java.lang.CharSequence getSensorType() {
    return SensorType;
  }


  /**
   * Sets the value of the 'SensorType' field.
   * @param value the value to set.
   */
  public void setSensorType(java.lang.CharSequence value) {
    this.SensorType = value;
  }

  /**
   * Gets the value of the 'ReadingTime' field.
   * @return The value of the 'ReadingTime' field.
   */
  public long getReadingTime() {
    return ReadingTime;
  }


  /**
   * Sets the value of the 'ReadingTime' field.
   * @param value the value to set.
   */
  public void setReadingTime(long value) {
    this.ReadingTime = value;
  }

  /**
   * Gets the value of the 'ReadingValue' field.
   * @return The value of the 'ReadingValue' field.
   */
  public float getReadingValue() {
    return ReadingValue;
  }


  /**
   * Sets the value of the 'ReadingValue' field.
   * @param value the value to set.
   */
  public void setReadingValue(float value) {
    this.ReadingValue = value;
  }

  /**
   * Creates a new IotSensorVal RecordBuilder.
   * @return A new IotSensorVal RecordBuilder
   */
  public static IotSensorVal.Builder newBuilder() {
    return new IotSensorVal.Builder();
  }

  /**
   * Creates a new IotSensorVal RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new IotSensorVal RecordBuilder
   */
  public static IotSensorVal.Builder newBuilder(IotSensorVal.Builder other) {
    if (other == null) {
      return new IotSensorVal.Builder();
    } else {
      return new IotSensorVal.Builder(other);
    }
  }

  /**
   * Creates a new IotSensorVal RecordBuilder by copying an existing IotSensorVal instance.
   * @param other The existing instance to copy.
   * @return A new IotSensorVal RecordBuilder
   */
  public static IotSensorVal.Builder newBuilder(IotSensorVal other) {
    if (other == null) {
      return new IotSensorVal.Builder();
    } else {
      return new IotSensorVal.Builder(other);
    }
  }

  /**
   * RecordBuilder for IotSensorVal instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IotSensorVal>
    implements org.apache.avro.data.RecordBuilder<IotSensorVal> {

    private java.lang.CharSequence SensorID;
    private java.lang.CharSequence SensorType;
    private long ReadingTime;
    private float ReadingValue;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(IotSensorVal.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.SensorID)) {
        this.SensorID = data().deepCopy(fields()[0].schema(), other.SensorID);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.SensorType)) {
        this.SensorType = data().deepCopy(fields()[1].schema(), other.SensorType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.ReadingTime)) {
        this.ReadingTime = data().deepCopy(fields()[2].schema(), other.ReadingTime);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.ReadingValue)) {
        this.ReadingValue = data().deepCopy(fields()[3].schema(), other.ReadingValue);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing IotSensorVal instance
     * @param other The existing instance to copy.
     */
    private Builder(IotSensorVal other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.SensorID)) {
        this.SensorID = data().deepCopy(fields()[0].schema(), other.SensorID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.SensorType)) {
        this.SensorType = data().deepCopy(fields()[1].schema(), other.SensorType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.ReadingTime)) {
        this.ReadingTime = data().deepCopy(fields()[2].schema(), other.ReadingTime);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.ReadingValue)) {
        this.ReadingValue = data().deepCopy(fields()[3].schema(), other.ReadingValue);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'SensorID' field.
      * @return The value.
      */
    public java.lang.CharSequence getSensorID() {
      return SensorID;
    }


    /**
      * Sets the value of the 'SensorID' field.
      * @param value The value of 'SensorID'.
      * @return This builder.
      */
    public IotSensorVal.Builder setSensorID(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.SensorID = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'SensorID' field has been set.
      * @return True if the 'SensorID' field has been set, false otherwise.
      */
    public boolean hasSensorID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'SensorID' field.
      * @return This builder.
      */
    public IotSensorVal.Builder clearSensorID() {
      SensorID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'SensorType' field.
      * @return The value.
      */
    public java.lang.CharSequence getSensorType() {
      return SensorType;
    }


    /**
      * Sets the value of the 'SensorType' field.
      * @param value The value of 'SensorType'.
      * @return This builder.
      */
    public IotSensorVal.Builder setSensorType(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.SensorType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'SensorType' field has been set.
      * @return True if the 'SensorType' field has been set, false otherwise.
      */
    public boolean hasSensorType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'SensorType' field.
      * @return This builder.
      */
    public IotSensorVal.Builder clearSensorType() {
      SensorType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'ReadingTime' field.
      * @return The value.
      */
    public long getReadingTime() {
      return ReadingTime;
    }


    /**
      * Sets the value of the 'ReadingTime' field.
      * @param value The value of 'ReadingTime'.
      * @return This builder.
      */
    public IotSensorVal.Builder setReadingTime(long value) {
      validate(fields()[2], value);
      this.ReadingTime = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'ReadingTime' field has been set.
      * @return True if the 'ReadingTime' field has been set, false otherwise.
      */
    public boolean hasReadingTime() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'ReadingTime' field.
      * @return This builder.
      */
    public IotSensorVal.Builder clearReadingTime() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'ReadingValue' field.
      * @return The value.
      */
    public float getReadingValue() {
      return ReadingValue;
    }


    /**
      * Sets the value of the 'ReadingValue' field.
      * @param value The value of 'ReadingValue'.
      * @return This builder.
      */
    public IotSensorVal.Builder setReadingValue(float value) {
      validate(fields()[3], value);
      this.ReadingValue = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'ReadingValue' field has been set.
      * @return True if the 'ReadingValue' field has been set, false otherwise.
      */
    public boolean hasReadingValue() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'ReadingValue' field.
      * @return This builder.
      */
    public IotSensorVal.Builder clearReadingValue() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IotSensorVal build() {
      try {
        IotSensorVal record = new IotSensorVal();
        record.SensorID = fieldSetFlags()[0] ? this.SensorID : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.SensorType = fieldSetFlags()[1] ? this.SensorType : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.ReadingTime = fieldSetFlags()[2] ? this.ReadingTime : (java.lang.Long) defaultValue(fields()[2]);
        record.ReadingValue = fieldSetFlags()[3] ? this.ReadingValue : (java.lang.Float) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<IotSensorVal>
    WRITER$ = (org.apache.avro.io.DatumWriter<IotSensorVal>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<IotSensorVal>
    READER$ = (org.apache.avro.io.DatumReader<IotSensorVal>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.SensorID);

    out.writeString(this.SensorType);

    out.writeLong(this.ReadingTime);

    out.writeFloat(this.ReadingValue);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.SensorID = in.readString(this.SensorID instanceof Utf8 ? (Utf8)this.SensorID : null);

      this.SensorType = in.readString(this.SensorType instanceof Utf8 ? (Utf8)this.SensorType : null);

      this.ReadingTime = in.readLong();

      this.ReadingValue = in.readFloat();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.SensorID = in.readString(this.SensorID instanceof Utf8 ? (Utf8)this.SensorID : null);
          break;

        case 1:
          this.SensorType = in.readString(this.SensorType instanceof Utf8 ? (Utf8)this.SensorType : null);
          break;

        case 2:
          this.ReadingTime = in.readLong();
          break;

        case 3:
          this.ReadingValue = in.readFloat();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










