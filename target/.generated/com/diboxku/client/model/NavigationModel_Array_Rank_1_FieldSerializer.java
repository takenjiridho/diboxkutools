package com.diboxku.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NavigationModel_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.diboxku.client.model.NavigationModel[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.diboxku.client.model.NavigationModel[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.diboxku.client.model.NavigationModel[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.diboxku.client.model.NavigationModel[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.diboxku.client.model.NavigationModel_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.diboxku.client.model.NavigationModel_Array_Rank_1_FieldSerializer.deserialize(reader, (com.diboxku.client.model.NavigationModel[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.diboxku.client.model.NavigationModel_Array_Rank_1_FieldSerializer.serialize(writer, (com.diboxku.client.model.NavigationModel[])object);
  }
  
}
