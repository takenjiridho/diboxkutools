package com.extjs.gxt.ui.client.widget.grid.filters;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RangeMenu_RangeItem_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem[] values = com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu_RangeItem_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu_RangeItem_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu_RangeItem_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.widget.grid.filters.RangeMenu.RangeItem)object);
  }
  
}
