package com.google.gwt.junit.client.impl;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class JUnitHost_ClientInfo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getSessionId(com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$ClientInfo::sessionId;
  }-*/;
  
  private static native void setSessionId(com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instance, int value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$ClientInfo::sessionId = value;
  }-*/;
  
  private static native java.lang.String getUserAgent(com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instance) /*-{
    return instance.@com.google.gwt.junit.client.impl.JUnitHost$ClientInfo::userAgent;
  }-*/;
  
  private static native void setUserAgent(com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.junit.client.impl.JUnitHost$ClientInfo::userAgent = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instance) throws SerializationException {
    setSessionId(instance, streamReader.readInt());
    setUserAgent(instance, streamReader.readString());
    
  }
  
  public static com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.junit.client.impl.JUnitHost.ClientInfo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.junit.client.impl.JUnitHost.ClientInfo instance) throws SerializationException {
    streamWriter.writeInt(getSessionId(instance));
    streamWriter.writeString(getUserAgent(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.junit.client.impl.JUnitHost_ClientInfo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_ClientInfo_FieldSerializer.deserialize(reader, (com.google.gwt.junit.client.impl.JUnitHost.ClientInfo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.junit.client.impl.JUnitHost_ClientInfo_FieldSerializer.serialize(writer, (com.google.gwt.junit.client.impl.JUnitHost.ClientInfo)object);
  }
  
}
