package com.diboxku.client.app.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class DiboxkuToolsRpc_Proxy extends RemoteServiceProxy implements com.diboxku.client.app.service.DiboxkuToolsRpcAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.diboxku.client.app.service.DiboxkuToolsRpc";
  private static final String SERIALIZATION_POLICY ="321AC2009E164B1DCEC157EEBB6F08FF";
  private static final com.diboxku.client.app.service.DiboxkuToolsRpc_TypeSerializer SERIALIZER = new com.diboxku.client.app.service.DiboxkuToolsRpc_TypeSerializer();
  
  public DiboxkuToolsRpc_Proxy() {
    super(GWT.getModuleBaseURL(),
      "login", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getUtilDao(java.lang.String kode, java.util.Map map, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("DiboxkuToolsRpc_Proxy", "getUtilDao");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("java.util.Map");
      streamWriter.writeString(kode);
      streamWriter.writeObject(map);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
