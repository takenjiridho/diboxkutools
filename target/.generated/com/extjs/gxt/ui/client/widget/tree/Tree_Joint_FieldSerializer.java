package com.extjs.gxt.ui.client.widget.tree;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Tree_Joint_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getValue(com.extjs.gxt.ui.client.widget.tree.Tree.Joint instance) /*-{
    return instance.@com.extjs.gxt.ui.client.widget.tree.Tree$Joint::value;
  }-*/;
  
  private static native void setValue(com.extjs.gxt.ui.client.widget.tree.Tree.Joint instance, int value) 
  /*-{
    instance.@com.extjs.gxt.ui.client.widget.tree.Tree$Joint::value = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.extjs.gxt.ui.client.widget.tree.Tree.Joint instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.extjs.gxt.ui.client.widget.tree.Tree.Joint instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.extjs.gxt.ui.client.widget.tree.Tree.Joint[] values = com.extjs.gxt.ui.client.widget.tree.Tree.Joint.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.extjs.gxt.ui.client.widget.tree.Tree.Joint instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.extjs.gxt.ui.client.widget.tree.Tree_Joint_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.tree.Tree_Joint_FieldSerializer.deserialize(reader, (com.extjs.gxt.ui.client.widget.tree.Tree.Joint)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.extjs.gxt.ui.client.widget.tree.Tree_Joint_FieldSerializer.serialize(writer, (com.extjs.gxt.ui.client.widget.tree.Tree.Joint)object);
  }
  
}
