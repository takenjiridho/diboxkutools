package com.google.gwt.junit.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JUnitHost_InitialResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getSessionId(com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$InitialResponse::sessionId;
  }-*/;
  
  private static native void setSessionId(com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instance, int value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$InitialResponse::sessionId = value;
  }-*/;
  
  private static native com.google.gwt.junit.client.impl.JUnitHost.TestBlock getTestBlock(com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$InitialResponse::testBlock;
  }-*/;
  
  private static native void setTestBlock(com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instance, com.google.gwt.junit.client.impl.JUnitHost.TestBlock value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$InitialResponse::testBlock = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instance) throws SerializationException {
    setSessionId(instance, streamReader.readInt());
    setTestBlock(instance, (com.google.gwt.junit.client.impl.JUnitHost.TestBlock) streamReader.readObject());
    
  }
  
  public static com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.junit.client.impl.JUnitHost.InitialResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.junit.client.impl.JUnitHost.InitialResponse instance) throws SerializationException {
    streamWriter.writeInt(getSessionId(instance));
    streamWriter.writeObject(getTestBlock(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.junit.client.impl.JUnitHost_InitialResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_InitialResponse_FieldSerializer.deserialize(reader, (com.google.gwt.junit.client.impl.JUnitHost.InitialResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_InitialResponse_FieldSerializer.serialize(writer, (com.google.gwt.junit.client.impl.JUnitHost.InitialResponse)object);
  }
  
}
