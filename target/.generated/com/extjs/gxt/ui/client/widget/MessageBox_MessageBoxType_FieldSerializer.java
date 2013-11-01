package com.extjs.gxt.ui.client.widget;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MessageBox_MessageBoxType_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType[] values = com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.widget.MessageBox_MessageBoxType_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.MessageBox_MessageBoxType_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.MessageBox_MessageBoxType_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.widget.MessageBox.MessageBoxType)object);
  }
  
}
