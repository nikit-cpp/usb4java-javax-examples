package hotplug;
import javax.usb.*;
import javax.usb.event.*;
public class HotplugListener implements UsbServicesListener {
  public void usbDeviceAttached(UsbServicesEvent event) {
    UsbDevice device = event.getUsbDevice( );
    System.out.println(getDeviceInfo(device) + " was added to the bus.");
  }
  public void usbDeviceDetached(UsbServicesEvent event) {
    UsbDevice device = event.getUsbDevice( );
    System.out.println(getDeviceInfo(device) + " was removed from the bus.");
  }
  private static String getDeviceInfo(UsbDevice device) {
	String ret;
	String id = "id error";
    try {
      id = device.toString();
      String product = device.getProductString( );
      String serial = device.getSerialNumberString( );
      String manufacturer = device.getManufacturerString();
      if (product == null) ret = "Unknown USB device";
      if (serial != null) ret = manufacturer + " " + product + " " + serial;
      else ret = product;
    }
    catch (Exception ex) {
    	ret = "Unknown USB device";
    }
	  
	return ret + " " + id;
  }
}