package com.google.gwt.junit.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JUnitResult_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.junit.client.impl.JUnitResult instance) throws SerializationException {
    instance.exceptionWrapper = (com.google.gwt.junit.client.impl.ExceptionWrapper) streamReader.readObject();
    
  }
  
  public static com.google.gwt.junit.client.impl.JUnitResult instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.junit.client.impl.JUnitResult();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.junit.client.impl.JUnitResult instance) throws SerializationException {
    streamWriter.writeObject(instance.exceptionWrapper);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.junit.client.impl.JUnitResult_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitResult_FieldSerializer.deserialize(reader, (com.google.gwt.junit.client.impl.JUnitResult)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitResult_FieldSerializer.serialize(writer, (com.google.gwt.junit.client.impl.JUnitResult)object);
  }
  
}
