package GraphCore;

import Model.DataSetModel;

/**
* GraphCore/DataSetDefaultFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from src/GraphCore.idl
* Friday, August 20, 2021 9:59:39 PM CEST
*/

public class DataSetDefaultFactory implements org.omg.CORBA.portable.ValueFactory {

  public java.io.Serializable read_value (org.omg.CORBA_2_3.portable.InputStream is)
  {
    return is.read_value(new DataSetModel ());
  }
}
