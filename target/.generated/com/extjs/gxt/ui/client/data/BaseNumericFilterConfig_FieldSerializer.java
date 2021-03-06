package com.extjs.gxt.ui.client.data;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BaseNumericFilterConfig_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.data.BaseNumericFilterConfig instance) throws SerializationException {
    
    com.extjs.gxt.ui.client.data.BaseFilterConfig_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.extjs.gxt.ui.client.data.BaseNumericFilterConfig instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.extjs.gxt.ui.client.data.BaseNumericFilterConfig();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.data.BaseNumericFilterConfig instance) throws SerializationException {
    
    com.extjs.gxt.ui.client.data.BaseFilterConfig_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.data.BaseNumericFilterConfig_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.data.BaseNumericFilterConfig_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.data.BaseNumericFilterConfig)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.data.BaseNumericFilterConfig_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.data.BaseNumericFilterConfig)object);
  }
  
}
