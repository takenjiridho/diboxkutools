package com.extjs.gxt.ui.client.data;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BaseBooleanFilterConfig_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig_Array_Rank_1_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig_Array_Rank_1_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.data.BaseBooleanFilterConfig[])object);
  }
  
}
