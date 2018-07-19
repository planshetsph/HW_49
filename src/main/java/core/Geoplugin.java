package core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geoplugin {
	@SerializedName("geoplugin_request")
	@Expose
	public String geopluginRequest;
	@SerializedName("geoplugin_status")
	@Expose
	public Integer geopluginStatus;
	@SerializedName("geoplugin_delay")
	@Expose
	public String geopluginDelay;
	@SerializedName("geoplugin_credit")
	@Expose
	public String geopluginCredit;
	@SerializedName("geoplugin_city")
	@Expose
	public String geopluginCity;
	@SerializedName("geoplugin_region")
	@Expose
	public String geopluginRegion;
	@SerializedName("geoplugin_regionCode")
	@Expose
	public String geopluginRegionCode;
	@SerializedName("geoplugin_regionName")
	@Expose
	public String geopluginRegionName;
	@SerializedName("geoplugin_areaCode")
	@Expose
	public String geopluginAreaCode;
	@SerializedName("geoplugin_dmaCode")
	@Expose
	public String geopluginDmaCode;
	@SerializedName("geoplugin_countryCode")
	@Expose
	public String geopluginCountryCode;
	@SerializedName("geoplugin_countryName")
	@Expose
	public String geopluginCountryName;
	@SerializedName("geoplugin_currencyCode")
	@Expose
	public String geopluginCurrencyCode;
	@SerializedName("geoplugin_currencySymbol")
	@Expose
	public String geopluginCurrencySymbol;
}
