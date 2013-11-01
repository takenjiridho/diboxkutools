package com.google.gwt.junit.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JUnitHost_TestInfo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getTestClass(com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$TestInfo::testClass;
  }-*/;
  
  private static native void setTestClass(com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$TestInfo::testClass = value;
  }-*/;
  
  private static native java.lang.String getTestMethod(com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$TestInfo::testMethod;
  }-*/;
  
  private static native void setTestMethod(com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$TestInfo::testMethod = value;
  }-*/;
  
  private static native java.lang.String getTestModule(com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$TestInfo::testModule;
  }-*/;
  
  private static native void setTestModule(com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$TestInfo::testModule = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance) throws SerializationException {
    setTestClass(instance, streamReader.readString());
    setTestMethod(instance, streamReader.readString());
    setTestModule(instance, streamReader.readString());
    
  }
  
  public static com.google.gwt.junit.client.impl.JUnitHost.TestInfo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.junit.client.impl.JUnitHost.TestInfo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.junit.client.impl.JUnitHost.TestInfo instance) throws SerializationException {
    streamWriter.writeString(getTestClass(instance));
    streamWriter.writeString(getTestMethod(instance));
    streamWriter.writeString(getTestModule(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.junit.client.impl.JUnitHost_TestInfo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_TestInfo_FieldSerializer.deserialize(reader, (com.google.gwt.junit.client.impl.JUnitHost.TestInfo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_TestInfo_FieldSerializer.serialize(writer, (com.google.gwt.junit.client.impl.JUnitHost.TestInfo)object);
  }
  
}
