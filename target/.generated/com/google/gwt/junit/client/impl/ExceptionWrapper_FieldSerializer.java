package com.google.gwt.junit.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ExceptionWrapper_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.junit.client.impl.ExceptionWrapper instance) throws SerializationException {
    instance.causeWrapper = (com.google.gwt.junit.client.impl.ExceptionWrapper) streamReader.readObject();
    instance.exception = (java.lang.Throwable) streamReader.readObject();
    instance.stackTrace = (java.lang.StackTraceElement[]) streamReader.readObject();
    
  }
  
  public static com.google.gwt.junit.client.impl.ExceptionWrapper instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.junit.client.impl.ExceptionWrapper();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.junit.client.impl.ExceptionWrapper instance) throws SerializationException {
    streamWriter.writeObject(instance.causeWrapper);
    streamWriter.writeObject(instance.exception);
    streamWriter.writeObject(instance.stackTrace);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.junit.client.impl.ExceptionWrapper_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.ExceptionWrapper_FieldSerializer.deserialize(reader, (com.google.gwt.junit.client.impl.ExceptionWrapper)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.ExceptionWrapper_FieldSerializer.serialize(writer, (com.google.gwt.junit.client.impl.ExceptionWrapper)object);
  }
  
}
