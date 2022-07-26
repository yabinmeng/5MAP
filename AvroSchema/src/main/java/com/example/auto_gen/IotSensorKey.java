/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.auto_gen;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class IotSensorKey extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 499587215698919690L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IotSensorKey\",\"fields\":[{\"name\":\"SiteId\",\"type\":\"int\"},{\"name\":\"StationId\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<IotSensorKey> ENCODER =
      new BinaryMessageEncoder<IotSensorKey>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<IotSensorKey> DECODER =
      new BinaryMessageDecoder<IotSensorKey>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<IotSensorKey> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<IotSensorKey> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<IotSensorKey> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<IotSensorKey>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this IotSensorKey to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a IotSensorKey from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a IotSensorKey instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static IotSensorKey fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int SiteId;
  private int StationId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public IotSensorKey() {}

  /**
   * All-args constructor.
   * @param SiteId The new value for SiteId
   * @param StationId The new value for StationId
   */
  public IotSensorKey(java.lang.Integer SiteId, java.lang.Integer StationId) {
    this.SiteId = SiteId;
    this.StationId = StationId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return SiteId;
    case 1: return StationId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: SiteId = (java.lang.Integer)value$; break;
    case 1: StationId = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'SiteId' field.
   * @return The value of the 'SiteId' field.
   */
  public int getSiteId() {
    return SiteId;
  }


  /**
   * Sets the value of the 'SiteId' field.
   * @param value the value to set.
   */
  public void setSiteId(int value) {
    this.SiteId = value;
  }

  /**
   * Gets the value of the 'StationId' field.
   * @return The value of the 'StationId' field.
   */
  public int getStationId() {
    return StationId;
  }


  /**
   * Sets the value of the 'StationId' field.
   * @param value the value to set.
   */
  public void setStationId(int value) {
    this.StationId = value;
  }

  /**
   * Creates a new IotSensorKey RecordBuilder.
   * @return A new IotSensorKey RecordBuilder
   */
  public static IotSensorKey.Builder newBuilder() {
    return new IotSensorKey.Builder();
  }

  /**
   * Creates a new IotSensorKey RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new IotSensorKey RecordBuilder
   */
  public static IotSensorKey.Builder newBuilder(IotSensorKey.Builder other) {
    if (other == null) {
      return new IotSensorKey.Builder();
    } else {
      return new IotSensorKey.Builder(other);
    }
  }

  /**
   * Creates a new IotSensorKey RecordBuilder by copying an existing IotSensorKey instance.
   * @param other The existing instance to copy.
   * @return A new IotSensorKey RecordBuilder
   */
  public static IotSensorKey.Builder newBuilder(IotSensorKey other) {
    if (other == null) {
      return new IotSensorKey.Builder();
    } else {
      return new IotSensorKey.Builder(other);
    }
  }

  /**
   * RecordBuilder for IotSensorKey instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IotSensorKey>
    implements org.apache.avro.data.RecordBuilder<IotSensorKey> {

    private int SiteId;
    private int StationId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(IotSensorKey.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.SiteId)) {
        this.SiteId = data().deepCopy(fields()[0].schema(), other.SiteId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.StationId)) {
        this.StationId = data().deepCopy(fields()[1].schema(), other.StationId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing IotSensorKey instance
     * @param other The existing instance to copy.
     */
    private Builder(IotSensorKey other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.SiteId)) {
        this.SiteId = data().deepCopy(fields()[0].schema(), other.SiteId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.StationId)) {
        this.StationId = data().deepCopy(fields()[1].schema(), other.StationId);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'SiteId' field.
      * @return The value.
      */
    public int getSiteId() {
      return SiteId;
    }


    /**
      * Sets the value of the 'SiteId' field.
      * @param value The value of 'SiteId'.
      * @return This builder.
      */
    public IotSensorKey.Builder setSiteId(int value) {
      validate(fields()[0], value);
      this.SiteId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'SiteId' field has been set.
      * @return True if the 'SiteId' field has been set, false otherwise.
      */
    public boolean hasSiteId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'SiteId' field.
      * @return This builder.
      */
    public IotSensorKey.Builder clearSiteId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'StationId' field.
      * @return The value.
      */
    public int getStationId() {
      return StationId;
    }


    /**
      * Sets the value of the 'StationId' field.
      * @param value The value of 'StationId'.
      * @return This builder.
      */
    public IotSensorKey.Builder setStationId(int value) {
      validate(fields()[1], value);
      this.StationId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'StationId' field has been set.
      * @return True if the 'StationId' field has been set, false otherwise.
      */
    public boolean hasStationId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'StationId' field.
      * @return This builder.
      */
    public IotSensorKey.Builder clearStationId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IotSensorKey build() {
      try {
        IotSensorKey record = new IotSensorKey();
        record.SiteId = fieldSetFlags()[0] ? this.SiteId : (java.lang.Integer) defaultValue(fields()[0]);
        record.StationId = fieldSetFlags()[1] ? this.StationId : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<IotSensorKey>
    WRITER$ = (org.apache.avro.io.DatumWriter<IotSensorKey>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<IotSensorKey>
    READER$ = (org.apache.avro.io.DatumReader<IotSensorKey>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.SiteId);

    out.writeInt(this.StationId);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.SiteId = in.readInt();

      this.StationId = in.readInt();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.SiteId = in.readInt();
          break;

        case 1:
          this.StationId = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










