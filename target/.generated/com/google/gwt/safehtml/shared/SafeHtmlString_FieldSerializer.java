package com.google.gwt.safehtml.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SafeHtmlString_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getHtml(com.google.gwt.safehtml.shared.SafeHtmlString instance) /*-{
    return instance.@com.google.gwt.safehtml.shared.SafeHtmlString::html;
  }-*/;
  
  private static native void setHtml(com.google.gwt.safehtml.shared.SafeHtmlString instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.safehtml.shared.SafeHtmlString::html = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.safehtml.shared.SafeHtmlString instance) throws SerializationException {
    setHtml(instance, streamReader.readString());
    
  }
  
  public static native com.google.gwt.safehtml.shared.SafeHtmlString instantiate(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @com.google.gwt.safehtml.shared.SafeHtmlString::new()();
  }-*/;
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.safehtml.shared.SafeHtmlString instance) throws SerializationException {
    streamWriter.writeString(getHtml(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.safehtml.shared.SafeHtmlString_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.safehtml.shared.SafeHtmlString_FieldSerializer.deserialize(reader, (com.google.gwt.safehtml.shared.SafeHtmlString)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.safehtml.shared.SafeHtmlString_FieldSerializer.serialize(writer, (com.google.gwt.safehtml.shared.SafeHtmlString)object);
  }
  
}
