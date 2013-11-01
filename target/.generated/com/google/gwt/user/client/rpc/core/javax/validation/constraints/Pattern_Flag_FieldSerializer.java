package com.google.gwt.user.client.rpc.core.javax.validation.constraints;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Pattern_Flag_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, javax.validation.constraints.Pattern.Flag instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static javax.validation.constraints.Pattern.Flag instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    javax.validation.constraints.Pattern.Flag[] values = javax.validation.constraints.Pattern.Flag.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, javax.validation.constraints.Pattern.Flag instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.rpc.core.javax.validation.constraints.Pattern_Flag_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.javax.validation.constraints.Pattern_Flag_FieldSerializer.deserialize(reader, (javax.validation.constraints.Pattern.Flag)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.javax.validation.constraints.Pattern_Flag_FieldSerializer.serialize(writer, (javax.validation.constraints.Pattern.Flag)object);
  }
  
}
