package com.diboxku.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Entry_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native boolean getClosable(com.diboxku.client.model.Entry instance) /*-{
    return instance.@com.diboxku.client.model.Entry::closable;
  }-*/;
  
  private static native void setClosable(com.diboxku.client.model.Entry instance, boolean value) 
  /*-{
    instance.@com.diboxku.client.model.Entry::closable = value;
  }-*/;
  
  private static native boolean getFill(com.diboxku.client.model.Entry instance) /*-{
    return instance.@com.diboxku.client.model.Entry::fill;
  }-*/;
  
  private static native void setFill(com.diboxku.client.model.Entry instance, boolean value) 
  /*-{
    instance.@com.diboxku.client.model.Entry::fill = value;
  }-*/;
  
  private static native com.extjs.gxt.ui.client.Style.HideMode getHideMode(com.diboxku.client.model.Entry instance) /*-{
    return instance.@com.diboxku.client.model.Entry::hideMode;
  }-*/;
  
  private static native void setHideMode(com.diboxku.client.model.Entry instance, com.extjs.gxt.ui.client.Style.HideMode value) 
  /*-{
    instance.@com.diboxku.client.model.Entry::hideMode = value;
  }-*/;
  
  private static native java.lang.String getName(com.diboxku.client.model.Entry instance) /*-{
    return instance.@com.diboxku.client.model.Entry::name;
  }-*/;
  
  private static native void setName(com.diboxku.client.model.Entry instance, java.lang.String value) 
  /*-{
    instance.@com.diboxku.client.model.Entry::name = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.diboxku.client.model.Entry instance) throws SerializationException {
    setClosable(instance, streamReader.readBoolean());
    setFill(instance, streamReader.readBoolean());
    setHideMode(instance, (com.extjs.gxt.ui.client.Style.HideMode) streamReader.readObject());
    setName(instance, streamReader.readString());
    
    com.extjs.gxt.ui.client.data.BaseTreeModel_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.diboxku.client.model.Entry instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.diboxku.client.model.Entry();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.diboxku.client.model.Entry instance) throws SerializationException {
    streamWriter.writeBoolean(getClosable(instance));
    streamWriter.writeBoolean(getFill(instance));
    streamWriter.writeObject(getHideMode(instance));
    streamWriter.writeString(getName(instance));
    
    com.extjs.gxt.ui.client.data.BaseTreeModel_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.diboxku.client.model.Entry_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.diboxku.client.model.Entry_FieldSerializer.deserialize(reader, (com.diboxku.client.model.Entry)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.diboxku.client.model.Entry_FieldSerializer.serialize(writer, (com.diboxku.client.model.Entry)object);
  }
  
}
