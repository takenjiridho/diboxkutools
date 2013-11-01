package com.diboxku.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Folder_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.diboxku.client.model.Folder instance) throws SerializationException {
    
    com.extjs.gxt.ui.client.data.BaseTreeModel_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.diboxku.client.model.Folder instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.diboxku.client.model.Folder();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.diboxku.client.model.Folder instance) throws SerializationException {
    
    com.extjs.gxt.ui.client.data.BaseTreeModel_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.diboxku.client.model.Folder_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.diboxku.client.model.Folder_FieldSerializer.deserialize(reader, (com.diboxku.client.model.Folder)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.diboxku.client.model.Folder_FieldSerializer.serialize(writer, (com.diboxku.client.model.Folder)object);
  }
  
}
