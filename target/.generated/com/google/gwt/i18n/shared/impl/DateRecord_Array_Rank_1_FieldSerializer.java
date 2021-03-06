package com.google.gwt.i18n.shared.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DateRecord_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.i18n.shared.impl.DateRecord[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.google.gwt.i18n.shared.impl.DateRecord[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.google.gwt.i18n.shared.impl.DateRecord[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.i18n.shared.impl.DateRecord[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.i18n.shared.impl.DateRecord_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.i18n.shared.impl.DateRecord_Array_Rank_1_FieldSerializer.deserialize(reader, (com.google.gwt.i18n.shared.impl.DateRecord[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.i18n.shared.impl.DateRecord_Array_Rank_1_FieldSerializer.serialize(writer, (com.google.gwt.i18n.shared.impl.DateRecord[])object);
  }
  
}
