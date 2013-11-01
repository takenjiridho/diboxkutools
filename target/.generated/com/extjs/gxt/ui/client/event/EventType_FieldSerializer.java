package com.extjs.gxt.ui.client.event;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EventType_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getEventCode(com.extjs.gxt.ui.client.event.EventType instance) /*-{
    return instance.@com.extjs.gxt.ui.client.event.EventType::eventCode;
  }-*/;
  
  private static native void setEventCode(com.extjs.gxt.ui.client.event.EventType instance, int value) 
  /*-{
    instance.@com.extjs.gxt.ui.client.event.EventType::eventCode = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.event.EventType instance) throws SerializationException {
    setEventCode(instance, streamReader.readInt());
    
  }
  
  public static com.extjs.gxt.ui.client.event.EventType instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.extjs.gxt.ui.client.event.EventType();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.event.EventType instance) throws SerializationException {
    streamWriter.writeInt(getEventCode(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.event.EventType_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.event.EventType_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.event.EventType)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.event.EventType_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.event.EventType)object);
  }
  
}
