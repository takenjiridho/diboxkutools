package com.google.gwt.junit.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JUnitHost_TestBlock_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getIndex(com.google.gwt.junit.client.impl.JUnitHost.TestBlock instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$TestBlock::index;
  }-*/;
  
  private static native void setIndex(com.google.gwt.junit.client.impl.JUnitHost.TestBlock instance, int value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$TestBlock::index = value;
  }-*/;
  
  private static native com.google.gwt.junit.client.impl.JUnitHost.TestInfo[] getTests(com.google.gwt.junit.client.impl.JUnitHost.TestBlock instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$TestBlock::tests;
  }-*/;
  
  private static native void setTests(com.google.gwt.junit.client.impl.JUnitHost.TestBlock instance, com.google.gwt.junit.client.impl.JUnitHost.TestInfo[] value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$TestBlock::tests = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.junit.client.impl.JUnitHost.TestBlock instance) throws SerializationException {
    setIndex(instance, streamReader.readInt());
    setTests(instance, (com.google.gwt.junit.client.impl.JUnitHost.TestInfo[]) streamReader.readObject());
    
  }
  
  public static com.google.gwt.junit.client.impl.JUnitHost.TestBlock instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.junit.client.impl.JUnitHost.TestBlock();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.junit.client.impl.JUnitHost.TestBlock instance) throws SerializationException {
    streamWriter.writeInt(getIndex(instance));
    streamWriter.writeObject(getTests(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.junit.client.impl.JUnitHost_TestBlock_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_TestBlock_FieldSerializer.deserialize(reader, (com.google.gwt.junit.client.impl.JUnitHost.TestBlock)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_TestBlock_FieldSerializer.serialize(writer, (com.google.gwt.junit.client.impl.JUnitHost.TestBlock)object);
  }
  
}
