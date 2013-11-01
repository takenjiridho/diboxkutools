package com.google.gwt.validation.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PathImpl_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.validation.client.impl.PathImpl instance) throws SerializationException {
    
  }
  
  public static com.google.gwt.validation.client.impl.PathImpl instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.validation.client.impl.PathImpl();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.validation.client.impl.PathImpl instance) throws SerializationException {
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.validation.client.impl.PathImpl_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.validation.client.impl.PathImpl_FieldSerializer.deserialize(reader, (com.google.gwt.validation.client.impl.PathImpl)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.validation.client.impl.PathImpl_FieldSerializer.serialize(writer, (com.google.gwt.validation.client.impl.PathImpl)object);
  }
  
}
