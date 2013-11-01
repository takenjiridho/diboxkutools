package com.google.gwt.view.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Range_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getLength(com.google.gwt.view.client.Range instance) /*-{
    return instance.@com.google.gwt.view.client.Range::length;
  }-*/;
  
  private static native void setLength(com.google.gwt.view.client.Range instance, int value) 
  /*-{
    instance.@com.google.gwt.view.client.Range::length = value;
  }-*/;
  
  private static native int getStart(com.google.gwt.view.client.Range instance) /*-{
    return instance.@com.google.gwt.view.client.Range::start;
  }-*/;
  
  private static native void setStart(com.google.gwt.view.client.Range instance, int value) 
  /*-{
    instance.@com.google.gwt.view.client.Range::start = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.view.client.Range instance) throws SerializationException {
    setLength(instance, streamReader.readInt());
    setStart(instance, streamReader.readInt());
    
  }
  
  public static com.google.gwt.view.client.Range instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.google.gwt.view.client.Range();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.view.client.Range instance) throws SerializationException {
    streamWriter.writeInt(getLength(instance));
    streamWriter.writeInt(getStart(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.view.client.Range_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.view.client.Range_FieldSerializer.deserialize(reader, (com.google.gwt.view.client.Range)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.view.client.Range_FieldSerializer.serialize(writer, (com.google.gwt.view.client.Range)object);
  }
  
}
