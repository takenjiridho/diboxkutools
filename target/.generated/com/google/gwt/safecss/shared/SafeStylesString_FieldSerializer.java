package com.google.gwt.safecss.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SafeStylesString_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCss(com.google.gwt.safecss.shared.SafeStylesString instance) /*-{
    return instance.@com.google.gwt.safecss.shared.SafeStylesString::css;
  }-*/;
  
  private static native void setCss(com.google.gwt.safecss.shared.SafeStylesString instance, java.lang.String value) 
  /*-{
    instance.@com.google.gwt.safecss.shared.SafeStylesString::css = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.safecss.shared.SafeStylesString instance) throws SerializationException {
    setCss(instance, streamReader.readString());
    
  }
  
  public static native com.google.gwt.safecss.shared.SafeStylesString instantiate(SerializationStreamReader streamReader) throws SerializationException /*-{
    return @com.google.gwt.safecss.shared.SafeStylesString::new()();
  }-*/;
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.safecss.shared.SafeStylesString instance) throws SerializationException {
    streamWriter.writeString(getCss(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.safecss.shared.SafeStylesString_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.safecss.shared.SafeStylesString_FieldSerializer.deserialize(reader, (com.google.gwt.safecss.shared.SafeStylesString)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.safecss.shared.SafeStylesString_FieldSerializer.serialize(writer, (com.google.gwt.safecss.shared.SafeStylesString)object);
  }
  
}
