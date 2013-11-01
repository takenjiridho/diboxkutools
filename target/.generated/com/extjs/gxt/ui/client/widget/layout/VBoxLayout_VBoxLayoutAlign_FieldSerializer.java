package com.extjs.gxt.ui.client.widget.layout;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class VBoxLayout_VBoxLayoutAlign_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign[] values = com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.widget.layout.VBoxLayout_VBoxLayoutAlign_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.layout.VBoxLayout_VBoxLayoutAlign_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.layout.VBoxLayout_VBoxLayoutAlign_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign)object);
  }
  
}
