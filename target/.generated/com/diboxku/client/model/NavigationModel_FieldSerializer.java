package com.diboxku.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NavigationModel_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.diboxku.client.model.NavigationModel instance) throws SerializationException {
    
    com.diboxku.client.model.NavigatorTreeModel_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.diboxku.client.model.NavigationModel instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.diboxku.client.model.NavigationModel();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.diboxku.client.model.NavigationModel instance) throws SerializationException {
    
    com.diboxku.client.model.NavigatorTreeModel_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.diboxku.client.model.NavigationModel_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.diboxku.client.model.NavigationModel_FieldSerializer.deserialize(reader, (com.diboxku.client.model.NavigationModel)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.diboxku.client.model.NavigationModel_FieldSerializer.serialize(writer, (com.diboxku.client.model.NavigationModel)object);
  }
  
}
